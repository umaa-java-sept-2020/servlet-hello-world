
* Servlet Filters are classes that implements filter interface.

* It can execute before the execution of another filter / servlet.

* It can execute after the execution of another filter / servlet.

* It is used for validating and modifying the request.

* It is used for validating and modifying the response.

* Servlet filter(s) execute when the request URL pattern matches the URL pattern of filter.

* In a given application we can have more than one filter class. The order of execution of filters depends on the order of the filter-mapping in `web.xml`.

## Steps to implement filter

1. Define Filter Class.
2. Configure Filter class in web.xml

## Define filter class

```java
package com.java.filters;

import javax.servlet.*;
import java.io.IOException;

public class HomePageRequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       // only time
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
         // every request if url matches (/*)
        System.out.println("before: "+this.getClass());
        // validate request, modify request

        filterChain.doFilter(servletRequest, servletResponse); // next filter , servlet

        // validate / modify response
        System.out.println("after: "+this.getClass());
    }

    @Override
    public void destroy() {

        // one time
    }
}

```

## web.xml
```xml

  <filter>
    <filter-name>homePageFilter</filter-name>
    <filter-class>com.java.filters.HomePageRequestFilter</filter-class>
  </filter>

   <filter-mapping>
    <filter-name>homePageFilter</filter-name>
    <url-pattern>/home</url-pattern>
  </filter-mapping>

```

* Build & Deploy. Access localhost:8080/servlet-hello-world/home
* Watch tomcat/logs access logs.
## Define a generic filter that will execute for every request and before all filters.

* For all requests URL pattern should be /*
* Before all filters meaning, The filter-mapping for such filter must be define ahead of all the filters.

## web.xml

```xml
<filter>
    <filter-name>applicationFilter</filter-name>
    <filter-class>com.java.filters.ApplicationRequestFilter</filter-class>
  </filter>


  <filter>
    <filter-name>homePageFilter</filter-name>
    <filter-class>com.java.filters.HomePageRequestFilter</filter-class>
  </filter>

  <filter-mapping>
    <filter-name>applicationFilter</filter-name>
    <url-pattern>/*</url-pattern> <!-- we want this filter to execute before /home -->
  </filter-mapping>

  <filter-mapping>
    <filter-name>homePageFilter</filter-name>
    <url-pattern>/home</url-pattern>
  </filter-mapping>
```


```java
package com.java.filters;

import javax.servlet.*;
import java.io.IOException;

public class ApplicationRequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       // only time
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
         // every request if url matches (/*)
        System.out.println("before: "+this.getClass());
        // validate request, modify request

        filterChain.doFilter(servletRequest, servletResponse); // next filter , servlet

        // validate / modify response
        System.out.println("after: "+this.getClass());
    }

    @Override
    public void destroy() {

        // one time
    }
}

```
* Browser output while accessing localhost:8080/servlet-hello-world/home 

<img width="1792" alt="Screenshot 2021-08-15 at 11 10 22 PM" src="https://user-images.githubusercontent.com/17001948/129487428-25caa8e8-02b1-4616-8fe5-33d47983dcbb.png">


* Tomcat terminal output. See the order of execution.

<img width="1792" alt="Screenshot 2021-08-15 at 11 13 28 PM" src="https://user-images.githubusercontent.com/17001948/129487507-592cbc65-c903-4713-80f1-057e44ebcab8.png">


before: class com.java.filters.ApplicationRequestFilter

before: class com.java.filters.HomePageRequestFilter

class com.java.servlets.HomePageServlet service

after: class com.java.filters.HomePageRequestFilter

after: class com.java.filters.ApplicationRequestFilter
