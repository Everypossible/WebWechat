package com.crs.entity;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Description: 对应userdetails表的实体类
 * @outhor RS
 * @create 2021-04-29 7:39
 */
public class UserDetails {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 头像地址
     */
    private String headPortrait;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 性别
     */
    private String sex;
    /**
     * 生日
     */
    private Date birth;
    /**
     * 用户所在地区
     */
    private String userAddr;
    /**
     * 个性签名
     */
    private String userDesc;
    /**
     * 账号注册的时间
     */
    private LocalDateTime createTime;
    /**
     * 外键(关联user表)
     */
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getheadPortrait() {
        return headPortrait;
    }

    public void setheadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public UserDetails() {
    }

    public UserDetails(Integer id, String headPortrait, String nickname,
                       String sex, Date birth, String userAddr, String userDesc,
                       LocalDateTime createTime, Integer userId) {
        this.id = id;
        this.headPortrait = headPortrait;
        this.nickname = nickname;
        this.sex = sex;
        this.birth = birth;
        this.userAddr = userAddr;
        this.userDesc = userDesc;
        this.createTime = createTime;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", headPortrait='" + headPortrait + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex='" + sex + '\'' +
                ", birth='" + birth + '\'' +
                ", userAddr='" + userAddr + '\'' +
                ", userDesc='" + userDesc + '\'' +
                ", createTime='" + createTime + '\'' +
                ", userId=" + userId +
                '}';
    }
}

