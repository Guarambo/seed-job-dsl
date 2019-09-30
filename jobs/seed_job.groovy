project_name = "Actividad-2"
url_repo = "git@github.com:Guarambo/seed-job-dsl.git"
repo_name = "seed-job"


folder('Actividad-2') {
    displayName('Actividad 2')
    description('Actividad con WAS')
}

pipelineJob(Actividad-2/project_name) {
    definition {
        triggers {
            scm('H/1 * * * *')
        }

        cpsScn{
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

