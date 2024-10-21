import java.util.Arrays;
import java.util.Scanner;

public class MaximumSubarray {

    public int maxSubArray (int[] nums) {
        int maxSum = 0;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum = Math.max (nums[i], currentSum + nums[i]);

            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {

        // algorithm Kadane
        // -1, 7, 0
        System.out.println("Input an array");
        Scanner sc = new Scanner(System.in);

        String[] stringNum = sc.nextLine().split(",");

        int[] nums = Arrays.stream(stringNum)
                    .mapToInt(Integer::parseInt)
                    .toArray();

        MaximumSubarray ms = new MaximumSubarray();
        int result = ms.maxSubArray(nums);

        System.out.println("Result= " + result);
    }
}
