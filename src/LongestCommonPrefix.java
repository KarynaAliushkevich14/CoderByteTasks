
public class LongestCommonPrefix {

    public String getLongestCommonPrefix (String[] str) {

        String prefix = str[0];

        for (int i = 0; i < str.length; i++) { // {flow, flower, flight}
            while (str[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1); // ciągle zmniejszamy prefix dokóki on nie zmieści się w słowie_1,słowie_2 i słowie_3
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }


    public static void main (String[] args) {
        String[] str = {"flower", "flow", "flight"};

        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.getLongestCommonPrefix(str));

    }
}
