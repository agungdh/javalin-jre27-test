# javalin-jre27-test

Javalin hello world minimal, dijalankan di JRE 27.

- JDK: Temurin 27.0.1.1+4
- Javalin: 7.3.0 (Jetty 12, EE10 Servlet)
- Build tool: Maven (tanpa wrapper, pakai `mvn` system)

## Struktur

```
pom.xml
src/main/java/App.java
```

## Menjalankan

```bash
mvn compile exec:java
```

Lalu buka http://localhost:7070 — response-nya `Hello World`.

## Catatan

Test build/package sengaja tidak dijalankan.
