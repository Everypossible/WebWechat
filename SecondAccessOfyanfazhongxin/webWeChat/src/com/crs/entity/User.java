package com.crs.entity;

/**
 * @Description: user表的实体类
 * @outhor RS
 * @create 2021-04-24 16:24
 */
public class User {
    //user表的主键
    private Integer id;
    //用户名
    private String username;
    //密码
    private String password;
    //权限
    private Integer identity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", identity='" + identity + '\'' +
                '}';
    }

    public User() {
    }

    public User(Integer id, String username, String password,
                Integer identity) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.identity = identity;
    }
}

