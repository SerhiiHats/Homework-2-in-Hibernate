import color.Color;
import handlerInstances.HandlerAccessories;
import handlerInstances.HandlerFlawers;
import models.Accessories;
import models.Flower;
import handlerConsol.ConsolAccessories;
import handlerConsol.ConsolBuket;
import handlerConsol.ConsolFlawer;
import handlerInstances.HandlerBuket;
import storage.Storage;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Домашнее задание 2
 * Задание 3
 * Написать консольное приложение (одно на выбор) из данного списка в книге
 * JAVA_Methods_Programming_v2.march2015 на странице 126,
 * не используя доступа к базе данных и DAO.
 * <p>
 * Выбранный вариант задания:
 * Цветочница.
 * Определить иерархию цветов.
 * Создать несколько объектов-цветов.
 * Собрать букет (используя аксессуары) с определением его стоимости.
 * Провести сортировку цветов в букете на основе уровня свежести.
 * Найти цветок в букете, соответствующий заданному диапазону длин стеблей.
 **/

public class Main {
    public static void main(String[] args) {
        Flower flower1 = new Flower("тюльпан", "желтый", 39, 127, 25.5);
        Flower flower2 = new Flower("хризантема", "белый", 45, 105, 37.5);
        flower2.setDateOfAdd(2022, 8, 20, 07, 40);
        Flower flower3 = new Flower("хризантема", "розовый", 41, 105, 40.5);
        flower3.setDateOfAdd(2022, 8, 27, 10, 07);
        Flower flower4 = new Flower("альстромерия", "белый", 55, 117, 45.5);
        flower4.setDateOfAdd(2022, 8, 27, 8, 17);
        Flower flower5 = new Flower("хризантема", "красный", 31, 105, 35.5);
        flower5.setDateOfAdd(2022, 8, 25, 14, 20);
        Storage.flowerList.addAll(Arrays.asList(flower1, flower2, flower3, flower4, flower5));

        Accessories acces1 = new Accessories("бумага для букетов", "подарочная, принт газетный 100 х 100", 17520, 75.5);
        Accessories acces2 = new Accessories("коробка для букетов", "круглая, принт франция 30 х 30", 10000, 120.0);
        Accessories acces3 = new Accessories("лента для букетов", "розовая 15 х 40", 15575, 20.0);
        Storage.accessoriesListList.addAll(Arrays.asList(acces1, acces2, acces3));

        HandlerBuket hdlBuket = new HandlerBuket();
        HandlerAccessories hdlAccesories = new HandlerAccessories();
        HandlerFlawers hdlFlawers = new HandlerFlawers();

        ConsolBuket servicesBuket = new ConsolBuket(hdlBuket);
        ConsolAccessories servicesAcces = new ConsolAccessories(hdlAccesories);
        ConsolFlawer servicesFlawer = new ConsolFlawer(hdlFlawers);

        boolean keyOutOf = true;
        Scanner scanner = new Scanner(System.in);
        while (keyOutOf) {
            System.out.println(Color.GREEN + "ГЛАВНОЕ МЕНЮ. Выберите номер и нажмите Enter:");
            System.out.println("1. МЕНЮ - Букет   " + Color.PING + "  2. МЕНЮ - Цветы  " + Color.YELLOW + "   3. МЕНЮ - Аксессуары  " + Color.DEFAULT + "   4. Выход из программы (или другой)" + Color.DEFAULT);
            switch (scanner.next()) {
                case "1": {
                    servicesBuket.showMenu();
                    break;
                }
                case "2": {
                    servicesFlawer.showMenu();
                    break;
                }
                case "3": {
                    servicesAcces.showMenu();
                    break;
                }
                default: {
                    keyOutOf = false;
                }
            }
        }
        scanner.close();
    }
}

