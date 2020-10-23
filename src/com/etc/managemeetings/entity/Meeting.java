package com.etc.managemeetings.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Meeting {

  private int houseNo;
  private String account;
  private String meetingName;
  private int peopleNo;
  private java.util.Date startTime;
  private java.util.Date endtime;
  private java.util.Date createtime;
  private String create_peo;
  private String meetinginfo;
  private ConferenceRoom conferenceRoom;
  private User user;
  private List<Details> detailsList;
  public Meeting(){
    this.detailsList = new ArrayList<>();
  }
  public Meeting(int houseNo, String account, String meetingName, int peopleNo, Date startTime,Date endtime,String meetinginfo,ConferenceRoom conferenceRoom,User user){
    this.detailsList = new ArrayList<>();
    this.houseNo = houseNo;
    this.account = account;
    this.meetingName = meetingName;
    this.peopleNo = peopleNo;
    this.startTime = startTime;
    this.endtime = endtime;
    this.meetinginfo = meetinginfo;
    this.conferenceRoom = conferenceRoom;
    this.user = user;
    this.user.getMeetingList().add(this);
    this.conferenceRoom.getMeetingList().add(this);

  }

  public Date getCreatetime() {
    return createtime;
  }

  public void setCreatetime(Date createtime) {
    this.createtime = createtime;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Details> getDetailsList() {
    return detailsList;
  }

  public void setDetailsList(List<Details> detailsList) {
    this.detailsList = detailsList;
  }

  public String getCreate_peo() {
    return create_peo;
  }

  public void setCreate_peo(String create_peo) {
    this.create_peo = create_peo;
  }

  public ConferenceRoom getConferenceRoom() {
    return conferenceRoom;
  }

  public void setConferenceRoom(ConferenceRoom conferenceRoom) {
    this.conferenceRoom = conferenceRoom;
  }

  public int getHouseNo() {
    return houseNo;
  }

  public void setHouseNo(int houseNo) {
    this.houseNo = houseNo;
  }


  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }


  public String getMeetingName() {
    return meetingName;
  }

  public void setMeetingName(String meetingName) {
    this.meetingName = meetingName;
  }


  public int getPeopleNo() {
    return peopleNo;
  }

  public void setPeopleNo(int peopleNo) {
    this.peopleNo = peopleNo;
  }


  public java.util.Date getStartTime() {
    return startTime;
  }

  public void setStartTime(java.util.Date startTime) {
    this.startTime = startTime;
  }


  public java.util.Date getEndtime() {
    return endtime;
  }

  public void setEndtime(java.util.Date endtime) {
    this.endtime = endtime;
  }


  public String getMeetinginfo() {
    return meetinginfo;
  }

  public void setMeetinginfo(String meetinginfo) {
    this.meetinginfo = meetinginfo;
  }

  @Override
  public String toString() {
    return "Meeting{" +
            "houseNo=" + houseNo +
            ", account='" + account + '\'' +
            ", meetingName='" + meetingName + '\'' +
            ", peopleNo=" + peopleNo +
            ", startTime=" + startTime +
            ", endtime=" + endtime +
            ", createtime=" + createtime +
            ", meetinginfo='" + meetinginfo + '\'' +
            ", conferenceRoom=" + conferenceRoom +
            ", user=" + user +
            ", detailsList=" + detailsList +
            '}';
  }
}
