FROM fabric8/java-centos-openjdk8-jre

ENV JAVA_APP_JAR tinyapp.jar
ENV AB_ENABLED off
ENV AB_JOLOKIA_AUTH_OPENSHIFT true
ENV JAVA_OPTIONS -Xmx256m -Djava.security.egd=file:///dev/./urandom

EXPOSE 8080

ADD target/tinyapp.jar /deployments/