## SignUp Application
* Define SignUp Servlet (/signup)
* Store User in a map
* SignUp user using below command. Every time we start the server.
```text 
curl -X POST \
'http://localhost:8080/servlet-hello-world/signup' \
-d '{"email":"john@gmail.com","password":"abc@124","fullName":"John Doe"}'
```
* Define LoginServlet (/login)
* Login Using email and password using below command.
```text 
curl -X POST \
'http://localhost:8080/servlet-hello-world/login' \
-d '{"email":"john@gmail.com","password":"abc@124"}' \
-v
```
* Generate encoded response header: Authorization header.
* On every successful login a new encoded Authorization token should be generated.
* Define expense servlet (/api/expenses) which can be accessed using Authorization header only.
* Below curl command is to access the secured resource or endpoint /api/expenses.
* The endpoint /api/* will be considered as secured.
```text 
curl -X GET \
'http://localhost:8080/servlet-hello-world/api/expenses' \
-v
```
* Define a filter that runs for every request with endpoint as /api/*. This filter should validate the token.
* In next request if you send Authorization header it can identify you.
```text 
curl -X GET \
-H 'Authorization: eyJlbWFpbCI6ImpvaG5AZ21haWwuY29tIiwiZXhwaXJlQXQiOjE2MzEwMjk0NTY3Njl9' \
'http://localhost:8080/servlet-hello-world/api/expenses' \
-v
```
* 403 Forbidden http status: https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/403
* 401 Unauthorized http status: https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/401

# Integrating With JDBC (Java Database Connectivity)
* Download and install mysql 8.x or mariadb 10.x. It runs on port 3306.
* The default username for mysql is root and password is empty (not even any blank string).
* Login command: `mysql -uroot -p`. After this give enter.
* To add password for root user first login to mysql using above command. Then run below command.
```text 
UPDATE mysql.user SET Password=PASSWORD('root_pass') WHERE User='root'; 
FLUSH PRIVILEGES;
```
* Restart mysql.
* Add below mysql dependency in  pom.xml
```xml 
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.47</version>
</dependency> 
```
* Create a file called database.properties under src/main/resources.
* Add below connection details to database.properties
```text 
mysql.database.url= jdbc:mysql://localhost:3306/testdb?createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false
mysql.database.username= root
mysql.database.password= root_pass
```
* Define a class `DatabaseConnectionUtils` to loadDatabaseProperties() and getConnection().
* Getting a JDBC connection is quite easy.
```java 
Connection connection = DriverManager.getConnection(url,username,password);
```
