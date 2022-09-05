package dao;

import models.Flower;
import models.Tovar;

import java.util.List;

public interface DAOBuket {
    boolean add(Tovar tovar);

    List<Tovar> getAll();

    Tovar get(int idTovar);

    boolean updatePriceById(double newPrice, int idTovar);

    boolean removeById(int idTovar);

}
