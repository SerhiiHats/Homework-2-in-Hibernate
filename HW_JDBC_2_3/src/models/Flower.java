package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Flower extends Tovar {
    String name;
    String colorFlower;
    LocalDateTime dateOfAdd;
    int timeStorageHour;
    int lengthFlower;
    double price;


    public Flower() {

    }

    public Flower(String name, String colorFlower, int lengthFlower, int timeStorageHour, double price) {
        this.name = name;
        this.dateOfAdd = LocalDateTime.now();
        ;
        this.timeStorageHour = timeStorageHour;
        this.price = price;
        this.colorFlower = colorFlower;
        this.lengthFlower = lengthFlower;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public LocalDateTime getDateOfAdd() {
        return dateOfAdd;
    }

    @Override
    public void setDateOfAdd(LocalDateTime dateOfAdd) {
        this.dateOfAdd = dateOfAdd;
    }

    @Override
    public void setDateOfAdd(int year, int month, int day, int hour, int minutes) {
        this.dateOfAdd = LocalDateTime.of(year, month, day, hour, minutes);
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

    public String getColorFlower() {
        return colorFlower;
    }

    public void setColorFlower(String colorFlower) {
        this.colorFlower = colorFlower;
    }

    public int getLengthFlower() {
        return lengthFlower;
    }

    public void setLengthFlower(int lengthFlower) {
        this.lengthFlower = lengthFlower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return timeStorageHour == flower.timeStorageHour && Double.compare(flower.price, price) == 0 && lengthFlower == flower.lengthFlower && Objects.equals(name, flower.name) && Objects.equals(dateOfAdd, flower.dateOfAdd) && Objects.equals(colorFlower, flower.colorFlower);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfAdd, timeStorageHour, price, colorFlower, lengthFlower);
    }

    @Override
    public String toString() {
        DateTimeFormatter mf = DateTimeFormatter.ofPattern("yyy-MM-dd hh:mm");
        return "name='" + name + '\'' +
                ", colorFlower='" + colorFlower + '\'' +
                ", lengthFlower=" + lengthFlower +
                ", dateOfAdd=" + mf.format(dateOfAdd) +
                ", timeStorageHour=" + timeStorageHour +
                ", price=" + price +
                '}';
    }


}
