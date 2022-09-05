package handlerConsol;

import color.Color;
import models.Accessories;
import handlerInstances.HandlerAccessories;

import java.util.Scanner;

public class ConsolAccessories {
    HandlerAccessories objAccessor;

    public ConsolAccessories(HandlerAccessories storageAccessories) {
        this.objAccessor = storageAccessories;
    }

    public void showMenu() {
        boolean keyOutOf = true;
        Scanner scanner = new Scanner(System.in);
        while (keyOutOf) {
            System.out.println(Color.YELLOW + "МЕНЮ АКСЕССУАРОВ. Выберите номер и нажмите Enter:");
            System.out.println("1.Добавить новый аксессуар  2.Показать все аксессуары 3. Найти по id  4. Редактировать цену по id  5.Удалить аксессуар c id  6.Выход в предыдущее меню (или другой)" + Color.DEFAULT);
            switch (scanner.next()) {
                case "1": {
                    System.out.println("Введите название: ");
                    String name = scanner.next();
                    System.out.println("Введите кратко описание: ");
                    String discription = scanner.next();
                    System.out.println("Введите срок хранения, в часах: ");
                    int timeStor = scanner.nextInt();
                    System.out.println("Введите цену: ");
                    double price = scanner.nextInt();
                    System.out.println("Добавлен новый аксессуар с ID: " + objAccessor.getAll().size() + ", результат: " + objAccessor.add(new Accessories(name, discription, timeStor, price)));
                    break;
                }
                case "2": {
                    System.out.println(Color.YELLOW + "Аксессуары в наличии:" + Color.DEFAULT);
                    if (objAccessor.getAll().size() == 0) {
                        System.out.println("Аксессуары не найдено, необходимо добавить аксессуары");
                        break;
                    }

                    for (int i = 0; i < objAccessor.getAll().size(); i++) {
                        System.out.println("id: " + i + " " + objAccessor.get(i));
                    }
                    break;
                }

                case "3": {
                    System.out.println("Введите ID аксессуара с ID ?: ");
                    int tmpIdAcces = scanner.nextInt();
                    System.out.println(Color.YELLOW + "Аксессуар с ID :" + tmpIdAcces + Color.DEFAULT);
                    if (tmpIdAcces >= objAccessor.getAll().size() || tmpIdAcces < 0) {
                        System.out.println("Не найдено аксессуара с ID: " + tmpIdAcces);
                        break;
                    }

                    Accessories accessories = objAccessor.get(tmpIdAcces);
                    System.out.println("Id: " + tmpIdAcces + " " + accessories);

                    break;
                }


                case "4": {
                    System.out.println("Введите новую цену аксессуара : ");
                    double tmpPrice = scanner.nextDouble();
                    System.out.println("Введите ID редактируемого аксессуара ID ? : ");
                    int tmpId = scanner.nextInt();
                    System.out.println("Редактирование аксессуара с ID: " + tmpId + ", результат: " + objAccessor.updatePriceById(tmpPrice, tmpId));
                    break;
                }
                case "5": {
                    System.out.println("Введите ID удаляемого аксессуара ID ? : ");
                    int tmpId = scanner.nextInt();
                    System.out.println("Удаление записи ID: " + tmpId + ", результат: " + objAccessor.removeById(tmpId));
                    break;
                }

                default: {
                    keyOutOf = false;
                }
            }
        }

    }
}
