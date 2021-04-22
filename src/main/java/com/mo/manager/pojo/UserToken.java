package com.mo.manager.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author xiaomo
 * @since 2021-04-13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserToken {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户Token
     */
    private String token;

    /**
     * Token签发时间
     */
    private Date issueAt;

    /**
     * Token过期时间
     */
    private Date expiredAt;
}
