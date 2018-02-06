package com.payease.scfordermis.bo;

import com.payease.scfordermis.bean.Status;
import com.payease.scfordermis.exception.CommonRuntimeException;
import java.io.Serializable;

/**
 * Created by lch on 2018/1/4.
 * desc: 返回值对象
 */
public class ResultBo<T> implements Serializable {

    private Integer codeId;

    private String message;

    private T resultBody;


    /**
     * 建立对象
     *
     * @return
     */
    public static ResultBo build() {
        ResultBo resultBo = new ResultBo();
        resultBo.setCodeId(Status.SUCCESS.getCodeId());
        resultBo.setMessage(Status.SUCCESS.getMessage());
        return resultBo;
    }

    /**
     * 自定义异常返回值
     *
     * @return
     */
    public ResultBo errorHandle(Exception e) {
        if (e instanceof CommonRuntimeException) {
            this.setStatus(((CommonRuntimeException) e).getStatus());
        }else {
            this.fail();
        }
        return this;
    }


    /**
     * 失败调用
     *
     * @return
     */
    public ResultBo fail() {
        this.setStatus(Status.FAIL);
        return this;
    }

    //请求参数异常
    public ResultBo queryError() {
        this.setCodeId(Status.QUERYERROR.getCodeId());
        this.setMessage(Status.QUERYERROR.getMessage());
        return this;
    }

    public ResultBo timeOut() {
        this.setCodeId(Status.TIMEOUT.getCodeId());
        this.setMessage(Status.TIMEOUT.getMessage());
        return this;
    }

    public ResultBo setCodeId(Status status) {
        setStatus(status);
        return this;
    }


    private void setStatus(Status status) {
        this.setCodeId(status.getCodeId());
        this.setMessage(status.getMessage());
    }


    private ResultBo() {

    }

    public Integer getCodeId() {
        return codeId;
    }

    public void setCodeId(Integer codeId) {
        this.codeId = codeId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResultBody() {
        return resultBody;
    }

    public void setResultBody(T resultBody) {
        this.resultBody = resultBody;
    }
}
