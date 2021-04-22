package com.mo.manager.DiyException;

import com.mo.manager.commons.CommonStrings;

public class AuthorizationEmptyException extends RuntimeException {

    @Override
    public String toString() {
        return CommonStrings.AUTHORIZATION_EMPTY_EXCEPTION;
    }

}
