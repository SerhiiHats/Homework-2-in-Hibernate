package models;

import java.sql.Date;

public class Flower extends Tovar{
    private long id;
    private String name;
    private String colorFlower;
    private Date dateOfAdd;
    private int timeStorageHour;
    private int lengthFlower;
    private double price;

    public Flower() {
    }
    public Flower(int id, String name, String colorFlower, Date dateOfAdd, int timeStorageHour, int lengthFlower, double price) {
        this.id = id;
        this.name = name;
        this.colorFlower = colorFlower;
        this.dateOfAdd = dateOfAdd;
        this.timeStorageHour = timeStorageHour;
        this.lengthFlower = lengthFlower;
        this.price = price;
    }

    public long getId() {
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

    public String getColorFlower() {
        return colorFlower;
    }

    public void setColorFlower(String colorFlower) {
        this.colorFlower = colorFlower;
    }

    public Date getDateOfAdd() {
        return dateOfAdd;
    }

    public void setDateOfAdd(Date dateOfAdd) {
        this.dateOfAdd = dateOfAdd;
    }

    public int getTimeStorageHour() {
        return timeStorageHour;
    }

    public void setTimeStorageHour(int timeStorageHour) {
        this.timeStorageHour = timeStorageHour;
    }

    public int getLengthFlower() {
        return lengthFlower;
    }

    public void setLengthFlower(int lengthFlower) {
        this.lengthFlower = lengthFlower;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", colorFlower='" + colorFlower + '\'' +
                ", dateOfAdd=" + dateOfAdd +
                ", timeStorageHour=" + timeStorageHour +
                ", lengthFlower=" + lengthFlower +
                ", price=" + price +
                '}';
    }
}

