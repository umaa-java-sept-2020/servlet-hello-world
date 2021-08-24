# Servlet Life Cycle
3 methods are part of the servlet life cycle. It is present in every servlet.
* init: executes only once after the servlet object has been created. recommended to override init with no parameter method.
```java
@Override
public void init() throws ServletException {
        //  super.init();
        System.out.println("method executed: init()");
        } 
```
* service: executes for every http request. recommned to override the service method having parameters of type httpServletRequest and httpServletResponse
```java 
 @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.service(req, resp);
        System.out.println("method executed: service()");

        resp.getWriter().write("service method response");
    }

```
* destroy: executes only once when the servlet object destroyed that is on application shutdown / tomcat shutdown
```java 
 @Override
    public void destroy() {
        //super.destroy();
        System.out.println("method executed: destroy()");
    } 
```

### Steps to implement servlet lifecycle.

Define a servlet called `ServletLifeCycleExample` and override the methods init, service, destroy as explained above.
```java 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletLifeCycleExample extends HttpServlet {

    @Override
    public void init() throws ServletException {
      //  super.init();
        System.out.println("method executed: init()");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.service(req, resp);
        System.out.println("method executed: service()");

        resp.getWriter().write("service method response");
    }

    @Override
    public void destroy() {
        //super.destroy();
        System.out.println("method executed: destroy()");
    }
}

```

Define the servlet mapping in web.xml

```xml 
<servlet>
    <servlet-name>servletLifeCycle</servlet-name>
    <servlet-class>com.java.servlets.ServletLifeCycleExample</servlet-class>
  </servlet>

  <servlet-mapping>
    <servlet-name>servletLifeCycle</servlet-name>
    <url-pattern>/servlet-life-cycle</url-pattern>
  </servlet-mapping>
```

* Build: `mvn clean install`
* Copy war file from target to webapps directory of tomcat.
* Start the tomcat in a terminal with command: `sh catalina.sh run`
* Access the endpoint: http://localhost:8080/servlet-hello-world/servlet-life-cycle
* Observe the logs in the terminal

```text
method executed: init()
method executed: service()
```

* Access the endpoint: http://localhost:8080/servlet-hello-world/servlet-life-cycle
* Observer the logs in the terminal

```text
method executed: service()
```
* see init() executed only once. But service() executed for every http request.

* Now stop the tomcat server.
* Observer the logs in the terminal
```text 
method executed: destroy()
```