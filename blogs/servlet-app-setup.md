# Servlet App SetUp

create a directory called servlet-hello-world. Inside servlet-hello-world, add below changes.
## pom.xml
* create pom.xml under servlet-hello-world directory.
```xml
    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>org.example</groupId>
  <artifactId>servlet-hello-world</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>war</packaging>

  <name>servlet-hello-world Maven Webapp</name>
  <!-- FIXME change it to the project's website -->
  <url>http://www.example.com</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
  </properties>

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
    <!-- https://mvnrepository.com/artifact/javax.servlet/servlet-api -->
      <!-- below is required servlet dependency -->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>servlet-api</artifactId>
      <version>2.5</version>
      <scope>provided</scope>
    </dependency>

  </dependencies>
</project>
```



## Required Directories
create below directories under servlet-hello-world/ directory.
* src/main/java/  for writing java classes that ccontains the actual business logic.
* src/main/webapp/WEB-INF/ for keeping web.xml
* src/main/resources/ for files that should be accessible from classpath during runtime of application.
* src/test/java/ for junit test classes.
* src/test/resources/ for files that should be accessible from classpath during the execution of test cases.


## web.xml
* create web.xml under src/main/webapp/WEB-INF/
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="2.5" xmlns="http://java.sun.com/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">

  <!-- define your configuration-->
  
</web-app>
  
```

## build & deploy (for every code change)
* open a cmd inside the directory servlet-hello-world/
* run the command `mvn clean install`
* under servlet-hello-world/target/ we wcan locate the .war file.
* Copy the .war file to tomcat/webapps/ directory.
* Go to tomcat/bin/ and open cmd. Run `sh catalina.sh jpda run`
