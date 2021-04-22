package com.mo.manager.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.mo.manager.DiyException.AuthorizationEmptyException;
import com.mo.manager.DiyException.AuthorizationExpiredException;
import com.mo.manager.DiyException.AuthorizationInvalidException;
import com.mo.manager.pojo.UserToken;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;

@Component
public class TokenUtil {

    @Resource
    RedisUtil redisUtil;

    /**
     * 过期时间现为一天
     * TODO 上线时应更换为15min
     */
    private static final long EXPIRE_TIME = 1000 * 60 * 60 * 24;

    /**
     * token私钥
     */
    private static final String TOKEN_SECRET = "dlhfajsdhfuidfifuhisaufdhijhrfbfsudifhisudfhiuefbisdhfaisufdhi";

    /**
     * algorithm算法
     */
    private static final Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

    /**
     * 静态头部
     */
    private static final HashMap<String, Object> HEADER = new HashMap<>(2);
    private static final String HEADER_TYPE_LABEL = "typ";
    private static final String HEADER_TYPE = "JWT";
    private static final String HEADER_ALG_LABEL = "alg";
    private static final String HEADER_ALG = "HS256";

    /**
     * payload 字段名
     */
    private static final String CLAIM_LABEL_USER_ID = "userId";

    static {
        HEADER.put(HEADER_TYPE_LABEL, HEADER_TYPE);
        HEADER.put(HEADER_ALG_LABEL, HEADER_ALG);
    }

    /**
     * 根据需要编入的信息生成Token，
     * 暂时只编入userId
     * TODO 后续可增加连接IP等信息
     * @param userId
     * @return
     */
    public UserToken generate(int userId){
        //签发时间
        Date dateIssue = new Date();
        // 过期时间
        Date date = TimeDateUtil.getTokenExpiredDate(EXPIRE_TIME);
        // 返回token
        String jwt = JWT.create()
                .withHeader(HEADER)
                .withClaim(CLAIM_LABEL_USER_ID, userId)
                .withIssuedAt(dateIssue)
                .withExpiresAt(date)
                .sign(algorithm);
        UserToken userToken = new UserToken(userId, jwt, dateIssue, date);
        redisUtil.set(jwt, userToken, date.getTime());
        return userToken;
    }

    /**
     * 或许应直接返回新的Token，或者创建UserToken对象
     * 用来包含userId，userName，token信息，
     * 可以同时与前端的user.js保持对应
     * @param token
     * @return
     * @throws AuthorizationEmptyException
     * @throws AuthorizationExpiredException
     * @throws AuthorizationInvalidException
     * @throws IllegalArgumentException
     * @throws JWTVerificationException
     */
    public UserToken verify(String token)
            throws
            AuthorizationEmptyException,
            AuthorizationExpiredException,
            AuthorizationInvalidException,
            IllegalArgumentException,
            JWTVerificationException{
        // 进行空值判断，为空则不能越过登录
        if(token == null){
            throw new AuthorizationEmptyException();
        }

        /**
         * 进行Token验证，应对创建时间，过期时间，用户id,等信息逐个验证，
         * 均符合则通过，并返回用户信息，这里暂时只返回用户id
         * */
        int userId = equalsClaimsAndUserToken(token);

        // 前面已经获得了userId，没有抛出异常中断的话，
        // 说明token有效，现在可以删除之前的token，
        remove(token);

        // 生成新Token，并存入Redis
        UserToken userToken = generate(userId);

        return userToken;
    }

    private Integer equalsClaimsAndUserToken(String token){
        // 从Redis中获取UserToken
        UserToken userToken = (UserToken) redisUtil.get(token);

        // 进行解码
        DecodedJWT jwt = JWT.require(algorithm).build().verify(token);

        if(userToken == null ||
                !jwt.getIssuedAt().equals(userToken.getIssueAt()) ||
                jwt.getClaim(CLAIM_LABEL_USER_ID).asInt() != userToken.getUserId()){
            throw new AuthorizationInvalidException();
        }

        if(jwt.getExpiresAt().equals(userToken.getExpiredAt())){
            throw new AuthorizationExpiredException();
        }

        return userToken.getUserId();
    }

    public boolean remove(String token){
        redisUtil.del(token);
        return true;
    }
}
