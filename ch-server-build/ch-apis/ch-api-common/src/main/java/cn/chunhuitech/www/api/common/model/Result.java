package cn.chunhuitech.www.api.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by hechengjin on 17-9-29.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public static final Integer OK_CODE = 0;
    public static final String OK_MSG = "SUCCESS";

    public Result() {
    }

    public Result(T data) {
        this(OK_CODE,OK_MSG, data);
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
