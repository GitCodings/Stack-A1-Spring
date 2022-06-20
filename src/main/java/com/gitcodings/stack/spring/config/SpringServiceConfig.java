package com.gitcodings.stack.spring.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/**
 * The {@link ConstructorBinding} tells spring to use the constructor named arguments to map the
 * properties to the class. This is useful when you want to make the properties {@code final}
 * <p>
 * The {@link ConfigurationProperties} tells spring under what property to find the values, for
 * example:
 * <p>
 * <pre>
 * basic:
 *     default-hello:
 * </pre>
 * having the prefix 'basic' in {@link ConfigurationProperties} tells spring to look for the values
 * underneath this key. In this case we expect our constructor to have a value called {@code
 * defaultHello}.
 */
@ConstructorBinding
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
