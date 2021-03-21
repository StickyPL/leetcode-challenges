package org.home.leetcode;

import java.util.Arrays;
import java.util.BitSet;

public class SetMismatch {

    public int[] findErrorNums(int[] nums) {
        BitSet visited = new BitSet(nums.length + 1);
        int dup = -1;

        for (int n : nums) {
            if (visited.get(n)) {
                dup = n;
            }
            visited.set(n);
        }
        return new int[]{dup, visited.nextClearBit(1)};
    }

    public static void main(String[] args) {
        SetMismatch sm = new SetMismatch();
        int[] set1 = new int[]{1, 2, 2, 4};
        int[] exp1 = new int[]{2, 3};
        int[] act1 = sm.findErrorNums(set1);

        if (!sm.testResult(exp1, act1)) {
            System.err.println(String.format("Test failed for set: %s, actual value: %s", Arrays.toString(set1), Arrays.toString(act1)));
        }

        int[] set2 = new int[]{1, 1};
        int[] exp2 = new int[]{1, 2};
        int[] act2 = sm.findErrorNums(set2);

        if (!sm.testResult(exp2, act2)) {
            System.err.println(String.format("Test failed for set: %s, actual value: %s", Arrays.toString(set2), Arrays.toString(act2)));
        }

        int[] set3 = new int[]{2, 2};
        int[] exp3 = new int[]{2, 1};
        int[] act3 = sm.findErrorNums(set3);

        if (!sm.testResult(exp3, act3)) {
            System.err.println(String.format("Test failed for set: %s, actual value: %s", Arrays.toString(set3), Arrays.toString(act3)));
        }


        int[] set4 = new int[]{3, 2, 2};
        int[] exp4 = new int[]{2, 1};
        int[] act4 = sm.findErrorNums(set4);

        if (!sm.testResult(exp4, act4)) {
            System.err.println(String.format("Test failed for set: %s, actual value: %s", Arrays.toString(set4), Arrays.toString(act4)));
        }


        int[] set5 = new int[]{1, 2, 2};
        int[] exp5 = new int[]{2, 3};
        int[] act5 = sm.findErrorNums(set5);

        if (!sm.testResult(exp5, act5)) {
            System.err.println(String.format("Test failed for set: %s, actual value: %s", Arrays.toString(set5), Arrays.toString(act5)));
        }

        System.out.println("All tests passed");


    }

    private boolean testResult(int[] expected, int[] actual) {
        boolean test = true;
        test &= expected.length == actual.length;
        test &= Arrays.equals(expected, actual);
        return test;
    }
}
