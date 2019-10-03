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
        stage('05-test-driven-development-first-steps') {
            steps {
                bat 'mvn clean test -pl :05-test-driven-development-first-steps'
            }
        }
        stage('10-test-driven-development') {
            steps {
                bat 'mvn clean test -pl :10-test-driven-development'
            }
        }
        stage('20-refactoring-clean-code') {
            steps {
                bat 'mvn clean test -pl :20-refactoring-clean-code'
            }
        }
        stage('10-list') {
            steps {
                bat 'mvn clean test -pl :10-list'
            }
        }
        stage('20-queue') {
            steps {
                bat 'mvn clean test -pl :20-queue'
            }
        }
        stage('30-map') {
            steps {
                bat 'mvn clean test -pl :30-map'
            }
        }
        stage('40-set') {
            steps {
                bat 'mvn clean test -pl :40-set'
            }
        }
        stage('50-combined') {
            steps {
                bat 'mvn clean test -pl :50-combined'
            }
        }
        stage('10-design-principles') {
            steps {
                bat 'mvn clean test -pl :10-design-principles'
            }
        }
    }
}
