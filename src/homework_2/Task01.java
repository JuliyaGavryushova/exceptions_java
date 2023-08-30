//Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
//и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
//вместо этого, необходимо повторно запросить у пользователя ввод данных.

package homework_2;

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        float result = inputFloatNum();
        System.out.println("Вы ввели число: " + result);
    }

    public static float inputFloatNum() {
        Scanner scanner = new Scanner(System.in);
        float num = 0;
        boolean validInput = false;
        do {
            System.out.println("Введите дробное число:");
            String input = scanner.nextLine();
            try {
                num = Float.parseFloat(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (!validInput);
        return num;
    }
}
