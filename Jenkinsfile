pipeline {
   agent any

   tools {
      // Install the Maven version configured as "M3" and add it to the path.
      maven "M3"
   }
   parameters {
     gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'
    }
    stages {
      stage('Build') {
         steps {
            // Get some code from a GitHub repository
           git branch: "${params.BRANCH}", url: 'https://github.com/softwaredestr/IntegryVideo'
           bat "mvn -Dmaven.test.failure.ignore=true clean test"
         }

         post {
            // If Maven was able to run the tests, even if some of the test
            // failed, record the test results and archive the jar file.
            success {
               junit '**/target/surefire-reports/TEST-*.xml'
            }
         }
      }
   }
}
