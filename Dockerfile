FROM java:8

EXPOSE 8080

ADD target/openWeatherApp.jar openWeatherApp.jar

ENTRYPOINT ["java", "-jar", "openWeatherApp.jar"]