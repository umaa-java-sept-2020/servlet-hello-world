1. Write a class by extending HttpServlet. Override Service method.
2. Configure Servlet in web.xml

```java
package com.java.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomePageServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  super.service(req, resp);

        System.out.println(this.getClass()+" service");
        resp.getWriter().write("home page");
    }
}

```

```xml

  <servlet>
    <servlet-name>home</servlet-name> 
    <servlet-class>com.java.servlets.HomePageServlet</servlet-class>
  </servlet>

   <servlet-mapping>
    <servlet-name>home</servlet-name>
    <url-pattern>/home</url-pattern> <!-- here /home is the endpoint with which this servlet can be accessible -->
  </servlet-mapping>
```

* Build and deploy the war to tomcat. My war name is servlet-hello-world.war.
* Access the endpoint localhost:8080/servlet-hello-world/home. In this URL `servlet-hello-world` is war name.

<img width="1792" alt="Screenshot 2021-08-15 at 10 59 15 PM" src="https://user-images.githubusercontent.com/17001948/129487109-7419022e-883c-4226-9285-12dfbb1871f0.png">

