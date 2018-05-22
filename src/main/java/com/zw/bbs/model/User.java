package com.zw.bbs.model;

import com.zw.bbs.util.validator.Add;
import com.zw.bbs.util.validator.Delete;
import com.zw.bbs.util.validator.Update;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.awt.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class User implements Serializable {
    @NotNull(message = "id不可为空",groups = Delete.class)
    private Integer id;
    @NotEmpty(message = "用户名不可为空",groups = {Add.class, Update.class})
    private String userCode;
    @NotEmpty(message = "姓名不可为空",groups = {Add.class, Update.class})
    private String userName;
    @NotEmpty(message = "密码不可为空",groups = {Add.class, Update.class})
    private String password;
    @NotNull(message = "身份类型不可为空")
    private Integer userRole;
    @NotNull(message = "性别不可为空")
    private Integer sex;

    private Sex sexModel;

    private UserRole role;

    private List<Posts> posts;

    private List<Reply> replies;

    private Date createDate;

    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Sex getSexModel() {
        return sexModel;
    }

    public void setSexModel(Sex sexModel) {
        this.sexModel = sexModel;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}