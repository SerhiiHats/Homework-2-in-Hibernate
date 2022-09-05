import color.Color;
import handlerMenuConsol.ConsolMenuAccesories;
import handlerMenuConsol.ConsolMenuBuket;
import handlerMenuConsol.ConsolMenuFlower;

import java.util.Scanner;

/** Домашнее задание 2
 * Задание 2
 * Написать DAO к дополнительному заданию.
 *
 * Дополнительное задание:
 * Написать консольное приложение (одно на выбор) из данного списка в книге
 * JAVA_Methods_Programming_v2.march2015 на странице 126,
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
        boolean keyOutOf = true;
        Scanner scanner = new Scanner(System.in);
        while (keyOutOf) {
            System.out.println(Color.GREEN + "ГЛАВНОЕ МЕНЮ. Выберите номер и нажмите Enter:");
            System.out.println("1. МЕНЮ - Букет   " + Color.PING + "  2. МЕНЮ - Цветы  " + Color.YELLOW + "   3. МЕНЮ - Аксессуары  " + Color.DEFAULT + "   4. Выход из программы (или другой)" + Color.DEFAULT);
            switch (scanner.next()) {
                case "1": {
                    //  servicesBuket.showMenu();
                    new ConsolMenuBuket().showMenu();
                    break;
                }
                case "2": {
                    new ConsolMenuFlower().showMenu();
                    break;
                }
                case "3": {
                    new ConsolMenuAccesories().showMenu();
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
