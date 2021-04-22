package com.mo.manager.mapper;

import com.mo.manager.pojo.InfoUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xiaomo
 * @since 2021-03-18
 */
@Repository
public interface InfoUserMapper extends BaseMapper<InfoUser> {
    InfoUser getUserByUserName(@Param("username") String username);

    List<Integer> getUserIdByLogin(String username, String password);
}
