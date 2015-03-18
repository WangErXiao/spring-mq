package com.yao.model;

/**
 * Created by root on 15-3-18.
 */
public class Message {

    private String Id;

    private Object body;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
