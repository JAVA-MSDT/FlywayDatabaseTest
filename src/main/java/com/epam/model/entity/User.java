package com.epam.model.entity;

import java.util.Date;
import java.util.Objects;

public class User {

    private long userId;
    private String userName;
    private String userEmail;
    private Date userBirthDay;

    public User() {
    }

    public User(long userId, String userName, String userEmail, Date userBirthDay) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userBirthDay = userBirthDay;
    }

    // Custom Constructor for inserting new user
    public User(String userName, String userEmail, Date userBirthDay) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userBirthDay = userBirthDay;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getUserBirthDay() {
        return userBirthDay;
    }

    public void setUserBirthDay(Date userBirthDay) {
        this.userBirthDay = userBirthDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(userEmail, user.userEmail) &&
                Objects.equals(userBirthDay, user.userBirthDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userEmail, userBirthDay);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBirthDay=" + userBirthDay +
                '}';
    }
}
