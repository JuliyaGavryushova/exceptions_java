//Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
//Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

package homework_2;

import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные: ");
        String input = scanner.nextLine();
        try {
            if (input.isEmpty()) {
                throw new Exception("Пустые строки вводить нельзя!");
            }
            System.out.println("Всё ок!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
