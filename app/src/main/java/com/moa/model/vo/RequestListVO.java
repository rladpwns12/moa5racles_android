package com.moa.model.vo;

public class RequestListVO {
    private String date;
    private String time;
    private String nick;
    private String price;

    public RequestListVO(String date, String time, String nick,String price){
        this.date = date;
        this.time = time;
        this.nick = nick;
        this.price = price;
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

    @Override
    public String toString() {
        return "RequestListVO{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", nick='" + nick + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
