pipeline{
    agent{
        label 'Slave_Mac'
    }

    options{
        buildDiscarder(logRotator(numToKeepStr: '3'))
        disableConcurrentBuilds()
    }

    tools {
        jdk 'JDK8_Mac' //Preinstalada en la Configuración del Master
    }

    stages{

        stage('Build') {
            steps{
                echo "------------>Build<------------"
                sh './gradlew clean build -x test'
            }
        }

        stage('Unit Tests') {
            steps{
                echo "------------>Unit Tests<------------"
                sh 'chmod +x gradlew'
                sh './gradlew clean'
                sh './gradlew test'
            }
        }

        stage('Static Code Analysis') {
            steps{
                echo '------------>Análisis de código estático<------------'
                withSonarQubeEnv('Sonar') {
                    sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
                }
            }
        }
    }

    post {
        failure {
            echo '----------->Fail<------------'
            mail (to: 'alexis.correa@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
        }

        success {
			echo 'This will run only if successful'
            junit 'domain/build/test-results/**/*.xml'
        }

    }


}