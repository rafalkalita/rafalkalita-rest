rafalkalita-rest

To run build the image:
$ mvn package docker:build
$ docker run --name=rafal-rest --rm -it -p 8080:8080 -t rafalkalita/rafalkalita-rest

Testing.
Run test from:
src/test/groovy/com/rafalkalita/rest/ArticleWebSpecification.groovy

Or manually:
From any REST client send PUT requests:
http://localhost:8080/article?user=test_user1&content=test content1
http://localhost:8080/article?user=test_user2&content=test content2
http://localhost:8080/article?user=test_user2&content=test content3

Send GET request:
http://localhost:8080/article?id=1

Send GET request:
http://localhost:8080/articles?user=test_user2


Tech stack:
- Docker
- Spring Boot
- Spring Data JPA
- JUnit, Mockito
- Spock, Groovy
