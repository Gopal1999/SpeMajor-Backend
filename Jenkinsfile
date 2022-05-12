pipeline {
	agent any 
	environment {
	    MYSQL_HOST="localhost"
	    MYSQL_PORT=3306
	    MYSQL_USER="abhi"
	}	
    stages {
        
        stage('Frontend Git Pull') {
            steps {
				git url: 'https://github.com/abhijain614/SpeMajor-Frontend.git',
				branch: 'main',
                credentialsId: 'github'
            }
        }
        
        
        stage('Frontend build docker image') {
            steps {
                sh 'docker build -t abhijain614/final-frontend:latest .'
            }
        }
        stage('Publish Frontend Docker Image') {
            steps {
                withDockerRegistry([ credentialsId: "mini-project", url: "" ]) {
                    sh 'docker push abhijain614/final-frontend:latest'
                }
            }
        }
        
        
        stage('Backend Git Pull') {
            steps {
				git url: 'https://github.com/Gopal1999/SpeMajor-Backend.git',
				branch: 'main',
                credentialsId: 'github'
            }
        }
        
        stage('Backend Maven Build and Test') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Backend build docker image') {
            steps {
                sh 'docker build -t abhijain614/final-backend:latest .'
            }
        }
        stage('Publish Backend Docker Image') {
            steps {
                withDockerRegistry([ credentialsId: "mini-project", url: "" ]) {
                    sh 'docker push abhijain614/final-backend:latest'
                }
            }
        }
        
        stage('Ansible Deploy') {
                     steps {
                          ansiblePlaybook becomeUser: null, colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'inventory', playbook: 'playbook.yml' ,sudoUser: null
                     }
        }
        
        
    }
    
    post {
        always {
            sh 'docker logout'
        }
    }
}
