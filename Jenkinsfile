pipeline {
  agent {
    label 'with-git-cli-credentials'
  }
  options {
    timestamps()
    disableConcurrentBuilds()
    buildDiscarder(logRotator(numToKeepStr: '5'))
  }
  stages {
    stage('Build') {
      steps {
        withMaven(maven: '3.9.16', jdk: 'JDK 25', mavenSettingsConfig: 'e387da13-5923-4f59-9776-e39d6eaf138b', options: [artifactsPublisher(disabled: true)]) {
          sh 'mvn -B -f poreid/pom.xml clean verify'
        }
      }
    }
    stage('Release') {
      when {
        triggeredBy 'UserIdCause'
      }
      steps {
        sh 'git checkout -B "$BRANCH_NAME"'
        withMaven(maven: '3.9.16', jdk: 'JDK 25', mavenSettingsConfig: 'e387da13-5923-4f59-9776-e39d6eaf138b', options: [artifactsPublisher(disabled: true)]) {
          sh 'mvn -B -f poreid/pom.xml release:prepare release:perform'
        }
        sshagent(['jenkins-user-ssh-private-key']) {
          sh 'git push git@github.com:Cosium/poreid.git "HEAD:$BRANCH_NAME"'
          sh 'git push git@github.com:Cosium/poreid.git "HEAD:$BRANCH_NAME" --tags'
        }
      }
    }
  }
}
