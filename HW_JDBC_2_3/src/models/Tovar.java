package models;

import java.time.LocalDateTime;

abstract public class Tovar {
    String name;
    LocalDateTime dateOfAdd;
    int timeStorageHour;
    double price;


    public abstract String getName();

    public abstract void setName(String name);

    public abstract LocalDateTime getDateOfAdd();

    public abstract  void setDateOfAdd(LocalDateTime dateOfAdd);

    public abstract void setDateOfAdd(int year, int month, int day, int hour, int minutes);

    public abstract  int getTimeStorageHour();

    public abstract  void setTimeStorageHour(int timeStorageHour);

    public abstract double getPrice();

    public abstract void setPrice(double price);

}
