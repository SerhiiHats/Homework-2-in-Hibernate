package handlerMenuConsol;

import color.Color;
import dao.DAOAccesories;
import dao.daoImpl.DAOFactoryImpl;
import models.Accessories;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsolMenuAccesories {
    private DAOAccesories objDaoAccessor;

    public ConsolMenuAccesories() {
        this.objDaoAccessor = DAOFactoryImpl.getInstace().getDAOAccesories();
    }

    public void showMenu() {
        boolean keyOutOf = true;
        Scanner scanner = new Scanner(System.in);
        while (keyOutOf) {
            System.out.println(Color.YELLOW + "МЕНЮ АКСЕССУАРОВ. Выберите номер и нажмите Enter:");
            System.out.println("1.Добавить новый аксессуар  2.Показать все аксессуары  3. Найти по id  4. Редактировать цену по id  5.Удалить аксессуар c id  6.Выход в предыдущее меню (или другой)" + Color.DEFAULT);
            switch (scanner.next()) {
                case "1": {
                    System.out.println("Введите название: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    System.out.println("Введите кратко описание: ");
                    String discription = scanner.nextLine();
                    Date date = Date.valueOf(LocalDate.now());
                    System.out.println("Введите срок хранения, в часах: ");
                    int timeStor = scanner.nextInt();
                    System.out.println("Введите цену: ");
                    double price = scanner.nextInt();
                    System.out.println("Добавлен новый аксессуар с ID: " + (objDaoAccessor.getAll().size() + 1) + ", результат: " + objDaoAccessor.add(new Accessories(1, name, discription, date, timeStor, price)));
                    break;
                }
                case "2": {
                    System.out.println(Color.YELLOW + "Аксессуары в наличии:" + Color.DEFAULT);
                    if (objDaoAccessor.getAll().size() == 0) {
                        System.out.println("Аксессуары не найдено, необходимо добавить аксессуары");
                        break;
                    }
                    List<Accessories> accessoriesList = objDaoAccessor.getAll();

                    for (Accessories accessories : accessoriesList) {
                        System.out.println(accessories);
                    }
                    break;
                }

                case "3": {
                    System.out.println("Введите ID аксессуара с ID ?: ");
                    int tmpIdAcces = scanner.nextInt();
                    System.out.println(Color.YELLOW + "Аксессуар с ID :" + tmpIdAcces + Color.DEFAULT);
                    if (tmpIdAcces >= objDaoAccessor.getAll().size() || tmpIdAcces < 0) {
                        System.out.println("Не найдено аксессуара с ID: " + tmpIdAcces);
                        break;
                    }

                    Accessories accessories = objDaoAccessor.get(tmpIdAcces);
                    System.out.println("Id: " + tmpIdAcces + " " + accessories);
                    break;
                }


                case "4": {
                    System.out.println("Введите новую цену аксессуара : ");
                    double tmpPrice = scanner.nextDouble();
                    System.out.println("Введите ID редактируемого аксессуара ID ? : ");
                    int tmpId = scanner.nextInt();
                    System.out.println("Редактирование аксессуара с ID: " + tmpId + ", результат: " + objDaoAccessor.updatePriceById(tmpPrice, tmpId));
                    break;
                }

                case "5": {
                    System.out.println("Введите ID удаляемого аксессуара ID ? : ");
                    int tmpId = scanner.nextInt();
                    System.out.println("Удаление записи ID: " + tmpId + ", результат: " + objDaoAccessor.removeById(tmpId));
                    break;
                }

                default: {
                    keyOutOf = false;
                }
            }
        }

    }
}

