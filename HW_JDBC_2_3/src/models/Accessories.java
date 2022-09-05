package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Accessories extends Tovar {
    String name;

    String discription;
    LocalDateTime dateOfAdd;
    int timeStorageHour;
    double price;


    public Accessories() {
    }

    public Accessories(String name, String discription, int timeStorageHour, double price) {
        this.name = name;
        this.dateOfAdd = LocalDateTime.now();
        this.timeStorageHour = timeStorageHour;
        this.price = price;
        this.discription = discription;
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

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accessories that = (Accessories) o;
        return timeStorageHour == that.timeStorageHour && Double.compare(that.price, price) == 0 && Objects.equals(name, that.name) && Objects.equals(dateOfAdd, that.dateOfAdd) && Objects.equals(discription, that.discription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfAdd, timeStorageHour, price, discription);
    }

    @Override
    public String toString() {
        DateTimeFormatter mf = DateTimeFormatter.ofPattern("yyy-MM-dd hh:mm");
        return "name='" + name + '\'' +
                ", discription='" + discription + '\'' +
                ", dateOfAdd=" + mf.format(dateOfAdd) +
                ", timeStorageHour=" + timeStorageHour +
                ", price=" + price +
                '}';
    }

}
