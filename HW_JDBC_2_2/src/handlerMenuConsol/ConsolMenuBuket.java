package handlerMenuConsol;

import color.Color;
import dao.DAOBuket;
import dao.daoImpl.DAOFactoryImpl;
import models.Accessories;
import models.Buket;
import models.Flower;
import models.Tovar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ConsolMenuBuket {
    private DAOBuket objDaoBuket;

    public ConsolMenuBuket() {
        this.objDaoBuket = DAOFactoryImpl.getInstace().getDAOBuket();
    }

    public void showMenu() {
        boolean keyOut = true;
        Scanner scanner = new Scanner(System.in);
        while (keyOut) {
            System.out.println(Color.BLUE + "МЕНЮ БУКЕТА. Выберите номер и нажмите Enter:");
            System.out.println("1.Добавить в букет  2.Показать состав букета (цену) 3.Найти в букете цветок 4.Редактировать цену по id  5.Удалить компонент c id  6.Выход в предыдущее меню(или другой)\"" + Color.DEFAULT);
            switch (scanner.next()) {
                case "1": {
                    createBuket(scanner);
                    break;
                }
                case "2": {
                    getShowCreatedBuket();
                    break;
                }
                case "3": {
                    findFlowerWithLenght(scanner);
                    break;
                }
                case "4": {
                    updatePriceInBuketByIdKomponent(scanner);
                    break;
                }
                case "5": {
                    removeKomponentInBuketByIdKomponent(scanner);
                    break;
                }
                default: {
                    keyOut = false;
                }
            }
        }

    }

    private void updatePriceInBuketByIdKomponent(Scanner scanner) {
        System.out.println("Введите новую цену компонента в букете : ");
        double tmpPrice = scanner.nextDouble();
        System.out.println("Введите ID редактируемого компонента ID ? : ");
        int tmpId = scanner.nextInt();
        System.out.println("Редактирование записи ID: " + tmpId + ", результат: " + objDaoBuket.updatePriceById(tmpPrice, tmpId));
    }

    private void removeKomponentInBuketByIdKomponent(Scanner scanner) {
        System.out.println("Введите ID удаляемого компонента ID ? : ");
        int tmpId = scanner.nextInt();
        System.out.println("Удаление записи ID: " + tmpId + ", результат: " + objDaoBuket.removeById(tmpId));
    }

    private void createBuket(Scanner scanner) {
        boolean keyOutOf = true;
        while (keyOutOf) {
            System.out.println(Color.BLUE + "MEHЮ СОЗДАНИЯ БУКЕТА. ЧТО ДОБАВЛЯЕМ? Выберите номер и нажмите Enter:" + Color.DEFAULT);
            System.out.println(Color.PING + "1. Добавить цветы  " + Color.YELLOW + "  2. Добавить аксессуары " + Color.BLUE + " 3. Выйти в предыдущее меню" + Color.DEFAULT);
            switch (scanner.next()) {
                case "1": {
                    getAddOneMenu(scanner);
                    break;
                }
                case "2": {
                    getAddTwoMenu(scanner);
                    break;
                }

                default: {
                    keyOutOf = false;
                }
            }

        }
    }

    private void findFlowerWithLenght(Scanner scanner) {
        System.out.println(Color.BLUE + "Найти цветок в букете, соответствующий заданному диапазону длин стеблей (от X до Y см): " + Color.DEFAULT);
        System.out.println("Введите начальную длину, см X : ");
        int startLenghtFlower = scanner.nextInt();
        System.out.println("Введите конечную длину, см Y : ");
        int finishLenghtFlower = scanner.nextInt();

        List<Flower> findLenghtFlower = new ArrayList<>();
        List<Tovar> buketTovarList = objDaoBuket.getAll();
        for (Tovar bt : buketTovarList) {
            Buket buket = (Buket) bt;
            if (buket.getGroupTovar().equalsIgnoreCase("Flower")) {
                long id = buket.getIdTovar();
                if (DAOFactoryImpl.getInstace().getDAOFlower().get(id).getLengthFlower() >= startLenghtFlower && DAOFactoryImpl.getInstace().getDAOFlower().get(id).getLengthFlower() <= finishLenghtFlower)
                    findLenghtFlower.add(DAOFactoryImpl.getInstace().getDAOFlower().get(id));
            }
        }
        System.out.println(Color.BLUE + "Цветы в букете с длиной стеблей от: " + startLenghtFlower + " до: " + finishLenghtFlower + " см.): " + Color.DEFAULT);
        if (findLenghtFlower.size() == 0) {
            System.out.println("Не найдено!");

        } else {

            for (Flower fl : findLenghtFlower) {
                System.out.println("name='" + fl.getName() + '\'' +
                                ", color='" + fl.getColorFlower() + '\'' +
                                ", dateOfAdd=" + fl.getDateOfAdd() +
                                ", timeStorageHour=" + fl.getTimeStorageHour() +
                                ", lengthFlower=" + fl.getLengthFlower() +
                                ", price=" + fl.getPrice());
            }
        }
    }

    private void getShowCreatedBuket() {
        if (objDaoBuket.getAll().size() == 0) {
            System.out.println("Букет не сформирован, необходимо добавить его компоненты");
        } else {
            List<Tovar> buketTovarList = objDaoBuket.getAll();
            buketTovarList.sort(new Comparator<Tovar>() {
                @Override
                public int compare(Tovar o1, Tovar o2) {
                    return o1.getDateOfAdd().compareTo(o2.getDateOfAdd());
                }
            });
            double zina = 0;
            System.out.println(Color.BLUE + "Состав букета:" + Color.DEFAULT);
            for (Tovar bt : buketTovarList) {
                System.out.println(bt);
                zina += bt.getPrice();
            }

            System.out.println(Color.BLUE + "Итоговая цена букета: " + zina + Color.DEFAULT);
            System.out.println(Color.BIRUZOVII + "Сортировка букета произведена по свежести цветов: " + Color.DEFAULT);
        }

    }


    private void getAddOneMenu(Scanner scanner) {
        boolean keyOutOf = true;
        while (keyOutOf) {
            System.out.println(Color.PING + "Добавление цветов:" + Color.DEFAULT);
            System.out.println(Color.PING + " 1. Добавление по Id:  2. Просмотреть все Id цветов  3. выйти в предыдущее меню" + Color.DEFAULT);
            switch (scanner.next()) {
                case "1": {
                    System.out.println("Введите Id Цветка:");
                    int tmpId = scanner.nextInt();
                    boolean result = objDaoBuket.add(DAOFactoryImpl.getInstace().getDAOFlower().get(tmpId));
                    System.out.println("Добавлен цветок с ID: " + tmpId + ", результат: " + result);
                    break;

                }
                case "2": {
                    System.out.println(Color.PING + "Вcе цветы:" + Color.DEFAULT);
                    List<Flower> flowerList = DAOFactoryImpl.getInstace().getDAOFlower().getAll();
                    for (Flower flower : flowerList) {
                        System.out.println(flower);
                    }
                    break;

                }
                default: {
                    keyOutOf = false;
                }

            }

        }
    }

    private void getAddTwoMenu(Scanner scanner) {
        boolean keyOutOf = true;
        while (keyOutOf) {
            System.out.println(Color.YELLOW + "Добавление аксессуаров:" + Color.DEFAULT);
            System.out.println(Color.YELLOW + "1. Добавление по Id:  2. Просмотреть все Id аксессуаров  3. выйти в предыдущее меню" + Color.DEFAULT);
            switch (scanner.next()) {
                case "1": {
                    System.out.println("Введите Id Аксессуара:");
                    int tmpId = scanner.nextInt();
                    boolean result = objDaoBuket.add(DAOFactoryImpl.getInstace().getDAOAccesories().get(tmpId));
                    System.out.println("Добавлен аксессуар с ID: " + tmpId + ", результат: " + result);
                    break;

                }
                case "2": {
                    System.out.println("Вcе аксессуары:");
                    List<Accessories> accessoriesList = DAOFactoryImpl.getInstace().getDAOAccesories().getAll();
                    for (Accessories accessories : accessoriesList) {
                        System.out.println(accessories);
                    }
                    break;

                }
                default: {
                    keyOutOf = false;
                }

            }

        }

    }
}
