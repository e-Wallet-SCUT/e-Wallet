package com.bruceking.main.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;


@Configuration
public class RedisConfiguration {

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {

        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("121.43.191.246", 6379);
        config.setPassword("Aa-12345678");
        return new JedisConnectionFactory(config);
    }

}
