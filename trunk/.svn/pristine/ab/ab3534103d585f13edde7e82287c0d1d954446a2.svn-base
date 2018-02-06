package com.payease.scfordermis.exception;

import com.payease.scfordermis.bean.Status;

/**
 * Created by lch on 2018/1/18.
 * <p>
 * 自定义通用的运行时异常
 */
public class CommonRuntimeException extends RuntimeException {

    private Integer codeId;

    private String msg;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    Status status;


    public CommonRuntimeException(Integer codeId, String msg) {
        this.codeId = codeId;
        this.msg = msg;
    }

    public CommonRuntimeException(Status status) {
        this.codeId = status.getCodeId();
        this.msg = status.getMessage();
        this.status = status;
    }

    public Integer getCodeId() {
        return codeId;
    }

    public void setCodeId(Integer codeId) {
        this.codeId = codeId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
