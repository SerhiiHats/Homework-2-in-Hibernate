package handlerInstances;

import models.Flower;
import storage.Storage;

import java.util.*;

public class HandlerFlawers {


    public HandlerFlawers() {
    }

    public boolean add(Flower flower) {
        Storage.flowerList.add(flower);
        return true;
    }

    public List<Flower> getAll() {
        return  Storage.flowerList;
    }

    public Flower get(int idFlower) {
        return  Storage.flowerList.get(idFlower);
    }

    public boolean updatePriceById(double newPrice, int idFlower) {
        if (idFlower <  Storage.flowerList.size() && idFlower >= 0) {
            Storage.flowerList.get(idFlower).setPrice(newPrice);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeById(int idFlower) {
        if (idFlower <  Storage.flowerList.size() && idFlower >= 0) {
            Storage.flowerList.remove(idFlower);
            return true;
        } else {
            return false;
        }
    }

}
