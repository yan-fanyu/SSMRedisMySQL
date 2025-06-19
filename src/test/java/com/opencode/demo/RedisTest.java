package com.opencode.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootTest
public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;



    @Test
    public void stringTest(){
        String name = stringRedisTemplate.opsForValue().get("name");
        System.out.println("name = " + name);
    }

    @Test
    public void hashTest(){
        stringRedisTemplate.opsForHash().put("id1", "name", "nancy");
        stringRedisTemplate.opsForHash().put("id1", "age", "18");
        Map<Object, Object> id1 = stringRedisTemplate.opsForHash().entries("id1");
        System.out.println(id1);

    }



    @Test
    public void listTest(){
        String key = "list1";
        stringRedisTemplate.delete(key);
        stringRedisTemplate.opsForList().leftPush(key, "1");
        stringRedisTemplate.opsForList().leftPush(key, "2");
        stringRedisTemplate.opsForList().leftPush(key, "3");
        stringRedisTemplate.opsForList().rightPush(key, "4");
        stringRedisTemplate.opsForList().set(key, -1, "10");
        List<String> list = stringRedisTemplate.opsForList().range(key, 0, -1);
        String list0 = stringRedisTemplate.opsForList().index(key, -2);
        System.out.println(list);
        System.out.println(list0);
    }


    @Test
    public void setTest(){
        stringRedisTemplate.opsForSet().add("student", "age", "name");
        stringRedisTemplate.opsForSet().add("student", "name", "height");
        Set<String> student = stringRedisTemplate.opsForSet().members("student");
        System.out.println(student.size());
        System.out.println(student);
    }

    @Test
    public void zsetTest(){
        String key = "zset1";
        stringRedisTemplate.delete(key);
        stringRedisTemplate.opsForZSet().add(key, "age", 10.0D);
        stringRedisTemplate.opsForZSet().add(key, "name", 1);
        stringRedisTemplate.opsForZSet().add(key, "height", -10);
        Set<String> student = stringRedisTemplate.opsForZSet().range(key, 0, -1);
        System.out.println(student.size());
        System.out.println(student);
    }
}
