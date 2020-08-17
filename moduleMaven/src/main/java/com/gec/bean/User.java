package com.gec.bean;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Component
public class User implements Serializable,Cloneable{
    private Integer id;

    private String account;

    private String uname;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User() {
    }

    public User(Integer id, String account, String uname, String password) {
        this.id = id;
        this.account = account;
        this.uname = uname;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        System.out.println("id:"+(getId()==user.getId()));
        System.out.println("account:"+(getAccount()==user.getAccount()));
        System.out.println("uname:"+(getPassword()==user.getPassword()));
        System.out.println("password:"+(getUname()==user.getUname()));
        return getId()==user.getId()||getAccount()==user.getAccount()||getPassword()==user.getPassword()||getUname()==user.getUname();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAccount(), getUname(), getPassword());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        return super.clone();
    }
}