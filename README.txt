rafalkalita-rest

To run build the image:
$ mvn package docker:build
$ docker run -p 8080:8080 -t rafalkalita/rafalkalita-rest

Test by hitting the link:
http://localhost:8080/article?id=2
http://localhost:8080


Stack:
- Docker
- Spring Boot
- JUnit, Mockito
