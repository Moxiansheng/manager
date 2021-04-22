package com.mo.manager.DiyException;

import static com.mo.manager.commons.CommonStrings.LOGIN_DB_VERIFY_FAILED_EXCEPTION;

public class LoginDBVerifyFailedException extends RuntimeException{

    @Override
    public String toString() {
        return LOGIN_DB_VERIFY_FAILED_EXCEPTION;
    }
}
