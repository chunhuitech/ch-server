package cn.chunhuitech.www.api.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by hechengjin on 17-8-2.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {
    private Integer code;
    private String result;
    private Integer httpStatus;

    public ErrorMessage() {
    }

    public ErrorMessage(Integer code, String result, Integer httpStatus) {
        this.code = code;
        this.result = result;
        this.httpStatus = httpStatus;
    }

    public Integer getCode() {
        return code;
    }

    public ErrorMessage setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getResult() {
        return result;
    }

    public ErrorMessage setResult(String result) {
        this.result = result;
        return this;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }

    public ErrorMessage setHttpStatus(Integer httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    public static ErrorMessage create(Integer code, String result, Integer httpStatus) {
        if (code == null || code < 0) {
            throw new IllegalArgumentException("errorCode must greater than 0");
        }
        if (result == null) {
            throw new IllegalArgumentException("errorMsg can not be empty");
        }
        if (httpStatus != null && httpStatus < 100) {
            throw new IllegalArgumentException("httpStatus must great 100");
        }
        return new ErrorMessage(code, result, httpStatus);
    }
}
