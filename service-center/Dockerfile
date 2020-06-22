FROM openjdk:11-jdk-stretch
RUN echo -e "Asia/Shanghai" > /etc/timezone
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]