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
        stage('Unit Tests: 30-methods') {
            steps {
                bat 'mvn clean test -pl :30-methods'
            }
        }
        stage('Unit Tests: 40-strings') {
            steps {
                bat 'mvn clean test -pl :40-strings'
            }
        }
        stage('Unit Tests: 50-decision-making') {
            steps {
                bat 'mvn clean test -pl :50-decision-making'
            }
        }
        stage('Unit Tests: 60-arrays') {
            steps {
                bat 'mvn clean test -pl :60-arrays'
            }
        }
        stage('Unit Tests: 70-loops') {
            steps {
                bat 'mvn clean test -pl :70-loops'
            }
        }
        stage('Unit Tests: 10-objects') {
            steps {
                bat 'mvn clean test -pl :10-objects'
            }
        }
        stage('Unit Tests: 20-objects-in-depth') {
            steps {
                bat 'mvn clean test -pl :20-objects-in-depth'
            }
        }
        stage('Unit Tests: 30-classes') {
            steps {
                bat 'mvn clean test -pl :30-classes'
            }
        }
        stage('Unit Tests: 40-static-class-members') {
            steps {
                bat 'mvn clean test -pl :40-static-class-members'
            }
        }
        stage('Unit Tests: 50-enum') {
            steps {
                bat 'mvn clean test -pl :50-enum'
            }
        }
        stage('10-inheritance') {
            steps {
                bat 'mvn clean test -pl :10-inheritance'
            }
        }
        stage('20-inheritance') {
            steps {
                bat 'mvn clean test -pl :20-composition'
            }
        }
        stage('30-polymorphism') {
            steps {
                bat 'mvn clean test -pl :30-polymorphism'
            }
        }
        stage('40-abstract-classes') {
            steps {
                bat 'mvn clean test -pl :40-abstract-classes'
            }
        }
        stage('50-interfaces') {
            steps {
                bat 'mvn clean test -pl :50-interfaces'
            }
        }
        stage('60-combined-codelabs') {
            steps {
                bat 'mvn clean test -pl :60-combined-codelabs'
            }
        }
    }
}
