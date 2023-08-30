//Дан следующий код, исправьте его там, где требуется
//(задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
//public static void main(String[] args) throws Exception {
//        try {
//        int a = 90;
//        int b = 3;
//        System.out.println(a / b);
//        printSum(23, 234);
//        int[] abc = { 1, 2 };
//        abc[3] = 9;
//        } catch (Throwable ex) {
//        System.out.println("Что-то пошло не так...");
//        } catch (NullPointerException ex) {
//        System.out.println("Указатель не может указывать на null!");
//        } catch (IndexOutOfBoundsException ex) {
//        System.out.println("Массив выходит за пределы своего размера!");
//        }
//        }
//public static void printSum(Integer a, Integer b) throws FileNotFoundException {
//        System.out.println(a + b);
//        }

package homework_2;

//Ошибки в коде:
//1. Метод printSum «пробрасывает» исключение FileNotFoundException (файл не найден)
//2. Метод main «пробрасывает» исключение Exception, данное исключение является высокоуровневым, соответсвенно
// при попытке скомпилировать эту программу все исключения будут уже перехвачены, и операторы catch не будут выполнены.
//3. Думаю, правильным будет обработать следующие исключения: ArrayIndexOutOfВoundsException, ArithmeticException.
//

public class Task03 {
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Выход индекса за пределы массива...");
        } catch (ArithmeticException ex) {
            System.out.println("Деление на ноль!");
        }
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

}
