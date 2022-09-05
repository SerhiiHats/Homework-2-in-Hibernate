package handlerConsol;

import color.Color;
import models.Accessories;
import models.Flower;
import models.Tovar;
import handlerInstances.HandlerBuket;
import handlerInstances.HandlerAccessories;
import handlerInstances.HandlerFlawers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ConsolBuket {
    HandlerBuket objBuket;
    boolean keyOutOf1;

    public ConsolBuket(HandlerBuket objBuket) {
        this.objBuket = objBuket;

    }

    public void showMenu() {
        boolean keyout = true;
        Scanner scanner = new Scanner(System.in);
        while (keyout) {
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
                    keyout = false;
                }
            }
        }

    }

    private void removeKomponentInBuketByIdKomponent(Scanner scanner) {
        System.out.println("Введите ID удаляемого компонента ID ? : ");
        int tmpId = scanner.nextInt();
        System.out.println("Удаление записи ID: " + tmpId + ", результат: " + objBuket.remove(tmpId));
    }

    private void updatePriceInBuketByIdKomponent(Scanner scanner) {
        System.out.println("Введите новую цену компонента в букете : ");
        double tmpPrice = scanner.nextDouble();
        System.out.println("Введите ID редактируемого компонента ID ? : ");
        int tmpId = scanner.nextInt();
        System.out.println("Редактирование записи ID: " + tmpId + ", результат: " + objBuket.update(tmpPrice, tmpId));
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
        List<Tovar> buketList = objBuket.getBuket();
        for (Tovar tovar : buketList) {
            if (tovar.getClass().getSimpleName().equalsIgnoreCase("Flower")) {
                Flower flower = (Flower) tovar;
                if (flower.getLengthFlower() >= startLenghtFlower && flower.getLengthFlower() <= finishLenghtFlower)
                    findLenghtFlower.add(flower);
            }
        }
        System.out.println(Color.BLUE + "Цветы в букете с длиной стеблей от: " + startLenghtFlower + " до: " + finishLenghtFlower + " см.): " + Color.DEFAULT);
        if (findLenghtFlower.size() == 0) {
            System.out.println("Не найдено!");

        } else {

            for (Flower flower : findLenghtFlower) {
                System.out.println(flower);
            }
        }
    }

    private void getShowCreatedBuket() {
        if (objBuket.getBuket().size() == 0) {
            System.out.println("Букет не сформирован, необходимо добавить его компоненты");
        } else {

            objBuket.getBuket().sort(new Comparator<Tovar>() {
                @Override
                public int compare(Tovar o1, Tovar o2) {
                    return o1.getDateOfAdd().compareTo(o2.getDateOfAdd());
                }
            });
            double zina = 0;
            System.out.println(Color.BLUE + "Состав букета:" + Color.DEFAULT);
            for (int i = 0; i < objBuket.getBuket().size(); i++) {
                System.out.println("id: " + i + " " + objBuket.get(i));
                zina += objBuket.get(i).getPrice();
            }
            System.out.println(Color.BLUE + "Итоговая цена букета: " + zina + Color.DEFAULT);
            System.out.println(Color.BIRUZOVII + "Сортировка букета произведена по свежести цветов: " + Color.DEFAULT);
        }

    }


    private void getAddOneMenu(Scanner scanner) {
        keyOutOf1 = true;
        while (keyOutOf1) {
            System.out.println(Color.PING + "Добавление цветов:" + Color.DEFAULT);
            System.out.println(Color.PING + " 1. Добавление по Id: 2. Просмотреть все Id цветов 3. выйти в предыдущее меню" + Color.DEFAULT);
            switch (scanner.next()) {
                case "1": {
                    System.out.println("Введите Id Цветка:");
                    int tmpId = scanner.nextInt();
                    System.out.print("Добавлен цветок с ID: " + tmpId + ", результат: ");
                    if (tmpId < new HandlerFlawers().getAll().size() && tmpId >= 0) {
                        objBuket.add(new HandlerFlawers().getAll().get(tmpId));
                        System.out.println("true");
                        break;
                    } else {
                        System.out.println("false");
                    }
                    break;

                }
                case "2": {
                    System.out.println(Color.PING + "Вcе цветы:" + Color.DEFAULT);
                    List<Flower> flowers = new HandlerFlawers().getAll();
                    for (int i = 0; i < flowers.size(); i++) {
                        System.out.println("id: " + i + " " + flowers.get(i));
                    }
                    break;

                }
                default: {
                    keyOutOf1 = false;
                }

            }

        }
    }

    private void getAddTwoMenu(Scanner scanner) {
        keyOutOf1 = true;
        while (keyOutOf1) {
            System.out.println(Color.YELLOW + "Добавление аксессуаров:" + Color.DEFAULT);
            System.out.println(Color.YELLOW + "1. Добавление по Id: 2. Просмотреть все Id аксессуаров 3. выйти в предыдущее меню" + Color.DEFAULT);
            switch (scanner.next()) {
                case "1": {
                    System.out.println("Введите Id Аксессуара:");
                    int tmpId = scanner.nextInt();
                    System.out.print("Добавлен аксессуар с ID: " + tmpId + ", результат: ");
                    if (tmpId < new HandlerAccessories().getAll().size() && tmpId >= 0) {
                        objBuket.add(new HandlerAccessories().getAll().get(tmpId));
                        System.out.println("true");
                        break;
                    } else {
                        System.out.println("false");
                    }
                    break;

                }
                case "2": {
                    System.out.println("Вcе аксессуары:");
                    List<Accessories> accessories = new HandlerAccessories().getAll();
                    for (int i = 0; i < accessories.size(); i++) {
                        System.out.println("id: " + i + " " + accessories.get(i));
                    }
                    break;

                }
                default: {
                    keyOutOf1 = false;
                }

            }

        }

    }
}
