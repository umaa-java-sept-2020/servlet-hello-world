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
* Define expense servlet which can be accessed using Authorization header only.
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