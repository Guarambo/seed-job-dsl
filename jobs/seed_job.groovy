folder_name = "Act-2"
project_name = "${folder_name}/Actividad-2"
project_name_java = "practica-java-devops/prueba"
url_repo = "git@github.com:Guarambo/seed-job-dsl.git"
repo_name = "seed-job"


folder(folder_name) {
    displayName('Actividad 2')
    description('Actividad con WAS')
}

folder('practica-java-devops') {
    displayName('practica Java')
    description('prueba de Jenkinsfile')
}

folder('proyecto-checho') {
    displayName('checho haciendo daños')
    description('prueba de Jenkinsfile de checho')
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
    }
}

pipelineJob(project_name_java) {
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
                scriptPath("practica-java-devops/Jenkinsfile")
            }
        }
    }
}

pipelineJob("proyecto-checho/test-1") {
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
                scriptPath("prueba-checho/Jenkinsfile")
            }
        }
    }
}

