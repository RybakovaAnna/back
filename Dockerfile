# stage 1
FROM maven:3.8.4-openjdk-17 as build

COPY . /usr/src/myapp
COPY pom.xml /usr/src/myapp
WORKDIR /usr/src/myapp

RUN mvn clean package -DskipTests -e -X package

# stage 2
FROM openjdk:17

ARG JAVA_PARAM="-Xms256M -Xmx1024M -XX:+UseG1GC"
ENV JAVA_PARAM=$JAVA_PARAM

WORKDIR /opt/app
COPY --from=build /usr/src/myapp/target/*.jar /opt/app/app.jar

RUN chown nobody -R /opt/app
USER 65534
ENV PATH=$PATH:/opt/app
EXPOSE 8080

CMD ["sh", "-c", "java ${JAVA_PARAM} -Dserver.port=8080 -jar /opt/app/app.jar"]
