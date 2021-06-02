package com.example.demo2;

import com.example.demo2.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Demo2ApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
//        基本上不会这么用，都是自己写一个redisUtil
//        redisTemplate.opsForList();//操作数组，类似list
//        redisTemplate.opsForSet();//操作set，类似set
//        redisTemplate.opsForValue();//操作字符串，类似String
//        redisTemplate.opsForZSet();
//        //除了基本的操作，我们常用的方法都可以直接通过redisTemplate操作，比如事务和基本的CRUD
//        //获取redis的连接对象
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.flushDb();
        redisTemplate.opsForValue().set("key", "value");
        System.out.println(redisTemplate.opsForValue().get("key"));
    }

    @Test
    public void test() throws JsonProcessingException {
        User user = new User("james", 10);
        String jsonUser = new ObjectMapper().writeValueAsString(user);
        //如果直接传对象user，并且user类不implements Serializable，则会报没有序列化的错误
        redisTemplate.opsForValue().set("user", jsonUser);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

}
