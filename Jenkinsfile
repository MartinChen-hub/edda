def label = "slave-${UUID.randomUUID().toString()}"
podTemplate(label: label,serviceAccount:'jenkins-k8s-sa',containers: [
  containerTemplate(name: 'maven', image: 'maven:3-alpine', command: 'cat', ttyEnabled: true),
  containerTemplate(name: 'docker', image: 'docker', command: 'cat', ttyEnabled: true),
  containerTemplate(name: 'kubectl', image: 'cnych/kubectl', command: 'cat', ttyEnabled: true)
], volumes: [
  hostPathVolume(mountPath: '/root/.m2', hostPath: '/var/run/m2'),
  hostPathVolume(mountPath: '/home/jenkins/.kube', hostPath: '/root/.kube'),
  hostPathVolume(mountPath: '/var/run/docker.sock', hostPath: '/var/run/docker.sock'),
  hostPathVolume(mountPath: '/opt/maven/repository', hostPath: '/opt/maven/repository')
]) {
  node(label) {
    def myRepo = checkout scm
    def gitCommit = myRepo.GIT_COMMIT
    def gitBranch = myRepo.GIT_BRANCH


    def imageTag = "v2.0"
    def dockerRegistryUrl = "docker.io"
    def imageEndpoint1 = "markchen20190628/edda"
    def image1 = "${imageEndpoint1}"



    stage('单元测试') {
      echo "测试阶段"
    }
    stage('代码编译打包') {
      container('maven') {
        sh 'mvn -B -DskipTests clean package'
      }
    }
    stage('构建 Docker 镜像') {
      container('构建 wx-api  Docker 镜像') {
        withCredentials([[$class: 'UsernamePasswordMultiBinding',
          credentialsId: 'dockerhub',
          usernameVariable: 'DOCKER_HUB_USER',
          passwordVariable: 'DOCKER_HUB_PASSWORD']]) {
            container('docker') {
              echo "3. 构建 Docker 镜像阶段"
              sh """
                docker login ${dockerRegistryUrl} -u ${DOCKER_HUB_USER} -p ${DOCKER_HUB_PASSWORD}
                docker build -t ${image1}:${imageTag} .
                docker push ${image1}:${imageTag}
                """
            }
          }
        }
    }
    stage('运行 Kubectl') {
      container('kubectl') {
        sh './jenkins/scripts/k8s-deploy.sh'
      }
    }
  }
}
