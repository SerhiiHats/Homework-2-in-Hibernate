package dao;

import models.Accessories;

import java.util.List;

public interface DAOAccesories {

    boolean add(Accessories accessories);

    List<Accessories> getAll();

    Accessories get(int idAcces);

    boolean updatePriceById(double newPrice, int idAcces);

    boolean removeById(int idAcces);
}
