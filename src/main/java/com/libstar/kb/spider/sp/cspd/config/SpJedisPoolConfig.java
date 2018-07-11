package com.libstar.kb.spider.sp.cspd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import us.codecraft.webmagic.scheduler.RedisScheduler;

/**
 * @author itguang
 * @create 2018-07-02 9:37
 **/
@Configuration
public class SpJedisPoolConfig {

    String host = "127.0.0.1";

    int port = 6379;

    int timeout = 60 * 60 * 1000;

    String password;

    int database = 1;

    String clientName = "cspd_";


    @Bean(name = "jedisPool")
    public JedisPool getJedisPool() {

        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), host, port, timeout, password, database, clientName);
        return jedisPool;
    }

    @Bean(name = "redisScheduler")
    public RedisScheduler getRedisScheduler(JedisPool jedisPool){

        RedisScheduler redisScheduler = new RedisScheduler(jedisPool);

        return redisScheduler;
    }


}
