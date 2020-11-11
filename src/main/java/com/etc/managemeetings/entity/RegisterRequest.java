package com.etc.managemeetings.entity;


public class RegisterRequest {

  private int denum;
  private String account;
  private String pwd;
  private String name;
  private String phone;
  private String email;

  @Override
  public String toString() {
    return "RegisterRequest{" +
            "denum=" + denum +
            ", account='" + account + '\'' +
            ", pwd='" + pwd + '\'' +
            ", name='" + name + '\'' +
            ", phone='" + phone + '\'' +
            ", email='" + email + '\'' +
            '}';
  }

  public int getDenum() {
    return denum;
  }

  public void setDenum(int denum) {
    this.denum = denum;
  }


  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }


  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
