# DWGettingStarted

How to start the DWGettingStarted application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/DWGettingStarted-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

## Greetings Rest API

What this app can do:
---

1. return a default greeting @ `http://localhost:8080/hello`
2. return a greeting with a name in the path @ `http://localhost:8080/hello/path_name/{name}` where you replace {name} with your name.
3. return a greeting with a name as a query param @ `http://localhost:8080/hello/query_name?name=yourNameHere` where you replace yourNameHere with your name.
4. return a greeting in JSON format @ `http://localhost:8080/hello/hello_json`
