# javalin-jre27-test

Javalin hello world minimal, dijalankan di JRE 27.

- JDK: Temurin 27.0.1.1+4
- Javalin: 7.3.0 (Jetty 12, EE10 Servlet)
- Build tool: Maven (tanpa wrapper, pakai `mvn` system)
- Image runtime: `ghcr.io/agungdh/chiseled-runtimes/java:27-ubuntu26.10` (Liberica JRE 27)

## Struktur

```
pom.xml
Dockerfile
.github/workflows/build.yml
src/main/java/App.java
```

## Build

Fat jar (semua dependency sudah di dalam):

```bash
mvn -B -DskipTests package
```

Hasilnya `target/app.jar`.

## Menjalankan

```bash
java -jar target/app.jar
```

Lalu buka http://localhost:7070 — response-nya `Hello World`.

## Docker

```bash
docker build -t javalin-jre27-test .
docker run --rm -p 7070:7070 javalin-jre27-test
```

Atau pakai image dari GHCR:

```bash
docker pull ghcr.io/agungdh/javalin-jre27-test:latest
docker run --rm -p 7070:7070 ghcr.io/agungdh/javalin-jre27-test:latest
```

Image di-push hanya saat push ke `main`, dengan tag `latest` dan `<commit-sha>`.

Timezone container di-set ke `Asia/Jakarta` lewat `ENV TZ` (base image memakai `TZ=UTC`,
kita override). `TZ` adalah mekanisme OS-level yang dibaca JVM saat startup, jadi tidak
perlu `-Duser.timezone`. Override saat run: `docker run -e TZ=UTC -p 7070:7070 javalin-jre27-test`.

## CI

Workflow `.github/workflows/build.yml` (push ke `main`, pull request, manual):

1. Build jar dengan Maven (test di-skip).
2. Upload `target/app.jar` sebagai artifact `app-jar`.
3. Build image Docker dan push ke GHCR (kecuali di pull request).

## Catatan

Test build/package sengaja tidak dijalankan di lokal; validasi dilakukan di GitHub Actions.
