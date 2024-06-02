import java.util.Scanner;

/** Task:
 * Have the function CodelandUsernameValidation(str) take the str parameter being passed and determine if the string is a valid username according to the following rules:
 *
 * 1. The username is between 4 and 25 characters.
 * 2. It must start with a letter.
 * 3. It can only contain letters, numbers, and the underscore character.
 * 4. It cannot end with an underscore character.
 *
 * If the username is valid then your program should return the string true, otherwise return the string false.
 *
 *
 * Examples:
 * Input: "u__hello_world123"
 * Output: true
 * */


public class CodelandUsernameValidationTask {
        public static boolean CodelandUsernameValidation(String str) {
            // code goes here
            int strLength = str.length();
            boolean isFirstSymbolALetter = Character.isLetter(str.charAt(0));
            boolean isLastSymbolNotUnderscore = str.charAt(strLength - 1) == '_';

            return !str.isEmpty() && strLength >= 4 && strLength <= 25 && isFirstSymbolALetter
                    && !isLastSymbolNotUnderscore && isStrContainsOnlyRequiredSymbols(str);
        }

        public static boolean isStrContainsOnlyRequiredSymbols(String str) {
            boolean flag = true;

            for (int i = 0; i < str.length(); i ++) {
                if (!Character.isLetterOrDigit(str.charAt(i)) && str.charAt(i) != '_') {
                    flag = false;
                }
            }
            return flag;
        }

        public static void main (String[] args) {
            // keep this function call here
            Scanner s = new Scanner(System.in);
            System.out.print(CodelandUsernameValidation(s.nextLine()));
        }
}


