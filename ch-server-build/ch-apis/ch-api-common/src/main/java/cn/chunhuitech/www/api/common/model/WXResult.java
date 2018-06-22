package cn.chunhuitech.www.api.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by hechengjin on 18-6-13.
 */
public class WXResult extends WXErrorCode {
    public static class Base {
        private Integer code;

        public Base(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        void check() {
            if (code == null){
                throw new IllegalArgumentException("code can not be null");
            }
        }
    }

    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public static class Success<T> extends Base {
        private T data;

        public Success(T data) {
            super(SUCCESS);
            this.data = data;
            check();
        }

        public Success() {
            super(SUCCESS);
            this.data = (T) "success";
            check();
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        @Override
        void check() {
            super.check();
        }
    }

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    public static class Error extends Base {
        private String result;

        public Error(Integer code, String result) {
            super(code);
            this.result = result;
            check();
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        @Override
        void check() {
            super.check();
            if (result == null){
                throw new IllegalArgumentException("result can not be null");
            }
        }

        @Override
        public String toString() {
            return String.format("code=%s result=%s", getCode(), result);
        }
    }

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    public static class ErrorData<T> extends Base {
        private String result;
        private T data;

        public ErrorData(T data) {
            super(0);
            this.data = data;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
        @Override
        void check() {
            super.check();
            if (result == null) {
                throw new IllegalArgumentException("result can not be null");
            }
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.format("code=%s result=%s", getCode(), result);
        }
    }
}
