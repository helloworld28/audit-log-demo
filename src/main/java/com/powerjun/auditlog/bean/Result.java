package com.powerjun.auditlog.bean;

public class Result {
    private int code;
    private String message;
    private Object data;

    private Result(Builder builder) {
        setCode(builder.code);
        setMessage(builder.message);
        setData(builder.data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }



    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public static final class Builder {
        private int code;
        private String message;
        private Object data;

        public Builder() {
        }

        public Builder withCode(int val) {
            code = val;
            return this;
        }

        public Builder withMessage(String val) {
            message = val;
            return this;
        }

        public Builder withData(Object val) {
            data = val;
            return this;
        }

        public Result build() {
            return new Result(this);
        }
    }
}
