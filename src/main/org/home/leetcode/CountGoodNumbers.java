package org.home.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountGoodNumbers {

    /**
     * A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).
     *
     * For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. However, "3245" is not good because 3 is at an even index but is not even.
     * Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.
     *
     * A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.
     *
     *
     *
     * Example 1:
     *
     * Input: n = 1
     * Output: 5
     * Explanation: The good numbers of length 1 are "0", "2", "4", "6", "8".
     * Example 2:
     *
     * Input: n = 4
     * Output: 400
     * Example 3:
     *
     * Input: n = 50
     * Output: 564908303
     * @param n
     * @return count of good numbers
     */
    public int countGoodNumbers(long n) {
        goodNumbersE = new HashMap<>();
        goodNumbersO = new HashMap<>();
        return countGoodNumbers(5,4,n, (int)Math.pow(10, 9)+7);
    }

    private Map<Long, Integer> goodNumbersE = new HashMap<>();
    private Map<Long, Integer> goodNumbersO = new HashMap<>();

    private void memorize(boolean isPrimeOdds, long n, int val) {
        if (isPrimeOdds) {
            goodNumbersE.put(n, val);
        } else {
            goodNumbersO.put(n, val);
        }
    }
    private int countGoodNumbers(int evenCount, int oddCount, long n, int mod) {
        boolean isPrimeOdds = evenCount==5;
        if (n == 1) return evenCount;
        if (n==2) return evenCount*oddCount;
        if (isPrimeOdds && goodNumbersE.containsKey(n)) return goodNumbersE.get(n);
        if(!isPrimeOdds && goodNumbersO.containsKey(n)) return goodNumbersO.get(n);

        int ret_val;
        if (n%2==0) {
            if (n%4==0) {
                long lhs = countGoodNumbers(evenCount, oddCount, n / 2, mod);
                long rhs = countGoodNumbers(evenCount, oddCount, n / 2, mod);
                ret_val =  (int)((lhs * rhs) % mod);
            } else {
                long lhs = countGoodNumbers(evenCount, oddCount, n / 2, mod);
                long rhs = countGoodNumbers(oddCount, evenCount, n / 2, mod);
                ret_val = (int)((lhs * rhs) % mod);
            }
        } else {
            long val = countGoodNumbers(evenCount, oddCount,n-1,mod);
            ret_val = (int)((val*evenCount)%mod);
        }

        memorize(isPrimeOdds, n, ret_val);
        return ret_val;
    }

    public static void main(String[] args) {
        CountGoodNumbers cgn = new CountGoodNumbers();
        System.out.println("1: "+cgn.countGoodNumbers(1));
        System.out.println("2: "+cgn.countGoodNumbers(2));
        System.out.println("3: "+cgn.countGoodNumbers(3));
        System.out.println("4: "+cgn.countGoodNumbers(4));
        System.out.println("5: "+cgn.countGoodNumbers(5));
        System.out.println("6: "+cgn.countGoodNumbers(6));
        System.out.println("8: "+cgn.countGoodNumbers(8));
        System.out.println("50: "+cgn.countGoodNumbers(50));
//        System.out.println("50: "+cgn.countGoodNumbers(500000));

        // e*p*e*p*e = 5^3*4*2=125*16

        int res = 0;
        res = cgn.countGoodNumbers(806166225460393L);
        System.out.println("806166225460393: "+res);
        assert res == 643535977;
    }
}
