pipeline {
    agent any

    options {
        skipDefaultCheckout(true)
        disableConcurrentBuilds()
        timeout(time: 20, unit: 'MINUTES')
    }

    environment {
        IMAGE_NAME = 'zhunisov-gabit-student-api'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                echo 'Student: Zhunisov Gabit'
                sh 'chmod +x gradlew'
            }
        }

        stage('Build') {
            steps {
                sh './gradlew clean assemble --no-daemon'
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test --no-daemon'
            }
            post {
                always {
                    junit 'build/test-results/test/*.xml'
                }
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t "$IMAGE_NAME:ci-$BUILD_NUMBER" .'
            }
        }

        stage('Verify') {
            steps {
                sh 'docker image inspect "$IMAGE_NAME:ci-$BUILD_NUMBER"'
                sh 'docker run --rm --entrypoint java "$IMAGE_NAME:ci-$BUILD_NUMBER" -version'
            }
        }
    }

    post {
        success {
            echo 'Zhunisov Gabit: pipeline completed successfully'
        }
        failure {
            echo 'Zhunisov Gabit: pipeline failed; check the failed stage'
        }
    }
}
