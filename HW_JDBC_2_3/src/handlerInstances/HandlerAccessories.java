package handlerInstances;


import models.Accessories;
import storage.Storage;


import java.util.List;


public class HandlerAccessories {


    public HandlerAccessories() {
    }


    public boolean add(Accessories accessories) {
        Storage.accessoriesListList.add(accessories);
        return true;
    }

    public List<Accessories> getAll() {
        return Storage.accessoriesListList;
    }

    public Accessories get(int idAcces) {
        return Storage.accessoriesListList.get(idAcces);
    }

    public boolean updatePriceById(double newPrice, int idAcces) {
        if (idAcces < Storage.accessoriesListList.size() && idAcces >= 0) {
            Storage.accessoriesListList.get(idAcces).setPrice(newPrice);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeById(int idAcces) {
        if (idAcces < Storage.accessoriesListList.size() && idAcces >= 0) {
            Storage.accessoriesListList.remove(idAcces);
            return true;
        } else {
            return false;
        }
    }
}
