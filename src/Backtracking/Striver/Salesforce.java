package Backtracking.Striver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Salesforce {
    public static void main(String[] args) {
        System.out.println(kthFactor(22876792454961l, 28));
    }

    public static long kthFactor(long n, long k) {
        List<Long> divisors = new ArrayList<>();
        List<Long> next = new ArrayList<>();
        int sqrtN = (int) Math.sqrt(n);
        for (long x = 1; x < sqrtN + 1; ++x) {
            if (n % x == 0) {
                --k;
                divisors.add(x);
                next.add(n/x);
                if (k == 0) {
                    return x;
                }
            }
        }

        // If n is a perfect square
        // we have to skip the duplicate
        // in the divisor list
        if (sqrtN * sqrtN == n) {
            ++k;
        }

        Collections.reverse(next);

        int nDiv = divisors.size();
        System.out.println(divisors);
        System.out.println(next);
        return (k <= nDiv) ? n / divisors.get( (int)(nDiv - k)) : 0;
    }
}
