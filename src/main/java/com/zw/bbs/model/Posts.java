package com.zw.bbs.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Posts implements Serializable {
    private Integer id;

    private Integer postTopic;

    private Topic topic;

    private Integer userId;

    private User user;

    private Content content;

    private List<Reply> replies;

    private Integer contentId;

    private Date createDate;

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostTopic() {
        return postTopic;
    }

    public void setPostTopic(Integer postTopic) {
        this.postTopic = postTopic;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Topic getTopic() {

        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}