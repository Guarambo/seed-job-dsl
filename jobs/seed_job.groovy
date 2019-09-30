//folder_name = "Act-2"
project_name = "Act-2/Actividad-2"
url_repo = "git@github.com:Guarambo/seed-job-dsl.git"
repo_name = "seed-job"


folder('Act-2') {
    displayName('Actividad 2')
    description('Actividad con WAS')
}

pipelineJob(project_name) {
    definition {
        triggers {
            scm('H/1 * * * *')
        }

        cpsScm{
            scm {
                git {
                    remote {
                        name(repo_name)
                        url(url_repo)
                    }
                }
                scriptPath("Jenkinsfile")
            }
        }

        cps {
            script {
                pipeline {
                    agent any
                    stages {
                        stage("imprimir"){
                            steps {
                                sh 'echo hola mundo'
                            }
                        }
                    }
                }
            }
        }
    }
}

