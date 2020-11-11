package com.etc.managemeetings.entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

  private int deNum;
  private String account;
  private String pwd;
  private String name;
  private String phone;
  private String email;
  private int state;
  private Department department;
  private List<Meeting> meetingList;
  public User(){
    this.meetingList = new ArrayList<>();
  }
  public User(int deNum,String account,String pwd,String name,String phone,String email, Department department){
    this.meetingList = new ArrayList<>();
    this.deNum = deNum;
    this.account = account;
    this.pwd = pwd;
    this.name = name;
    this.phone = phone;
    this.email = email;
    this.department = department;
    this.department.getUserList().add(this);
  }

  public List<Meeting> getMeetingList() {
    return meetingList;
  }

  public void setMeetingList(List<Meeting> meetingList) {
    this.meetingList = meetingList;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public int getDeNum() {
    return deNum;
  }

  public void setDeNum(int deNum) {
    this.deNum = deNum;
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

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
