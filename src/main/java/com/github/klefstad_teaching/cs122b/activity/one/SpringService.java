package com.github.klefstad_teaching.cs122b.activity.one;

import com.github.klefstad_teaching.cs122b.activity.one.config.SpringServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
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
