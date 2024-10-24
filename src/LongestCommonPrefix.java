import java.util.*;

public class LongestCommonPrefix {


    public String getLongestCommonPrefix (String[] str) {

        int i;
        int wordNumber = 0;
        int numberOfWords = str.length;

        Map<Character, Integer> letterPositionMap = new LinkedHashMap<>();
        String commonPrefix = "";


        while (wordNumber < numberOfWords) {

            for (i = 0; i < str[wordNumber].length(); i++) { // {flow, flower, flight}
                if (wordNumber == 0) {
                    letterPositionMap.put(str[wordNumber].charAt(i), i);
                } else {
                    if (letterPositionMap.containsKey(str[wordNumber].charAt(i))
                            && letterPositionMap.get(str[wordNumber].charAt(i)) == str[wordNumber].indexOf(str[wordNumber].charAt(i))) {
                            commonPrefix = commonPrefix + str[wordNumber].charAt(i);
                    } else {
                        if (wordNumber == numberOfWords-1) {
                            return commonPrefix;
                        }
                    }
                }
                System.out.println(letterPositionMap);
            }
            i = 0;
            wordNumber = wordNumber + 1;
            commonPrefix = "";
        }
        return "No common prefix";
    }


    public static void main (String[] args) {
        String[] str = {"flow", "flower", "flight", "foo", "gfdfg"};

        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.getLongestCommonPrefix(str));
    }
}
