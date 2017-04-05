package com.cxd.exception;

import com.cxd.enums.ResultEnum;

/**
 * Created by cai x d
 * on2017/4/5 0005.
 */
public class UserException extends RuntimeException{
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public UserException(ResultEnum  resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
