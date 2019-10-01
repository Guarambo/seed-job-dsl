pipeline {
    agent any
    stages {
        stage("checkout"){
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://gitlab.com/codilabs/Ear-Test.git']]])
            }
        }
        stage("Scan & Build"){
            environment {
                scannerHome = tool 'sonar_scanner'
            }

            steps {
                sh 'mvn clean build sonar:sonar'
/*                 withSonarQubeEnv('sonarqube') {
                    sh "${scannerHome}/bin/sonar-scanner"
                }
                */
                timeout(time: 10, unit: 'MINUTES') {
                    //Sirve para detener la ejecucion si no es Success
                    waitForQualityGate abortPipeline: true
                } 
            }
        }
    }
}