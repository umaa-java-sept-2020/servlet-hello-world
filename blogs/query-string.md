# Query Strings
* These are additional(optional : not mandatory) information passed along with the request URL.
Example:
```text 
http://localhost:8080/servlet-hello-world/query?id=10,20&name=sachin,rahul&age=47
```
Here id = 10,20 |
name= sachin, rahul |
age = 47

* One key can hold multiple values.

* From request object, we can access using key value as below.
```java 
        System.out.println("access as key_value");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String age = req.getParameter("age");

        System.out.println("id= " + id + " name= " + name + " age=" + age);

```
* From request object we can access as map
```java
 System.out.println("access using map");
        Map<String, String[]> map = req.getParameterMap();
        for (Map.Entry<String, String[] > entry : map.entrySet()) {
        System.out.println("key: " + entry.getKey());
        System.out.println("values: "+ entry.getValue());
        System.out.println("values: "+ Arrays.toString(entry.getValue()));
        } 
```
* If any key is not presnet then the value will be null. (not empty string)

Define Servlet
## Steps to implement QueryString
```java
package com.java.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class QueryStringServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  super.doGet(req, resp);
        accessAsKeyValue(req);
        accessUsingMap(req);

        resp.getWriter().write("doGet executed");
    }

    private void accessAsKeyValue(HttpServletRequest req) {
        System.out.println("access as key_value");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String age = req.getParameter("age");

        System.out.println("id= " + id + " name= " + name + " age=" + age);
    }

    private void accessUsingMap(HttpServletRequest req) {
        System.out.println("access using map");
        Map<String, String[]> map = req.getParameterMap();
        for (Map.Entry<String, String[] > entry : map.entrySet()) {
            System.out.println("key: " + entry.getKey());
            System.out.println("values: "+ entry.getValue());
            System.out.println("values: "+ Arrays.toString(entry.getValue()));
        }
    }
}

```

Define Servlet Mapping in web.xml

```xml 

  <servlet>
    <servlet-name>queryStringServlet</servlet-name>
    <servlet-class>com.java.servlets.QueryStringServlet</servlet-class>
  </servlet>

  <servlet-mapping>
    <servlet-name>queryStringServlet</servlet-name>
    <url-pattern>/query</url-pattern>
  </servlet-mapping>
```
* Build: `mvn clean install`
* Copy war file from target to webapps directory of tomcat.
* Start the tomcat in a terminal with command: `sh catalina.sh run`
* Access the endpoint:http://localhost:8080/servlet-hello-world/query?id=10,20&name=sachin,rahul&age=47
* Observe the logs in the terminal

```text
access as key_value
id= 10,20 name= sachin,rahul age=47
access using map
key: id
values: [Ljava.lang.String;@35802377
values: [10,20]
key: name
values: [Ljava.lang.String;@3b47cbb7
values: [sachin,rahul]
key: age
values: [Ljava.lang.String;@3f784807
values: [47]

```