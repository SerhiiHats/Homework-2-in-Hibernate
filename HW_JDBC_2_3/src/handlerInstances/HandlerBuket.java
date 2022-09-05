package handlerInstances;

import models.Tovar;
import storage.Storage;

import java.util.List;


public class HandlerBuket {

    public HandlerBuket() {

    }

    public boolean add(Tovar tovar) {                               // добавление в букет компонентов
        Storage.buket.add(tovar);
        return true;
    }

    public List<Tovar> getBuket() {               // получить состав всего букета
        return Storage.buket;
    }

    public Tovar get(int idTovar) {
        return Storage.buket.get(idTovar);
    }

    public boolean update(double price, int id) {     // редактирование цены компонента букета по его id
        if (id < Storage.buket.size() && id >= 0) {
            Storage.buket.get(id).setPrice(price);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(int id) {                  //   удаление компонента букета
        if (id < Storage.buket.size() && id >= 0) {
            Storage.buket.remove(id);
            return true;
        } else {
            return false;
        }
    }

}
