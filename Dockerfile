FROM openjdk:11-jre-slim
WORKDIR /app

CMD ["java", "-jar", "survey-monkey.jar"]