package Backtracking;

import java.util.Map;

public class ConfusingNumberII {
    public static void main(String[] args) {

    }

    private int confusingNumber(Map<Integer, Integer> map, int num, int rotatedNum, int base, int n) {
        if (num > n || num < 0) return 0;
        int count = (num != rotatedNum && num != 0) ? 1 : 0;
        for (int key : map.keySet()) {
            int val = map.get(key);
            if ((num == 0 && key == 0) || num > 100_000_000) continue;
            count += confusingNumber(map, num * 10 + key, val * base + rotatedNum, base * 10, n);
        }
        return count;
    }
}
