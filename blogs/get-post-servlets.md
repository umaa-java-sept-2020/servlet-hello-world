## Jackson Dependency
```xml 
<dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.9.8</version>
    </dependency>
```
## Object to String JSON
```java 
 private static ObjectMapper mapper = new ObjectMapper();
    public static String toJson(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
```
## String JSON to Object
```java 
public static <T> T toObject(String json, Class<T> t){
        try {
            return mapper.readValue(json, t);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
```
* Install git bash in windows if you dont have to use curl.
* Or Try on powershell of windows for below curl commands
```text
curl \
-X GET \
-H 'Accept:application/json' \
-H 'Authorization:bdsjdhjd' \
http://localhost:8080/servlet-hello-world/employees \
-v

curl \
-X POST \
-H 'Accept:application/json' \
-H 'Authorization:bdsjdhjd' \
http://localhost:8080/servlet-hello-world/employees \
-d '{"uuid":"f15bdddb-cef5-49df-83ba-da396eb5c897","name":"Michael","age":20}' \
-v
```