import java.util.*;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {

        String[] numbers = String.valueOf(x).split("");

        int firstDigit = 0;
        int lastDigit = numbers.length - 1;

        while (firstDigit < lastDigit) {
            if (numbers[firstDigit].equals(numbers[lastDigit])) { // String compares with equals; == compare hashCodes
                firstDigit++;
                lastDigit--;
            } else return false;
        }
        return true;
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
