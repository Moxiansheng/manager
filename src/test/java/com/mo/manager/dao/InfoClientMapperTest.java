package com.mo.manager.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mo.manager.mapper.InfoClientMapper;
import com.mo.manager.pojo.InfoClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class InfoClientMapperTest {

    @Autowired
    private InfoClientMapper infoClientMapper;

    @Test
    void getClientById() {

    }

    @Test
    void getClientByName() {

    }

    @Test
    void selectTest(){
        /**
         * Wrapper针对的时SQL编程，所以以DB内的字段名进行拼接
         */
        log.info("----- selectAll method test ------");

        List<InfoClient> userList = infoClientMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    void insertTest(){
        log.info("----- insert method test ------");
        InfoClient infoClient = new InfoClient();
        int insert = infoClientMapper.insert(infoClient);
        System.out.println(insert);
    }

    @Test
    void pageTest(){
        log.info("----- page method test ------");
        Page<InfoClient> page = new Page(1, 2);
        infoClientMapper.selectPage(page, null);
        System.out.println(page.getSize());
        page.getRecords().forEach(System.out::println);
    }

    @Test
    void deleteTest(){
        log.info("----- delete method test ------");
        QueryWrapper<InfoClient> queryWrapper = new QueryWrapper<>();
        queryWrapper.le("client_id", 5);
        System.out.println(infoClientMapper.delete(queryWrapper));
    }
}