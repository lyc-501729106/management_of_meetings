package com.etc.managemeetings.entity;


import java.util.ArrayList;
import java.util.List;

public class Department {

  private int deNum;
  private String name;
  private List<User> userList;
  public Department(){
    this.userList = new ArrayList<>();
  }
  public Department(int deNum,String name){
    this.userList = new ArrayList<>();
    this.deNum = deNum;
    this.name = name;
  }
  public List<User> getUserList() {
    return userList;
  }

  public void setUserList(List<User> userList) {
    this.userList = userList;
  }

  public int getDeNum() {
    return deNum;
  }

  public void setDeNum(int deNum) {
    this.deNum = deNum;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
