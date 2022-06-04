package vn.fis.training.service;

import vn.fis.training.exception.ApplicationException;

public class AppConstant extends ApplicationException {
    public static final String INVALID_CUSTOMER = "INVALID_CUSTOMER";
    public static final String INVALID_STATUS_CUSTOMER = "INVALID_STATUS_CUSTOMER";
    public static final String NOT_FOUND_CUSTOMER = "NOT_FOUND_CUSTOMER";

    public AppConstant(String message) {
        super(message);
    }

    @Override
    public String getErrorCode() {
        if (getMessage().equals(INVALID_CUSTOMER))
        return INVALID_CUSTOMER;
        return null;
    }
}
