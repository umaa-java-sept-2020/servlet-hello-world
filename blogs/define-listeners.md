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

Build and Deploy the war file into tomcat webapps

