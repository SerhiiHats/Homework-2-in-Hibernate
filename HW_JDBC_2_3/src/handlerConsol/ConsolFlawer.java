package handlerConsol;

import color.Color;
import models.Flower;
import handlerInstances.HandlerFlawers;

import java.util.Scanner;

public class ConsolFlawer {
    HandlerFlawers objFlawer;

    public ConsolFlawer(HandlerFlawers storageFlawers) {
        this.objFlawer = storageFlawers;
    }

    public void showMenu() {
        boolean keyOutOf = true;
        Scanner scanner = new Scanner(System.in);
        while (keyOutOf) {
            System.out.println(Color.PING + "МЕНЮ ЦВЕТОВ. Выбирете номер и нажмите Enter:");
            System.out.println("1.Добавить новый цветок  2.Показать все цветы 3. Найти цветок по id  4. Редактировать цену по id  5.Удалить цветок c id  6.Выход в предыдущее меню (или другой)" + Color.DEFAULT);
            switch (scanner.next()) {
                case "1": {
                    System.out.println("Введите название: ");
                    String name = scanner.next();
                    System.out.println("Введите цвет: ");
                    String color = scanner.next();
                    System.out.println("Введите длину стебля: ");
                    int length = scanner.nextInt();
                    System.out.println("Введите срок хранения, в часах: ");
                    int timeStor = scanner.nextInt();
                    System.out.println("Введите цену: ");
                    double price = scanner.nextInt();
                    System.out.println("Добавлен новый цветок с ID: " + objFlawer.getAll().size() + ", результат: " + objFlawer.add(new Flower(name, color, length, timeStor, price)));
                    break;
                }
                case "2": {
                    System.out.println(Color.PING + "Цветы в наличии:" + Color.DEFAULT);
                    if (objFlawer.getAll().size() == 0) {
                        System.out.println("Цветов не найдено, необходимо добавить цветы");
                        break;
                    }

                    for (int i = 0; i < objFlawer.getAll().size(); i++) {
                        System.out.println("id: " + i + " " + objFlawer.get(i));
                    }
                    break;
                }

                case "3": {
                    System.out.println("Введите ID цветка с ID ?: ");
                    int tmpIdFlower = scanner.nextInt();
                    System.out.println(Color.PING + "Цветок с ID :" + tmpIdFlower + Color.DEFAULT);
                    if (tmpIdFlower >= objFlawer.getAll().size() || tmpIdFlower < 0) {
                        System.out.println("Не найдено цветка с ID: " + tmpIdFlower);
                        break;
                    }

                    Flower flower = objFlawer.get(tmpIdFlower);
                    System.out.println("Id: " + tmpIdFlower + " " + flower);

                    break;
                }


                case "4": {
                    System.out.println("Введите новую цену цветка : ");
                    double tmpPrice = scanner.nextDouble();
                    System.out.println("Введите ID редактируемого цветка ID ? : ");
                    int tmpId = scanner.nextInt();
                    System.out.println("Редактирование цветка с ID: " + tmpId + ", результат: " + objFlawer.updatePriceById(tmpPrice, tmpId));
                    break;
                }
                case "5": {
                    System.out.println("Введите ID удаляемого цветка ID ? : ");
                    int tmpId = scanner.nextInt();
                    System.out.println("Удаление записи ID: " + tmpId + ", результат: " + objFlawer.removeById(tmpId));
                    break;
                }

                default: {
                    keyOutOf = false;
                }
            }
        }

    }
}
