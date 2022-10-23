### swagger
- <http://localhost:40701/cdp/swagger-ui/index.html#/>

### swagger json
- <http://localhost:40701/v3/api-docs>

### sample ddl
```
CREATE TABLE SAMPLE (
	ID int IDENTITY (1, 1) NOT NULL,
	NAME varchar(10) COLLATE Korean_Wansung_CI_AS  NULL,
	TITLE varchar(20) COLLATE Korean_Wansung_CI_AS  NULL,
	CONTENTS varchar(200) COLLATE Korean_Wansung_CI_AS NULL,
	TYPE varchar(10) NULL,
	REG_DT date ,
	EDIT_DT date
);
```

### build
```
#1 build 
gradlew clean bootJar

#2
gradlew clean build -x test

exe
java -jar api-application.jar
```
