FROM ghcr.io/agungdh/chiseled-runtimes/java:27-ubuntu26.10

COPY --chown=10001:10001 target/app.jar /app/app.jar

EXPOSE 7070
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
