package models;

import java.sql.Date;

public class Buket extends Tovar{
    private long id;
    private long idBuk;
    private String groupTovar;
    private long idTovar;
    private String name;
    private String description;
    private Date dateOfAdd;
    private int timeStorageHour;
    private double price;

    public Buket() {
    }

    public Buket(long id, long idBuk, String groupTovar, long idTovar, String nameTovar, String description, Date dateOfAdd, int timeStorageHour, double price) {
        this.id = id;
        this.idBuk = idBuk;
        this.groupTovar = groupTovar;
        this.idTovar = idTovar;
        this.name = nameTovar;
        this.description = description;
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

    public long getIdBuk() {
        return idBuk;
    }

    public void setIdBuk(long idBuk) {
        this.idBuk = idBuk;
    }

    public String getGroupTovar() {
        return groupTovar;
    }

    public void setGroupTovar(String groupTovar) {
        this.groupTovar = groupTovar;
    }

    public long getIdTovar() {
        return idTovar;
    }

    public void setIdTovar(long idTovar) {
        this.idTovar = idTovar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Buket{" +
                "id=" + id +
                ", groupTovar='" + groupTovar + '\'' +
                ", nameTovar='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateOfAdd=" + dateOfAdd +
                ", timeStorageHour=" + timeStorageHour +
                ", price=" + price +
                '}';
    }
}
