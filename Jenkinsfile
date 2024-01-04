pipeline {
    agent any

    environment {
        // Define the Docker image name and tag
        DOCKER_IMAGE = 'tolani98/my-app'
        DOCKER_TAG = 'latest'
    }

    stages {

        stage('Build Gradle') {
            steps {
                script {
                    sh './gradlew clean'
                    sh './gradlew build'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Building the Docker image
                    sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                    // Login to Docker Hub
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKERHUB_USER', passwordVariable: 'DOCKERHUB_PASS')]) {
                        sh "echo $DOCKERHUB_PASS | docker login --username $DOCKERHUB_USER --password-stdin"
                    }
                    // Push the Docker image
                    sh "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}"
                }
            }
        }
    }

    post {
        always {
            // Optional: Step to clean up after the build
            sh "docker logout"
        }
    }
}
