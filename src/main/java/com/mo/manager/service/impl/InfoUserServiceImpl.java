package com.mo.manager.service.impl;

import com.mo.manager.DiyException.LoginDBVerifyFailedException;
import com.mo.manager.pojo.InfoUser;
import com.mo.manager.mapper.InfoUserMapper;
import com.mo.manager.service.InfoUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mo.manager.util.JsonRelated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.mo.manager.commons.CommonIntegers.INT_0;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaomo
 * @since 2021-03-18
 */
@Service
public class InfoUserServiceImpl extends ServiceImpl<InfoUserMapper, InfoUser> implements InfoUserService {

    @Autowired
    private InfoUserMapper infoUserMapper;

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public InfoUser getUserByUserName(String username) {
        return infoUserMapper.getUserByUserName(username);
    }

    @Override
    public Integer getUserIdByLogin(Map<String, String> user) {
        List<Integer> userIdByLogin = infoUserMapper.getUserIdByLogin(user.get(USERNAME), user.get(PASSWORD));
        if(userIdByLogin == null || userIdByLogin.size() <= INT_0){
            throw new LoginDBVerifyFailedException();
        }
        return userIdByLogin.get(INT_0);
    }
}
