package com.etc.managemeetings.entity;


import java.util.ArrayList;
import java.util.List;

public class ConferenceRoom {

  private int houseNo;
  private String name;
  private int peopleNumber;
  private String info;
  private int state;
  private List<Meeting> meetingList;
  public ConferenceRoom(){
    this.meetingList = new ArrayList<>();
  }
  public ConferenceRoom(int houseNo,String name,int peopleNumber, String info){
    this.meetingList = new ArrayList<>();
    this.houseNo = houseNo;
    this.name = name;
    this.peopleNumber = peopleNumber;
    this.info = info;
  }
  public List<Meeting> getMeetingList() {
    return meetingList;
  }

  public void setMeetingList(List<Meeting> meetingList) {
    this.meetingList = meetingList;
  }

  public int getHouseNo() {
    return houseNo;
  }

  public void setHouseNo(int houseNo) {
    this.houseNo = houseNo;
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public int getPeopleNumber() {
    return peopleNumber;
  }

  public void setPeopleNumber(int peopleNumber) {
    this.peopleNumber = peopleNumber;
  }


  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  @Override
  public String toString() {
    return "ConferenceRoom{" +
            "houseNo=" + houseNo +
            ", name='" + name + '\'' +
            ", peopleNumber=" + peopleNumber +
            ", info='" + info + '\'' +
            ", state=" + state +
            ", meetingList=" + meetingList +
            '}';
  }
}
