package com.priscilla.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories
public class RedisConfig {

//    @Bean
//    public LettuceConnectionFactory redisConnectionFactory() {
//        return new LettuceConnectionFactory();
//    }

//    @Bean
//    public RedisConnectionFactory connectionFactory() {
//        return new JedisConnectionFactory();
//    }
//
//    @Bean
//    public RedisTemplate<?, ?> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//
//        RedisTemplate<byte[], byte[]> template = new RedisTemplate<byte[], byte[]>();
//        template.setConnectionFactory(redisConnectionFactory);
//        return template;
//    }


    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
//        return new JedisConnectionFactory();
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("192.168.1.203", 6379);
        return new JedisConnectionFactory(config);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        redisTemplate.getConnectionFactory().getConnection().flushAll();

        return redisTemplate;
    }


}

