# CS122B Activity 0 - Spring

[Creating An Application](#creating-an-application)
[Creating Endpoints](#creating-endpoints)
[Result](#result)
[Config](#config)

## Creating An Application

```java
package com.example;

@SpringBootApplication
public class SpringService
{
    public static void main(String[] args)
    {
        SpringApplication.run(SpringService.class, args);
    }
}
```

## Creating Endpoints

### Basic Endpoint

```java
package com.example.rest;

@RestController
public class MyApiController
{
    @GetMapping("/hello")
    public String helloWorld()
    {
        return "Hello world";
    }
}
```

### Using ResponseEntity

```java
package com.example.rest;

@RestController
public class MyApiController
{
    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld()
    {
        return ResponseEntity.status(HttpStatus.OK)
                             .body("Hello World");
    }
}
```

### Taking Query Arguments

```java
package com.example.rest;

@RestController
public class MyApiController
{
    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld(@RequestParam String name)
    {
        return ResponseEntity.status(HttpStatus.OK)
                             .body("Hello " + name + "!");
    }
}
```

### Taking Path Arguments

```java
package com.example.rest;

@RestController
public class MyApiController
{
    @GetMapping("/hello/{name}")
    public ResponseEntity<String> helloWorld(@PathVariable String name)
    {
        return ResponseEntity.status(HttpStatus.OK)
                             .body("Hello " + name + "!");
    }
}
```

### Taking a JSON Body Argument

```java
package com.example.model.request;

public class PojoRequestModel
{
    private Integer name;
    
    public Integer getName() { return name; }
    
    public void setName(Integer name) { this.name = name; }
    
}
```
Maps to:
```json
{
    "name": "Example Name"
}
```

```java
package com.example.rest;

@RestController
public class MyApiController
{
    @PostMapping("/hello")
    public ResponseEntity<String> helloWorld(@RequestBody PojoRequestModel request)
    {
        return ResponseEntity.status(HttpStatus.OK)
                             .body("Hello " + request.getName() + "!");
    }
}
```

### Returning a JSON Body

```java
package com.example.model.response;

public class PojoResponseModel
{
    private Integer name;
    
    public Integer getName() { return name; }
    
    public void setName(Integer name) { this.name = name; }
    
}
```
Maps to:
```json
{
    "name": "Example Name"
}
```

```java
package com.example.rest;

@RestController
public class MyApiController
{
    @GetMapping("/hello")
    public ResponseEntity<PojoResponseModel> helloWorld()
    {
        PojoResponseModel response = new PojoResponseModel();
        response.setName("Example");
        
        return ResponseEntity.status(HttpStatus.OK)
                             .body(response);
    }
}
```

## Result

### Exiting early

In the cases where you need to exit early and the only thing that needs to be returned is a `Result` you can throw a `ResultError` with the correct `Result` as a argument and it will automatically return the correct `Result` and `HttpStatus` to the user.

This is made for our convience for this project.

```java
package com.example.rest;

@GetMapping("/result/sum")
public ResponseEntity<ResultSuccessResponse> detail(
    @RequestParam("numX") Integer numX,
    @RequestParam("numY") Integer numY)
{
    if (numX < 0 || numY < 0) {
        throw new ResultError(BasicResults.DATA_CONTAINS_INVALID_INTEGERS);
    }
    ...
}
```

### Using ResponseModel

Since all of our Responses will require a `Result` we can go ahead and just extend the provided `ResponseModel` abstract class which comes with the `Result` varaible and corrosponding getter and setter already implemented. This also comes with a convient `toResponse()` method that will automatically create a `ResponseEntity` with the `ResponseModel` as the body and the `HttpStatus` in `Result` as the status.

```java
package com.example.rest;

@GetMapping("/result/sum")
public ResponseEntity<ResultSuccessResponse> detail(
    @RequestParam("numX") Integer numX,
    @RequestParam("numY") Integer numY)
{
    if (numX < 0 || numY < 0) {
        throw new ResultError(BasicResults.DATA_CONTAINS_INVALID_INTEGERS);
    }

    ResultSuccessResponse response  = new ResultSuccessResponse()
        .setResult(BasicResults.CALCULATION_SUCCESSFUL)
        .setSum(numX + numY);

    return response.toResponse();
}
```


## Config

You can take custom parameters from your `application.yml` file and map them to a class marked with `@ConfigurationProperties(prefix = <your config prefix>)` annotation.

```yml
config:
  default-hello: "Hello World!"
``` 

Maps automatically to:

```java
@ConstructorBinding // Tells spring to use the constructor rather than setters
@ConfigurationProperties(prefix = "config")
public class SpringServiceConfig
{
    private final String defaultHello;

    public SpringServiceConfig(String defaultHello)
    {
        this.defaultHello = defaultHello;
    }

    public String getDefaultHello()
    {
        return defaultHello;
    }
}
``` 
