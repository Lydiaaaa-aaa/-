package com.app.login;

public class User_info {
    private int user_id;
    private String username;
    private String password;
    private String nickname;

    private static User_info user_info;

    public static User_info getUser_info() {
        return user_info;
    }

    public static void setUser_info(User_info user_info) {
        User_info.user_info = user_info;
    }

    public User_info(int user_id, String username, String password, String nickname) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }



}
