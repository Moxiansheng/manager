package com.mo.manager.util;

import java.util.Date;

public class TimeDateUtil {


    public static Date getTokenExpiredDate(long exp){
        return new Date(System.currentTimeMillis() + exp);
    }

    public static boolean isExpiredToken(Date exp){
        return new Date().after(exp);
    }
}
