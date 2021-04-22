package com.mo.manager.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonRelated {
    private static ObjectMapper objectMapper = new ObjectMapper();

    private static String RES_LOGIN_USERID = "userId";
    private static String RES_LOGIN_SUCC = "success";

    public static String responseLogin(boolean succ, int userId){
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put(RES_LOGIN_SUCC, succ);
        objectNode.put(RES_LOGIN_USERID, userId);
        System.out.println(objectNode.toString());
        return objectNode.toString();
    }

    public static void writeResponseResult2Response(HttpServletResponse response, ResponseResult responseResult){
        try{
            response.getOutputStream()
                    .write(objectMapper.writeValueAsBytes(responseResult));
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
