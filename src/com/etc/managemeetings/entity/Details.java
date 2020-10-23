package com.etc.managemeetings.entity;


public class Details {

  private String meetingName;
  private String info;
  private Meeting meeting;
  public Details(){

  }
  public Details(String meetingName,String info,Meeting meeting){
    this.meetingName = meetingName;
    this.info = info;
    this.meeting = meeting;
  }
  public Meeting getMeeting() {
    return meeting;
  }

  public void setMeeting(Meeting meeting) {
    this.meeting = meeting;
  }

  public String getMeetingName() {
    return meetingName;
  }

  public void setMeetingName(String meetingName) {
    this.meetingName = meetingName;
  }


  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

}
