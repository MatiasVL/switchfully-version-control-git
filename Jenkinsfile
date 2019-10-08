pipeline {
    agent any

    tools {
        jdk 'jdk-12.0.2'
    }

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean test-compile'
            }
        }
        stage('10-programming-fundamentals-java') {
            steps {
                bat 'mvn clean test -pl :10-programming-fundamentals-java'
            }
        }
        stage('20-programming-advanced-java') {
            steps {
                bat 'mvn clean test -pl :20-programming-advanced-java'
            }
        }
    }
}
