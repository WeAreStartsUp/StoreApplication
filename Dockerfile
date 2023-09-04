#Build stage

FROM gradle:latest AS BUILD
WORKDIR /usr/app/
COPY . .
RUN gradle build

# Package stage

FROM eclipse-temurin:17-jdk-alpine
ENV JAR_NAME=main-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY --from=BUILD $APP_HOME .
EXPOSE 8080
ENTRYPOINT exec java -jar $APP_HOME/build/libs/$JAR_NAME

#FROM gradle:8.2.1-jdk-alpine AS TEMP_BUILD_IMAGE
#ENV APP_HOME=/usr/app/
#WORKDIR $APP_HOME
#COPY build.gradle settings.gradle src $APP_HOME
#
#COPY gradlew $APP_HOME
##COPY --chown=gradle:gradle . /home/gradle/src
##USER root
##RUN chown -R gradlew /home/gradle/src
#
##RUN gradle build || return 0
##COPY . .
#RUN ./gradlew clean build
#
#FROM eclipse-temurin:17-jdk-alpine
##VOLUME /home/app
#
##COPY build.gradle .
##COPY settings.gradle .
##COPY gradlew .
##COPY gradle gradle
##COPY src src
##RUN ./gradlew build
#
#COPY --from=TEMP_BUILD_IMAGE $APP_HOME/build/libs/main-0.0.1-SNAPSHOT.jar app.jar
#CMD ["java","-jar","/app.jar"]