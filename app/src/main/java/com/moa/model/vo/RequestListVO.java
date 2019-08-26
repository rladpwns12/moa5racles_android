package com.moa.model.vo;

public class RequestListVO {
    private String date;
    private String time;
    private String nick;
    private String price;
    private String state;
    private String startDate;
    private String endDate;
    private int articleNum;

    public RequestListVO(String date, String time, String nick, String price, String state, String startDate, String endDate, int articleNum) {
        this.date = date;
        this.time = time;
        this.nick = nick;
        this.price = price;
        this.state = state;
        this.startDate = startDate;
        this.endDate = endDate;
        this.articleNum = articleNum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(int articleNum) {
        this.articleNum = articleNum;
    }

    @Override
    public String toString() {
        return "RequestListVO{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", nick='" + nick + '\'' +
                ", price='" + price + '\'' +
                ", state='" + state + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", articleNum=" + articleNum +
                '}';
    }
}
