package com.wawi.springbootDemo.test.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Table(name="t_user")
@Entity
public class User implements Serializable {
    @Id
    @Column(name="user_id")
    private  Long userId;
    @Column(name = "user_name")
    private  String userName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
