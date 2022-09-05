package dao;

import models.Flower;

import java.util.List;

public interface DAOFlower {
    boolean add(Flower flower);

    List<Flower> getAll();

    Flower get(long idFlower);

    boolean updatePriceById(double newPrice, int idFlower);

    boolean removeById(int idFlower);
}
