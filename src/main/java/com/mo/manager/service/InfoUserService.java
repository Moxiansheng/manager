package com.mo.manager.service;

import com.mo.manager.pojo.InfoUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaomo
 * @since 2021-03-18
 */
@Service
public interface InfoUserService extends IService<InfoUser> {
    InfoUser getUserByUserName(String username);

    Integer getUserIdByLogin(Map<String, String> user);
}
