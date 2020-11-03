FROM centos

RUN yum -y update
RUN yum install -y java-11-openjdk-devel

VOLUME /tmp
ADD /pet-clinic-web/target/pet-clinic-web-*.jar pet-clinic-web.jar
RUN sh -c 'touch /pet-clinic-web.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/pet-clinic-web.jar"]