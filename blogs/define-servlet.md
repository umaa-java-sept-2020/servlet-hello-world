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

* Build and deploy the war to tomcat
* Access the endpoint localhost:8080/home
