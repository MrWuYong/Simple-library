package com.zw.bbs.model;

import java.io.Serializable;

public class Content implements Serializable {
    private Integer id;

    private String heading;

    private String content;

    private static final long serialVersionUID = 1L;

    public String getHeading() {

        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}