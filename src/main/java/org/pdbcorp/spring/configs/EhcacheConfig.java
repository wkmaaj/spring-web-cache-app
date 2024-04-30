package org.pdbcorp.spring.configs;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class EhcacheConfig {

    @Bean
    public KeyGenerator multiplyKeyGenerator() {
        return (Object target, Method method, Object... params) -> String.format("%s_%s", method.getName(),
                Arrays.toString(params));
    }
}
