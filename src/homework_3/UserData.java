//Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке,
//разделенные пробелом:
//   Фамилия Имя Отчество датарождения номертелефона пол
//Форматы данных:
//   фамилия, имя, отчество - строки
//   датарождения - строка формата dd.mm.yyyy
//   номертелефона - целое беззнаковое число без форматирования
//   пол - символ латиницей f или m.
//Приложение должно проверить введенные данные по количеству.
//Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение,
//что он ввел меньше и больше данных, чем требуется.
//Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
//Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
//Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано,
//пользователю выведено сообщение с информацией, что именно неверно.
//Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
//в него в одну строку должны записаться полученные данные, вида
//   <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
//Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
//Не забудьте закрыть соединение с файлом.
//При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
//пользователь должен увидеть стектрейс ошибки.

package homework_3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные пользователя в следующем формате: Фамилия Имя Отчество ДатаРождения(dd.mm.yyyy) НомерТелефона Пол(f/m)");
        String userData = scanner.nextLine();

        String[] data = userData.split(" ");
        if (data.length != 6) {
            throw new RuntimeException("Введено неправильное количество данных!");
        }

        String surname = data[0];
        String name = data[1];
        String patronymic = data[2];
        String birthDate = data[3];
        String phoneNumber = data[4];
        String gender = data[5];

        try {
            validateDateFormat(birthDate);
            validatePhoneNumber(phoneNumber);
            validateGender(gender);
            saveUserData(surname, name, patronymic, birthDate, phoneNumber, gender);
            System.out.println("Данные успешно сохранены!");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл:");
            e.printStackTrace();
        }
    }

    public static void validateDateFormat(String birthDate) {
        if (!birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            throw new IllegalArgumentException("Неправильный формат даты рождения. Используйте формат dd.mm.yyyy.");
        }
    }

    public static void validatePhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Неправильный формат номера телефона. Используйте только цифры без пробелов.");
        }
    }

    public static void validateGender(String gender) {
        if (!gender.matches("[fm]")) {
            throw new IllegalArgumentException("Неправильное значение пола. Используйте 'f' или 'm'.");
        }
    }

    public static void saveUserData(String surname, String name, String patronymic, String birthDate, String phoneNumber, String gender) throws IOException {
        String fileName = surname + ".txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(surname + " " + name + " " + patronymic + " " + birthDate + " " + phoneNumber + " " + gender);
            bw.newLine();
        }
    }
}
