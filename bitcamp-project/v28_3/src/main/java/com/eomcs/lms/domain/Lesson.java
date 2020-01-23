package com.eomcs.lms.domain;

import java.sql.Date;

public class Lesson {
  private int no;
  private String title;
  private String description;
  private Date startDate;
  private Date endDate;
  private int totalHours;
  private int dayHours;

  public static Lesson valueOf(String csv) {
    String[] data = csv.split(",");

    // 번호, 강의명, 설명, 시작일, 종료일, 총강의시간, 일강의시간
    Lesson lesson = new Lesson();
    lesson.setNo(Integer.parseInt(data[0]));
    lesson.setTitle(data[1]);
    lesson.setDescription(data[2]);
    lesson.setStartDate(Date.valueOf(data[3]));
    lesson.setEndDate(Date.valueOf(data[4]));
    lesson.setTotalHours(Integer.parseInt(data[5]));
    lesson.setDayHours(Integer.parseInt(data[6]));

    return lesson;
  }

  public String toCSVString() {
    return String.format("%d,%s,%s,%s,%s,%d,%d", this.getNo(), this.getTitle(),
        this.getDescription(), this.getStartDate(), this.getEndDate(), this.getTotalHours(),
        this.getDayHours());
    // 이 인스턴스에 저장된것들
  }


  @Override
  public boolean equals(Object obj) {
    if (obj.getClass() != Lesson.class)
      return false;

    Lesson other = (Lesson) obj;
    if (this.no != other.no)
      return false;

    if (!this.title.equals(other.title))
      return false;

    if (!this.description.equals(other.description))
      return false;

    if (this.startDate.compareTo(other.startDate) != 0)
      return false;

    if (this.endDate.compareTo(other.endDate) != 0)
      return false;

    if (this.totalHours != other.totalHours)
      return false;

    if (this.dayHours != other.dayHours)
      return false;

    return true;

  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public int getTotalHours() {
    return totalHours;
  }

  public void setTotalHours(int totalHours) {
    this.totalHours = totalHours;
  }

  public int getDayHours() {
    return dayHours;
  }

  public void setDayHours(int dayHours) {
    this.dayHours = dayHours;
  }

}

