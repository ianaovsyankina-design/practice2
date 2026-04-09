package part1.part1_3;

import java.util.ArrayList;
import java.util.Arrays;
import part1.part1_1.BankAccount;

/**
 * Задание 1.3 — Ключевое слово var
 */
public class VarDemo {

    public static void main(String[] args) {

        // === Рабочие примеры var ===

        // Пример 1 — целое число
        var number = 42;
        System.out.println(number + " -> " + ((Object) number).getClass().getSimpleName());

        // Пример 2 — строка
        var text = "Java";
        System.out.println(text + " -> " + text.getClass().getSimpleName());

        // Пример 3 — ArrayList
        var list = new ArrayList<>(Arrays.asList("один", "два"));
        System.out.println(list + " -> " + list.getClass().getSimpleName());

        // Пример 4 — массив
        var array = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(array) + " -> " + array.getClass().getSimpleName());

        // Пример 5 — ваш собственный объект BankAccount
        var account = new BankAccount("Тест", 0);
        System.out.println(account.getClass().getSimpleName() + " -> " + account.getClass().getSimpleName());
    }
}
