pipeline{
    agent{
        label 'Slave_Induccion'
    }

    options{
        buildDiscarder(logRotator(numToKeepStr: '3'))
        disableConcurrentBuilds()
    }

    tools {
        jdk 'JDK11_Centos'
    }

    stages{
        stage('Checkout'){
            steps{
                echo "------------>Checkout<------------"
                checkout([
                    $class: 'GitSCM', 
                    branches: [[name: '*/master']], 
                    doGenerateSubmoduleConfigurations: false, 
                    extensions: [], 
                    gitTool: 'Default', 
                    submoduleCfg: [], 
                    userRemoteConfigs: [[
                        credentialsId: 'GitHub_AlexisCorreaCano', 
                        url:'https://github.com/AlexisCorreaCano/Parqueadero'
                    ]]
                ])
            }
        }

        stage('Build') {
            steps{
                echo "------------>Build<------------"
                sh 'gradle --b ./build.gradle build -x test'
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

        stage('Compile & Unit Tests') {
            steps{
                echo "------------>compile & Unit Tests<------------"
                sh 'chmod +x gradlew'
                sh './gradlew --b ./build.gradle test'
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
            junit 'build/test-results/test/*.xml'
        }

    }


}