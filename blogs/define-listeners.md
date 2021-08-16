## Servlet Listeners
Servlet Listeners executes when a specific event happens. Below are the interfaces for listeners.
* ServletContextListener: execute onStart and onStop of the application
* ServletRequestListener: execute when request created and destroyed.
* ServletContextAttributeListener: execute when ServletContextAttribute added, removed, replaced.
* ServletRequestAttributeListener: execute when ServletRequestAttribute added, removed, replaced.


We will concentrate on the implementation of ServletContextListener and ServletRequestListener.

2 Steps to use listeners in our application.
1. Define listener class.
2. Configure listener class in web.xml.

## Define Listener Class Implementation for ServletContextListener
```java
package com.java.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * executes on start and on stop of the application
 */
public class AppContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("context initialized "+this.getClass());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("context destroyed "+this.getClass());
    }
}

```
## Configure listener class in web.xml.
```xml
  
  <listener>
    <listener-class>com.java.listeners.AppContextListener</listener-class>
  </listener>

```
Now we will define one more listener.
## Define Listener Class Implementation for ServletRequestListener

```java
package com.java.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * this executes when a request comes and processed irrespective of URL pattern of the request.
 */
public class RequestContextListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("request destroyed "+this.getClass());
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("request initialized "+this.getClass());
    }
}

```
## Configure listener class in web.xml.
```xml
  <listener>
    <listener-class>com.java.listeners.RequestContextListener</listener-class>
  </listener>
```

Build and Deploy the war file into tomcat webapps. Watch the tomcat logs on the terminal.

* Screenshot of tomcat logs shows that AppContextListener executed onStartUp of the application.
<img width="1792" alt="Screenshot 2021-08-16 at 11 44 16 AM" src="https://user-images.githubusercontent.com/17001948/129519252-22c4a816-cd28-41a6-8b99-53e25876a11f.png">

* Access the endpoint: http://localhost:8080/servlet-hello-world/home. Below Screenshot of logs show that for every request the RequestContextListener getting executed that includes both initialized and destroyed.
<img width="1792" alt="Screenshot 2021-08-16 at 11 47 31 AM" src="https://user-images.githubusercontent.com/17001948/129519542-adb76c7e-2b7b-4242-b6b4-379dd161dbaf.png">



