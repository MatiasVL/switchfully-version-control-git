pipeline {
    agent any

    tools {
        jdk 'jdk-12.0.2'
    }

    stages {
        stage ('Build') {
            steps {
                bat 'mvn clean test-compile'
            }
        }
        stage ('Unit Tests: 30-methods') {
            steps {
                bat 'mvn clean test -pl :30-methods'
            }
        }
        stage ('Unit Tests: 40-strings') {
            steps {
                bat 'mvn clean test -pl :40-strings'
            }
        }
        stage ('Unit Tests: 50-decision-making') {
            steps {
                bat 'mvn clean test -pl :50-decision-making'
            }
        }
        stage ('Unit Tests: 60-arrays') {
            steps {
                bat 'mvn clean test -pl :60-arrays'
            }
        }
        stage ('Unit Tests: 70-loops') {
            steps {
                bat 'mvn clean test -pl :70-loops'
            }
        }
    }
}
