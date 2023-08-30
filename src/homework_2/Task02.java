//Если необходимо, исправьте данный код
//(задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
//try {
//        int d = 0;
//        double catchedRes1 = intArray[8] / d;
//        System.out.println("catchedRes1 = " + catchedRes1);
//        } catch (ArithmeticException e) {
//        System.out.println("Catching exception: " + e);
//        }


package homework_2;

//Ошибка в данном коде заключается в том, что переменная intArray не была объявлена, а также помимо обработки
//исключения ArithmeticException, необходимо обработать исключение ArrayIndexOutOfВoundsException в случае
//выхода индекса за пределы массива.
public class Task02 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        divNum(arr);
    }

    public static void divNum(int[] intArray) {
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bounds: " + e);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}