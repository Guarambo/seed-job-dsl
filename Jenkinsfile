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
                 parallel "Scan": {
                    //sh 'mvn clean install sonar:sonar'
                    withSonarQubeEnv('sonarqube') {
                        //sh "${scannerHome}/bin/sonar-scanner"
                        sh "mvn sonar:sonar"
                        
                    }
                    timeout(time: 10, unit: 'MINUTES') {
                        //Sirve para detener la ejecucion si no es Success
                        waitForQualityGate abortPipeline: true
                    } 
                 }, "Build": {
                    sh 'mvn clean install'
                 },
                 failFast: true
            }

            /*steps {
                parallel "Scan": {
                    sh 'mvn sonar:sonar'
                }, "Build": {
                    sh 'mvn clean install'
                },
                failFast: true
            }*/
        }
        stage("Deploy"){
            steps{
                sh 'ssh root@172.18.0.5 pwd'
                //sh 'scp -r dist/angularTestJenkins/* root@172.18.0.4:/usr/share/nginx/html/'
            }
        }
    }
}