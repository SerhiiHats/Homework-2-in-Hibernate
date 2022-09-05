package models;


import java.sql.Date;

public class Accessories extends Tovar {
    private long id;
    private String name;
    private String discription;
    private Date dateOfAdd;
    private int timeStorageHour;
    private double price;
    public Accessories() {

    }
    public Accessories(long id, String name, String discription, Date dateOfAdd, int timeStorageHour, double price) {
        this.id = id;
        this.name = name;
        this.discription = discription;
        this.dateOfAdd = dateOfAdd;
        this.timeStorageHour = timeStorageHour;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    @Override
    public Date getDateOfAdd() {
        return dateOfAdd;
    }

    @Override
    public void setDateOfAdd(Date dateOfAdd) {
        this.dateOfAdd = dateOfAdd;
    }

    @Override
    public int getTimeStorageHour() {
        return timeStorageHour;
    }

    @Override
    public void setTimeStorageHour(int timeStorageHour) {
        this.timeStorageHour = timeStorageHour;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Accessories{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", discription='" + discription + '\'' +
                ", dateOfAdd=" + dateOfAdd +
                ", timeStorageHour=" + timeStorageHour +
                ", price=" + price +
                '}';
    }
}




