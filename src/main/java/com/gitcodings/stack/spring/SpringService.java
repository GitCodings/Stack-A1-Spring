package com.gitcodings.stack.spring;

import com.gitcodings.stack.core.spring.StackService;
import com.gitcodings.stack.spring.config.SpringServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@StackService
@EnableConfigurationProperties({
    SpringServiceConfig.class
})
public class SpringService
{
    public static void main(String[] args)
    {
        SpringApplication.run(SpringService.class, args);
    }
}
