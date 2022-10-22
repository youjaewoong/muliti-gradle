############################################################
#
# #Docker Build 전, api-application build
# * project 최상단에서 gradlew 명령으로 bould
#   1) > ./gradlew clean
#   2) > ./gradlew api-application:bootJar
#
#
# #Docker Build 및 Push 절차
#
# #private repository login
# docker login -u msa -p jobKorea12## test-repository.jobkorea.co.kr:12000
#
# #docker image build
# docker build --tag test-repository.jobkorea.co.kr:12000/albamon-resume:1.0.0-SNAPSHOT . --no-cache
# docker build --tag albamon-resume:1.0.0-SNAPSHOT . --no-cache
#
# #docker image push
# gidocker push test-repository.jobkorea.co.kr:12000/albamon-resume:1.0.0-SNAPSHOT
#
# #docker run (local)
# docker run --name resume-subdomain -d -p 40301:40301 -e "SPRING_PROFILE=" albamon-resume:1.0.0-SNAPSHOT
#
# #docker run (dev)
# docker run --name resume-subdomain-dev -d -p 40301:40301 -e "SPRING_PROFILE=dev" albamon-resume:1.0.0-SNAPSHOT
#
############################################################


## m1 애플 실리콘에서 arm64 platform 이미지를 요청하지만, 해당 이미지가 존재하지 않아, linux/x86_64 platform 으로 지정하여 pull 합니다.
#FROM --platform=linux/x86_64 767158904020.dkr.ecr.ap-northeast-2.amazonaws.com/base-image/amazoncorretto:11-alpine-jdk-20220716
FROM 767158904020.dkr.ecr.ap-northeast-2.amazonaws.com/base-image/amazoncorretto:11-alpine-jdk-apm-20220924

USER ${USER}
WORKDIR ${APP_HOME}

##
## builder 이미지에서 build/libs/api-application.jar 파일을 app.jar로 복사
COPY --chown=${USER}:${USER} api-application/build/libs/api-application.jar app.jar
##
### 컨테이너 Port 노출 (application.yml의 server.port 번호와 맞춤)
EXPOSE 40701
##
### jar 파일 실행
ENV SPRING_PROFILE default
#ENTRYPOINT [ "sh", "-c", "java -Dspring.profiles.active=${SPRING_PROFILE} -XX:FlightRecorderOptions=stackdepth=256 -Dlog4j2.formatMsgNoLookups=true -jar ${JAVA_OPTS} ${APP_HOME}/app.jar" ]

## DataDog 설정- EKS ConfigMap (JAVA_OPTS)
ENTRYPOINT [ "sh", "-c", "java ${JAVA_OPTS} -jar ${APP_HOME}/app.jar" ]
##

############################################################
#
# @TestConfiguration
#
############################################################
