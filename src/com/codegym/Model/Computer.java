package com.codegym.Model;

import java.io.Serializable;

public class Computer implements Serializable {
    private int id;
    private String name;
    private Status status = Status.DISABLE;
    private long startTime,endTime ;
    public long price;


    public Computer() {
    }

    public Computer(int id, String name) {
        this.id = id;
        this.name = name;
        this.status = Status.DISABLE;
        this.startTime = 0;
        this.endTime = 0;
        this.price = 10000;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status isStatus() {
        return status;
    }

    public void setStatusAvaiable() {
        this.status = Status.AVAIABLE;
        this.startTime = System.currentTimeMillis();
    }
    public void setStatusDisable(){
        this.status = Status.DISABLE;
        this.endTime = System.currentTimeMillis();
    }
    public long time(){
        return ((this.endTime-this.startTime)/1000);
    }
    public long price(){
        return (this.time()*this.price/3600);
    }

    public String toString1() {
        return "Computer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", price="+price+" đồng/h "+
                ", time="+ time() + " giây " +
                ", money="+ price()+" đồng "+
                '}';
    }
    @Override
    public String toString() {
        return "Computer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
