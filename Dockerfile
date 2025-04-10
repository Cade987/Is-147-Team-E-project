 FROM openjdk:23
 WORKDIR /app
 COPY src/ /app/
 RUN javac *.java
 CMD ["java", "Is-147-Team-E-project"]