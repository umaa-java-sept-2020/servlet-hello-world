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
* Generate response header: Authorization header.
* In next request if you send Authorization header it can identify you.