package com.gitcodings.stack.spring.rest;

import com.gitcodings.stack.spring.config.SpringServiceConfig;
import com.gitcodings.stack.spring.model.request.HelloFavoriteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class HelloController
{
    private final SpringServiceConfig config;

    /**
     * One of the main advantages of spring is its dependency injections. We will not need to go
     * into much of this in this course but one thing we will request from this is the config file
     * we created. Our {@link SpringServiceConfig} has an annotation on it {@link
     * ConfigurationProperties} which means Spring will automatically create a single instance of
     * this class and will map all of our custom config properties into it. When we want to use it
     * all we have to do is have a constructor with the {@link Autowired} annotation. In a class
     * marked as either {@link RestController} or {@link Component} with our {@link
     * SpringServiceConfig} as one of the arguments.
     * <p>
     * <b>Note:</b> Using {@link Autowired} only works when you let spring create the instance for
     * you. It will not work if you create the instance for your.
     *
     * @param config an instance of SpringServiceConfig
     */
    @Autowired
    public HelloController(SpringServiceConfig config)
    {
        this.config = config;
    }

    /**
     * Standard Endpoint that takes no inputs and returns a simple {@link ResponseEntity} with a
     * body of type {@link String}
     *
     * @return ResponseEntity
     */
    @GetMapping("/hello")
    public ResponseEntity<String> hello()
    {
        return ResponseEntity.status(HttpStatus.OK)
                             .body("Hello World!");
    }

    /**
     * An Endpoint that takes a single input in the form of the path variable in place of {name} For
     * Example: {@code "/hello/name/John"} would have the {@code String name} be set to "John"
     *
     * @param name the path variable in place of {name}
     * @return ResponseEntity
     */
    @GetMapping("/hello/name/{name}")
    public ResponseEntity<String> helloName(
        @PathVariable String name)
    {
        return ResponseEntity.status(HttpStatus.OK)
                             .body("Hello " + name + "!");
    }

    /**
     * An Endpoint that takes two inputs in the form of <b>Queries</b>
     * <p>
     * For Example:
     * <p>
     * {@code "/hello/fullName?firstName=John"}
     * <p>
     * Would have the {@code String firstName} be set to "John"
     * <p>
     * {@code "/hello/fullName?firstName=John&lastName=Smith"}
     * <p>
     * would have the {@code String firstName} be set to "John" and {@code String lastName} be set
     * to "Smith"
     * <p>
     * <b>Note:</b> Having a {@code @RequestParam} of an {@code Optional<T>} makes the query param
     * optional. If it is not an Optional then it is required by default
     *
     * @param firstName the value assigned to the query firstname
     * @param lastName  the value assigned to the query firstname
     * @return ResponseEntity
     */
    @GetMapping("/hello/fullName")
    public ResponseEntity<String> helloFullName(
        @RequestParam String firstName,
        @RequestParam Optional<String> lastName)
    {
        String fullName = lastName
            .map(s -> firstName + ' ' + s)
            .orElse(firstName);

        return ResponseEntity.status(HttpStatus.OK)
                             .body("Hello " + fullName + "!");
    }

    /**
     * An Endpoint that list <b>Queries</b> as a Pojo rather than multiple inputs
     * <p>
     * <b>Note</b> This is not the same as a JSON Request, notice the absence of the
     * {@code @RequestBody} annotation.
     * <p>
     * The main advantage of this is being able to have a large amount of queries organized into a
     * Pojo and make all queries <b>optional</b> by default rather than required (without the need
     * for having them all be {@code Optional} types
     *
     * @param request the list of queries as a Pojo
     * @return ResponseEntity
     */
    @GetMapping("/hello/favorite")
    public ResponseEntity<String> helloFavorite(HelloFavoriteRequest request)
    {
        return ResponseEntity.status(HttpStatus.OK)
                             .body(request.toMessage());
    }

    /**
     * Standard Endpoint that takes no inputs and returns a simple {@link ResponseEntity} with a
     * body of type {@link String} with the default message found in config.
     *
     * @return ResponseEntity
     */
    @GetMapping("/hello/default")
    public ResponseEntity<String> helloDefault()
    {
        return ResponseEntity.status(HttpStatus.OK)
                             .body(config.getDefaultHello());
    }
}
