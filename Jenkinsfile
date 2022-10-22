pipeline {
    agent any 
    stages {
        stage('SonarQube Analysis') {
            steps {
                sh 'echo ============================================================================'
                sh 'env'
                sh 'echo ============================================================================'
                sh """
                cd $WORKSPACE
                chmod +x $WORKSPACE/gradlew
                """
                script {
                    withSonarQubeEnv() {
                        sh '$WORKSPACE/gradlew sonarqube \
                        -Dsonar.login=9ac4a3c8b179eb97fb59fbf7d9ed3a3a9f558424 \
                        -Dsonar.host.url=https://sqube.01.mgt.iconic.albamon.com \
                        -Dsonar.branch.name=${BRANCH_NAME}'
                    }
                }
            }
        }
    }
}
