* Every servlet request is processed by a thread. Once request is processed the thread won't be killed but it will be returned back to the thread pool.
* Inside `HomeServlet` we can below lines of code to access the current thread with which the servlet request being processed.
```java
Thread currentThread = Thread.currentThread();
System.out.println("current thread: "+currentThread);
```
* Threads can be reused as it is obtained from a `thread pool` managed by the tomcat container.
* Build: `mvn clean install -DskipTests`
* Copy war to webapps from target
* Start tomcat `sh catalina.sh run`
* Acces the endpoint from browser: http://localhost:8080/servlet-hello-world/home
* Watch the logs in the terminal
<img width="1792" alt="Screenshot 2021-08-19 at 9 11 54 PM" src="https://user-images.githubusercontent.com/17001948/130099970-145b90ba-1280-4bb5-997d-2b6b8d242764.png">

* I have sent few more requests to see different threads are being used while processing the request.
