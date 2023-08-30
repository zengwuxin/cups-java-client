FROM registry.access.redhat.com/ubi9/openjdk-11:1.15-3
USER root
RUN microdnf install -y cups-client && \
    microdnf clean all
RUN mkdir /etc/cups/
RUN echo -en "ServerName cups.cups.svc.cluster.local:6631\n" >> /etc/cups/client.conf
RUN echo -en "DigestOptions DenyMD5\n" >> /etc/cups/client.conf
COPY ./out/artifacts/cups_java_client_jar/cups-java-client.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "cups-java-client.jar"]