package com.mo.manager.utils;

import com.mo.manager.pojo.UserToken;
import com.mo.manager.util.RedisUtil;
import com.mo.manager.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisUtilTest {

    @Resource
    RedisUtil redisUtil;

    @Resource
    TokenUtil tokenUtil;

    @Test
    public void setRedisTest(){
        UserToken userToken = tokenUtil.generate(1);
        redisUtil.set(userToken.getToken(), userToken);
        userToken = (UserToken) redisUtil.get(userToken.getToken());
        System.out.println(userToken.getUserId());
        System.out.println(userToken.getToken());
    }

    @Test
    public void getRedisTest(){

    }
}
