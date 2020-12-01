def JGITVER_BRANCH_NAME = (BRANCH_NAME as String).replaceAll("[\\s\\-#/\\\\]+", "_").toLowerCase()
pipeline {
    agent any
    triggers {
        GenericTrigger(
            genericVariables: [
                [
                    key: 'pactUrl',
                    value: '$.pactUrl'
                ],
                [
                    key: 'cause',
                    value: '$.cause'
                ]
            ],
            causeString: '$cause',
            regexpFilterText: '$pactUrl',
            printContributedVariables: true,
            printPostContent: true
        )
    }
    environment {
        DEFAULT_BRANCH = 'develop'
    }
    options {
        gitLabConnection('scm-mm')
        buildDiscarder(logRotator(numToKeepStr: '5'))
        disableConcurrentBuilds()
    }
    stages {
       
        stage('Build') {
            steps {
                withMaven(maven: 'Maven', jdk: 'JDK8') {
                    sh 'mvn -B clean verify -U -P prod $MAVEN_PACT_OPTS'
                }
            }
        }
        stage('Analyze') {
            when {
                expression { BRANCH_NAME ==~ /(develop|\d+\.\d+\.\d+)/ }
            }
            steps {
                withSonarQubeEnv('MM Sonar') {
                    withMaven(maven: 'Maven', jdk: 'JDK8') {
                        sh 'mvn -B sonar:sonar -P prod'
                    }
                }
            }
        }
        stage('Release') {
            steps {
                withMaven(maven: 'Maven', jdk: 'JDK8', publisherStrategy: 'EXPLICIT') {
                    sh 'mvn -B clean deploy -U -Dmaven.test.failure.ignore=true -P prod $MAVEN_PACT_OPTS'
                }
            }
        }
        stage('Prepare next release') {
            when {
                expression { BRANCH_NAME ==~ /\d+\.\d+\.0/ }
            }
            steps {
                script {
                    sh "git checkout -b ${DEFAULT_BRANCH} --track origin/${DEFAULT_BRANCH}"
                    def newVersion = sh (
                            script: 'git describe --tags --abbrev=0 | ( IFS=".$IFS" ; read a b c && echo $a.$((b+1)).$c )',
                            returnStdout: true
                    ).trim()
                    sh "git commit --allow-empty -m \"Prepare next version ${newVersion}-SNAPSHOT\""
                    sh "git tag ${newVersion}-SNAPSHOT"
                    sh 'git push'
                    sh 'git push --tags'
                }
            }
        }
         
    }
    post {
        success {
            updateGitlabCommitStatus state: 'success'
        }
        unstable {
            updateGitlabCommitStatus state: 'failed'
        }
        failure {
            updateGitlabCommitStatus state: 'failed'
        }
        always {
            cleanWs()
        }
    }
}
