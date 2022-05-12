pipeline {
	agent any 
	environment {
	    MYSQL_HOST="localhost"
	    MYSQL_PORT=3306
	    MYSQL_USER="gopal"
	}	
    stages {
        
        stage('Frontend Git Pull') {
            steps {
				git url: 'https://github.com/abhijain614/SpeMajor-Frontend.git',
				branch: 'newbranch',
                credentialsId: 'github'
            }
        }
        
        
        stage('Frontend build docker image') {
            steps {
                sh 'docker build -t coolgopalgoyal/majorprojectfrontend:latest .'
            }
        }
        stage('Publish Frontend Docker Image') {
            steps {
                withDockerRegistry([ credentialsId: "dockercred", url: "" ]) {
                    sh 'docker push coolgopalgoyal/majorprojectfrontend:latest'
                }
            }
        }
        
        
        stage('Backend Git Pull') {
            steps {
				git url: 'https://github.com/Gopal1999/SpeMajor-Backend.git',
				branch: 'experiment',
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
                sh 'docker build -t coolgopalgoyal/majorprojectbackend:latest .'
            }
        }
        stage('Publish Backend Docker Image') {
            steps {
                withDockerRegistry([ credentialsId: "dockercred", url: "" ]) {
                    sh 'docker push coolgopalgoyal/majorprojectbackend:latest'
                }
            }
        }
        
        
        
        stage('Project Deploy') {
            steps {
                sh 'docker-compose -f docker-compose.yaml up -d'
            }
        }
        
        
    }
    
    post {
        always {
            sh 'docker logout'
        }
    }
}
