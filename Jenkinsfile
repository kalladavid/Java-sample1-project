pipeline {
    agent any

    tools {
        // Jenkins → Manage Jenkins → Global Tool Configuration లో పెట్టిన పేర్లు
        maven 'Maven-3.6.3'
        jdk   'JDK-21'
    }

    options {
        timestamps()
        disableConcurrentBuilds()
    }

    stages {
        stage('Checkout') {
            steps {
                echo "Checking out code..."
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "Running Maven build..."
                sh 'mvn clean compile'
            }
        }

        stage('Unit Tests') {
            steps {
                echo "Running unit tests..."
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                echo "Packaging jar..."
                sh 'mvn package'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo "✅ Build Success!"
        }
        failure {
            echo "❌ Build Failed!"
        }
    }
}

