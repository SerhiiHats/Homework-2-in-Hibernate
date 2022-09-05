package models;

import java.sql.Date;

abstract public class Tovar {
    private long id;
    private String name;
    private Date dateOfAdd;
    private int timeStorageHour;
    private double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public abstract String getName();

    public abstract void setName(String name);

    public abstract Date getDateOfAdd();

    public abstract void setDateOfAdd(Date dateOfAdd);

    public abstract  int getTimeStorageHour();

    public abstract  void setTimeStorageHour(int timeStorageHour);

    public abstract double getPrice();

    public abstract void setPrice(double price);

}

