package handlerMenuConsol;

import color.Color;
import dao.DAOFlower;
import dao.daoImpl.DAOFactoryImpl;
import models.Flower;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsolMenuFlower {

    private DAOFlower objDaoFlower;

    public ConsolMenuFlower() {
        this.objDaoFlower = DAOFactoryImpl.getInstace().getDAOFlower();
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
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.println("Введите цвет: ");
                    String color = scanner.nextLine();
                    System.out.println("Введите длину стебля: ");
                    int length = scanner.nextInt();
                    Date dateOfAdd = Date.valueOf(LocalDate.now());
                    System.out.println("Введите срок хранения, в часах: ");
                    int timeStor = scanner.nextInt();
                    System.out.println("Введите цену: ");
                    double price = scanner.nextInt();
                    System.out.println("Добавлен новый цветок с ID: " + (objDaoFlower.getAll().size() + 1) + ", результат: " + objDaoFlower.add(new Flower(1, name, color, dateOfAdd, length, timeStor, price)));
                    break;
                }
                case "2": {
                    System.out.println(Color.PING + "Цветы в наличии:" + Color.DEFAULT);
                    if (objDaoFlower.getAll().size() == 0) {
                        System.out.println("Цветов не найдено, необходимо добавить цветы");
                        break;
                    }

                    List<Flower> flowerList = objDaoFlower.getAll();
                    for (Flower flower1 : flowerList) {
                        System.out.println(flower1);
                    }
                    break;
                }

                case "3": {
                    System.out.println("Введите ID цветка с ID ?: ");
                    int tmpIdFlower = scanner.nextInt();
                    System.out.println(Color.PING + "Цветок с ID :" + tmpIdFlower + Color.DEFAULT);
                    if (tmpIdFlower >= objDaoFlower.getAll().size() || tmpIdFlower < 0) {
                        System.out.println("Не найдено цветка с ID: " + tmpIdFlower);
                        break;
                    }

                    Flower flower2 = objDaoFlower.get(tmpIdFlower);
                    System.out.println("Id: " + tmpIdFlower + " " + flower2);

                    break;
                }


                case "4": {
                    System.out.println("Введите новую цену цветка : ");
                    double tmpPrice = scanner.nextDouble();
                    System.out.println("Введите ID редактируемого цветка ID ? : ");
                    int tmpId = scanner.nextInt();
                    System.out.println("Редактирование цветка с ID: " + tmpId + ", результат: " + objDaoFlower.updatePriceById(tmpPrice, tmpId));
                    break;
                }

                case "5": {
                    System.out.println("Введите ID удаляемого цветка ID ? : ");
                    int tmpId = scanner.nextInt();
                    System.out.println("Удаление записи ID: " + tmpId + ", результат: " + objDaoFlower.removeById(tmpId));
                    break;
                }

                default: {
                    keyOutOf = false;
                }
            }
        }

    }
}
