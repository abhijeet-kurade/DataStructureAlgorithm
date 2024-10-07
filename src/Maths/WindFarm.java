package Maths;

import java.util.*;

// Math and 2d geometry
public class WindFarm {

    public static int windFarm(List<Integer> premium, List<Integer> x, List<Integer> y) {
        int cx = findWeightedMedian(x, premium);
        int cy = findWeightedMedian(y, premium);

        int totalCost = 0;
        for (int i = 0; i < premium.size(); i++) {
            int distance = Math.abs(x.get(i) - cx) + Math.abs(y.get(i) - cy);
            totalCost += premium.get(i) * distance;
        }

        return totalCost;
    }

    private static int findWeightedMedian(List<Integer> coords, List<Integer> premium) {
        int n = coords.size();
        List<int[]> farms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            farms.add(new int[]{coords.get(i), premium.get(i)});
        }

        farms.sort(Comparator.comparingInt(a -> a[0]));

        int totalWeight = premium.stream().mapToInt(Integer::intValue).sum();
        int cumulativeWeight = 0;

        for (int[] farm : farms) {
            cumulativeWeight += farm[1];
            if (cumulativeWeight >= totalWeight / 2) {
                return farm[0];
            }
        }

        return farms.get(n - 1)[0];
    }
    public static int getTripleCount(List<Integer> a, int d) {
        int n = a.size();
        int[] rem_count = new int[d];

        for (int value : a) {
            rem_count[value % d]++;
        }

        int count = 0;

        for (int r1 = 0; r1 < d; r1++) {
            for (int r2 = r1; r2 < d; r2++) {
                int r3 = (d - (r1 + r2) % d) % d;

                if (r3 < r2) continue;

                if (r1 == r2 && r2 == r3) {
                    count += comb(rem_count[r1], 3);
                } else if (r1 == r2) {
                    count += comb(rem_count[r1], 2) * rem_count[r3];
                } else if (r2 == r3) {
                    count += rem_count[r1] * comb(rem_count[r2], 2);
                } else {
                    count += rem_count[r1] * rem_count[r2] * rem_count[r3];
                }
            }
        }

        return count;
    }

    private static int comb(int n, int k) {
        if (n < k) return 0;
        if (k == 3) return (n * (n - 1) * (n - 2)) / 6;
        if (k == 2) return (n * (n - 1)) / 2;
        return 0;
    }
    public static void main(String[] args) {
        WindFarm wf = new WindFarm();
        List<Integer> premium = Arrays.asList(1,1,1);
        List<Integer> x = Arrays.asList(5,2,3);
        List<Integer> y = Arrays.asList(3,4,7);

        int result = wf.windFarm(premium, x, y);
        System.out.println("Minimum cost to connect all farms: " + result);
    }
}
