package com.mo.manager.dao;

import com.mo.manager.mapper.InfoUserMapper;
import com.mo.manager.pojo.InfoUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class InfoUserMapperTest {
    @Autowired
    private InfoUserMapper infoUserMapper;

    @Test
    public void insertTest(){
        InfoUser infoUser = new InfoUser();
        infoUser.setUserName("admin");
        infoUser.setUserPassword("123456");
        int insert = infoUserMapper.insert(infoUser);
        System.out.println(insert);
    }

    @Test
    public void getUserByUserName(){
        String userName = "admin";
        InfoUser userByUserName = infoUserMapper.getUserByUserName(userName);
        System.out.println(userByUserName);
    }
}
