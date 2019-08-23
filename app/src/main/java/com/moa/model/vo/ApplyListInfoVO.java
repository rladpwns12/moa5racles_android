package com.moa.model.vo;

public class ApplyListInfoVO {
    private String date;
    private String time;
    private String nick;
    private String price;
    private String transactionType;
    private String baseAddress;
    private String detailAddress;


    public ApplyListInfoVO(String date, String time, String nick, String price, String transactionType, String baseAddress, String detailAddress) {
        this.date = date;
        this.time = time;
        this.nick = nick;
        this.price = price;
        this.transactionType = transactionType;
        this.baseAddress = baseAddress;
        this.detailAddress = detailAddress;
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

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getBaseAddress() {
        return baseAddress;
    }

    public void setBaseAddress(String baseAddress) {
        this.baseAddress = baseAddress;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    @Override
    public String toString() {
        return "ApplyListInfoVO{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", nick='" + nick + '\'' +
                ", price='" + price + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", baseAddress='" + baseAddress + '\'' +
                ", detailAddress='" + detailAddress + '\'' +
                '}';
    }
}
