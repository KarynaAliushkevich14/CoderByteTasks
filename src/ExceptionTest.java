import java.util.Arrays;
import java.util.logging.Logger;

public class ExceptionTest {

    private static final Logger logger = Logger.getLogger(ExceptionTest.class.getName());

    public void processNumbers (String[] array)  {
        int i = 0;
        int sum = 0;

        int[] intArray = new int[array.length];

        while (i < array.length) {

            if (!array[i].matches("-?\\d+")) {
                throw new NumberFormatException("Value is not a digit"); //unchecked Exception. I can handle it, but it is not necessary.
            }

            intArray[i] = Integer.valueOf(array[i]);
            sum += intArray[i];

            i++;
        }

        System.out.println("Int array: " + Arrays.toString(intArray));
        System.out.println("Sum: " + sum);

        if (sum > 100) {
            throw new SumIsMoreThanExpectedValue("Sum is more than expected");
        }
    }

    public static void main(String[] args) {

        try {

            ExceptionTest exceptionTest = new ExceptionTest();
            exceptionTest.processNumbers(new String[] {"-1", "200", ""});

        } catch (NumberFormatException numberFormatException) {
            logger.warning("2 exception: " + numberFormatException.getMessage());
        } catch (SumIsMoreThanExpectedValue sumIsMoreThanExpectedValue) {
            logger.warning("2 exception: " + sumIsMoreThanExpectedValue.getMessage());
        }
    }

    public class SumIsMoreThanExpectedValue extends RuntimeException {
        public SumIsMoreThanExpectedValue (String message) {
            super(message);
        }
    }
}


//public class ExceptionTask {
//
//    public static void main(String[] args) {
//        String[] numbers = {"10", "20", "abc", "40", "60", "5"};
//
//        try {
//            int result = processNumbers(numbers);
//            System.out.println("Сумма чисел: " + result);
//        } catch (NumberFormatException e) {
//            System.out.println("Ошибка формата числа: " + e.getMessage());
//        } catch (IllegalArgumentException e) {
//            System.out.println("Ошибка суммы: " + e.getMessage());
//        } finally {
//            System.out.println("Процесс завершён.");
//        }
//    }
//
//    public static int processNumbers(String[] numbers) {
//        int sum = 0;
//
//        for (String numStr : numbers) {
//            try {
//                int num = Integer.parseInt(numStr);
//                sum += num;
//
//                if (sum > 100) {
//                    throw new IllegalArgumentException("Сумма превышает допустимое значение 100");
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Не удалось преобразовать строку в число: " + numStr);
//                // Пропускаем это число и продолжаем
//            }
//        }
//
//        return sum;
//    }
//}