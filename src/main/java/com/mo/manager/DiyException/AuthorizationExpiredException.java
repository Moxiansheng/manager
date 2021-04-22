package com.mo.manager.DiyException;

import com.mo.manager.commons.CommonStrings;

public class AuthorizationExpiredException extends RuntimeException {


    @Override
    public String toString() {
        return CommonStrings.AUTHORIZATION_EXPIRED_EXCEPTION;
    }
}
