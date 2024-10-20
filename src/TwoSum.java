import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {

    public int[] twoSums(int[] nums, int target) {
        int currDifference;

        Map<Integer, Integer> numberIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numberIndex.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            currDifference = target - nums[i];
            if (numberIndex.containsKey(currDifference) && numberIndex.get(currDifference) - i == 1) {
                return new int[]{i+1, numberIndex.get(currDifference)+1};
            }
        }
        return null;
    }

   public static void main (String[] args) {
       System.out.println("Enter array");
       Scanner sc = new Scanner(System.in);

       String[] stringNums = sc.nextLine().split(",");
       int[] nums = new int[stringNums.length];
       for (int i =0; i < stringNums.length; i++) {
           nums[i] = Integer.parseInt(stringNums[i]);
       }

       System.out.println("Enter target");
       Scanner scanner = new Scanner(System.in);
       int target = sc.nextInt();

       TwoSum twoSum = new TwoSum();

       int[] result = twoSum.twoSums(nums, target);
       System.out.println(Arrays.toString(result));

       if (result == null) {
           System.out.println("Unfortunately there is no any pair of number, which cold make a sum of a target " + target);
       }
   }
}
