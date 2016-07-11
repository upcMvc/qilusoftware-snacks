package com.upcmvc.qilu2016.dto;

/**
 * Created by 陈子枫 on 2016/7/10.
 */
public class JsonMes {
    private int code;
    private String message;

    public JsonMes(int code, String message) {
        this.code = code;
        this.message = message;
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
}
