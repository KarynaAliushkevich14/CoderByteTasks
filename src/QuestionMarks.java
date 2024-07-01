import com.sun.tools.javac.Main;

import java.util.Scanner;
import java.util.logging.Logger;

class QuestionMarks {

    public static boolean QuestionsMarks(String str) {
        Logger logger = Logger.getLogger(QuestionMarks.class.getName());

        // code goes here   aab3???uu8oo4?6
        int firstDigit = 0;
        int secondDigit = 0;
        int sumOfQuestionMarks = 0;
        int sumOfTwoDigits = 0;

        for (int i=0; i<str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                // przypisanie do pierwszej i drugiej cyfry zmienne
                if (firstDigit == 0) {
                    firstDigit = Character.getNumericValue(str.charAt(i));
                } else {
                    secondDigit = Character.getNumericValue(str.charAt(i));
                }
                sumOfTwoDigits = firstDigit + secondDigit;
                if (sumOfTwoDigits == 10 && sumOfQuestionMarks % 3 == 0) {
                    return true;
                }
                // reset first and second digit
                if (secondDigit != 0) {
                    firstDigit = 0;
                    secondDigit = 0;
                    sumOfQuestionMarks = 0;
                }
            }
            if (str.charAt(i) == '?') {
                sumOfQuestionMarks += 1;
            }
        }
        logger.warning("Sum Of QuestionMarks= " + sumOfQuestionMarks);
        return false;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(QuestionsMarks(s.nextLine()));
    }
}