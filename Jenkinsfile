pipeline {
    agent any

    stages {
        stage('Build Docker Image') {
            steps {
                script {
                    // Build the Docker image using Gradle task
                    sh 'echo $USER'
                    sh './gradlew bootBuildImage'
                }
            }
        }
    }
}