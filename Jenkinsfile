pipeline {
    agent any

    stages {
        stage('Build Docker Image') {
            steps {
                script {
                    sh './gradlew clean'
                    sh './gradlew bootBuildImage'
                }
            }
        }
    }
}