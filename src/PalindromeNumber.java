import java.util.*;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {

        try {
            int[] numbers = convertIntoArrayOfInt(x);

            int firstDigit = 0;
            int lastDigit = numbers.length - 1;

            while (firstDigit < lastDigit) {
                if (numbers[firstDigit] == numbers[lastDigit]) {
                    firstDigit++;
                    lastDigit--;
                } else return false;
            }

        } catch (NumberFormatException ex) {
            ex.getMessage();
        }
        return true;
    }

    public int[] convertIntoArrayOfInt(int x) {

        if (String.valueOf(x).matches("\\d+")) {
            int[] numbers = Arrays.stream(String.valueOf(x).split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            return numbers;
        } else {
            throw new NumberFormatException("Not a valid integer");
        }
    }

    public static void main (String[] args) {

        System.out.println("Input a number");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        PalindromeNumber palindrome = new PalindromeNumber();
        boolean result = palindrome.isPalindrome(number);

        System.out.println("Result: " + result);
    }
}
