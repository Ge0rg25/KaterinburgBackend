FROM openjdk
COPY ./build/libs/Katerinburg-0.0.1-SNAPSHOT.jar /app/start.jar
WORKDIR /app
VOLUME /app/photos
ENTRYPOINT ["java", "-jar", "/app/start.jar"]