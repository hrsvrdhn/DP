import java.io.*;
import java.util.*;

class LargestSumContiguousSubarray {
        public static void main(String[] args) {
            int[] arr = {3, 5, -2, 9, -1, -10, 3, 4, 5};
            System.out.println("Max subarray sum: " +
                    maxSubArraySum(arr));
        }

        static int maxSubArraySum(int a[]) {
            int max_so_far = a[0];
            int curr_max = a[0];

            for (int i = 1; i < a.length; i++) {
                curr_max = Math.max(a[i], curr_max + a[i]);
                max_so_far = Math.max(max_so_far, curr_max);
            }
            return max_so_far;
        }
}