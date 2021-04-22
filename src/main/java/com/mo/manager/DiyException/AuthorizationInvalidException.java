package com.mo.manager.DiyException;

import com.mo.manager.commons.CommonStrings;

public class AuthorizationInvalidException extends RuntimeException {


    @Override
    public String toString() {
        return CommonStrings.AUTHORIZATION_INVALID_EXCEPTION;
    }

}
