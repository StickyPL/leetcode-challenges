package org.home.leetcode;

import java.util.Arrays;
import java.util.BitSet;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        BitSet set = new BitSet(nums.length + 1);
        for (int n : nums) {
            set.set(n);
        }
        return set.nextClearBit(0);
    }

    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        boolean result = true;
        int[] nums1 = new int[]{3, 0, 1};
        int exp1 = 2;
        int act1 = mn.missingNumber(nums1);

        if (exp1 != act1) {
            System.err.println(String.format("Test failed for set: %s, expected: %d, actual value: %d", Arrays.toString(nums1), exp1, act1));
            result = false;
        }

        int[] nums2 = new int[]{0, 1};
        int exp2 = 2;
        int act2 = mn.missingNumber(nums2);

        if (exp2 != act2) {
            System.err.println(String.format("Test failed for set: %s, expected: %d, actual value: %d", Arrays.toString(nums2), exp2, act2));
            result = false;
        }

        int[] nums3 = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        int exp3 = 8;
        int act3 = mn.missingNumber(nums3);

        if (exp3 != act3) {
            System.err.println(String.format("Test failed for set: %s, expected: %d, actual value: %d", Arrays.toString(nums3), exp3, act3));
            result = false;
        }

        int[] nums4 = new int[]{0};
        int exp4 = 1;
        int act4 = mn.missingNumber(nums4);

        if (exp4 != act4) {
            System.err.println(String.format("Test failed for set: %s, expected: %d, actual value: %d", Arrays.toString(nums4), exp4, act4));
            result = false;
        }

        if (result) {
            System.out.println("All tests passed");
        } else {
            System.out.println("Tests failed");
        }
    }
}
