## Servlet Context Params
* ServletContext is one per application.
ServletContext can access key_value based context-param and context-value defined in web.xml
ServletConfig can access the servlet context.
* Any configuration settings if we want to define for the entire application we should use context-params.
* Define context-params in web.xml
```text 
 <context-param>
    <param-name>a_context</param-name>
    <param-value>55</param-value>
  </context-param>
  <context-param>
    <param-name>b_context</param-name>
    <param-value>66</param-value>
  </context-param> 
```
* Define a servlet. Accessing context params using ServletContext
```java 
        String a = getServletConfig().getServletContext().getInitParameter("a_context");
        String b = getServletConfig().getServletContext().getInitParameter("b_context");
```
## Servlet Config Init Params
* Servlet Config is one per servlet. ServletConfig can access its own init-params and values.
* ServletConfig can access ServletContext.
* Any configuration settings if we want for a given servlet only then we should define using servlet init-params.
* Define init-params in web.xml
```text 
<servlet>
    <servlet-name>servletParamsServlet</servlet-name>
    <servlet-class>com.java.servlets.ServletParams</servlet-class>
    <init-param>
      <param-name>x_servlet</param-name>
      <param-value>100</param-value>
    </init-param>
    <init-param>
      <param-name>y_servlet</param-name>
      <param-value>200</param-value>
    </init-param>
  </servlet>

  <servlet-mapping>
    <servlet-name>servletParamsServlet</servlet-name>
    <url-pattern>/params</url-pattern>
  </servlet-mapping>
```
* Define a servlet.Access servlet init-params using ServletConfig
```java 
        String x = getServletConfig().getInitParameter("x_servlet");
        String y = getServletConfig().getInitParameter("y_servlet");
 
```

* The above code can be found in ServletParams class, which is a servlet with endpoint /params.
* Build: `mvn clean install`
* Copy the war to webapps/ of tomcat from target/
* Start the tomcat: `sh catalina.sh run`
* Access the endpoint: `http://localhost:8080/servlet-hello-world/params`
* Watch the logs:
```text 
displaying for methodName: init
x=100,y=200,a=55,b=66

displaying for methodName: doGet
x=100,y=200,a=55,b=66
 
```