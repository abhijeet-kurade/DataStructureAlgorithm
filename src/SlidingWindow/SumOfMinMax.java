package SlidingWindow;

import java.util.*;

public class SumOfMinMax {
    static int mod_val = (int)1e9+7;

    private static long mod_plus(long i, long j){
        long sum =(((i % mod_val) + (i % mod_val)) % mod_val);
        return sum;
    }

    public static int solve(ArrayList<Integer> A, int B) {
        Deque<Integer> min = new LinkedList<>();
        Deque<Integer> max = new LinkedList<>();
        int n = A.size();
        for(int i=0; i<B;i++) {
            while(!min.isEmpty() && A.get(min.peekLast()) >= A.get(i)) {
                min.removeLast();
            }
            while(!max.isEmpty() && A.get(max.peekLast()) <= A.get(i)) {
                max.removeLast();
            }
            min.add(i);
            max.add(i);
        }
        long sum = 0;
        for(int i=B; i<n;i++) {
            sum = mod_plus(sum, mod_plus(A.get(min.peekFirst()), A.get(max.peekFirst())));

            while(!min.isEmpty() && min.peekFirst() <= (i-B)) {
                min.removeFirst();
            }
            while(!max.isEmpty() && max.peekFirst() <= (i-B)) {
                max.removeFirst();
            }

            while(!min.isEmpty() && A.get(min.peekLast()) >= A.get(i)) {
                min.removeLast();
            }
            while(!max.isEmpty() && A.get(max.peekLast()) <= A.get(i)) {
                max.removeLast();
            }
            min.add(i);
            max.add(i);
        }
        sum = mod_plus(sum, mod_plus(A.get(min.peekFirst()), A.get(max.peekFirst())));
        return  sum > 0 ? (int)sum : mod_val+(int)sum;
    }


    public static void main(String[] args) {
        int[] arr = {3, -1, 4, 7, 6, 9, 2, 5, 7, 8, 15};
        System.out.println(sumOfMinMax(arr, 4));
    }

    // min and max in given window using deque
    public static List<Integer> sumOfMinMax(int[] arr, int k){
        int n= arr.length;

        List<Integer> mins = new ArrayList<>();
        List<Integer> maxs = new ArrayList<>();

        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();

        for(int i=0; i<k; i++){
            int num = arr[i];
            while(!minDeque.isEmpty() && arr[minDeque.peekFirst()] >= num) minDeque.removeFirst();
            while(!maxDeque.isEmpty() && arr[maxDeque.peekFirst()] <= num) maxDeque.removeFirst();
            minDeque.add(i);
            maxDeque.add(i);
        }

        mins.add(arr[minDeque.peekFirst()]);
        maxs.add(arr[maxDeque.peekFirst()]);

        for(int i=k; i<n; i++){
            int num = arr[i];

            while (!minDeque.isEmpty() && minDeque.peekFirst() <= i-k) minDeque.removeFirst();
            while (!maxDeque.isEmpty() && maxDeque.peekFirst() <= i-k) maxDeque.removeFirst();

            while(!minDeque.isEmpty() && arr[minDeque.peekFirst()] >= num) minDeque.removeFirst();
            while(!maxDeque.isEmpty() && arr[maxDeque.peekFirst()] <= num) maxDeque.removeFirst();

            minDeque.add(i);
            maxDeque.add(i);

            mins.add(arr[minDeque.peekFirst()]);
            maxs.add(arr[maxDeque.peekFirst()]);
        }
        System.out.println(maxs);
        System.out.println(mins);
        List<Integer> sums = new ArrayList<>();
        for(int i=0;i<mins.size(); i++){
            sums.add(mins.get(i) + maxs.get(i));
        }
        return sums;
    }


    // min and max in given window using nextMin/nextMax
    public static List<Integer> minMaxSumInWindow(int[] arr, int w){
        List<Integer> min = minWindow(arr, w);
        List<Integer> max = maxWindow(arr, w);
        int n = min.size();
        List<Integer> sum = new ArrayList<>();
        for(int i=0; i<n; i++){
            sum.add(min.get(i) + max.get(i));
        }
        return sum;
    }
    public static List<Integer> maxWindow(int[] arr, int w){
        int n = arr.length;
        int[] nextMax = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[i] >= arr[stack.peek()]) stack.pop();
            if(stack.isEmpty()) nextMax[i] = n;
            else nextMax[i] = stack.peek();
            stack.push(i);
        }
        int i=0, k=0;
        List<Integer> maxWindow = new ArrayList<>();
        while (i+w <= n){
            if(k < i) k = i;
            while(nextMax[k] < i+w){
                k = nextMax[k];
            }
            maxWindow.add(arr[k]);
            i += 1;
        }
        System.out.println(maxWindow);
        return maxWindow;
    }
    public static List<Integer> minWindow(int[] arr, int w){
        int n = arr.length;
        int[] nextMin = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty()  && arr[i] <= arr[stack.peek()]) stack.pop();
            if(stack.isEmpty()) nextMin[i] = n;
            else nextMin[i] = stack.peek();
            stack.push(i);
        }
        List<Integer> minWindow = new ArrayList<>();
        int i=0, k=0;
        while (i+w <= n){
            if(k<i) k=i;
            while(nextMin[k] < i+w) k = nextMin[k];
            minWindow.add(arr[k]);
            i += 1;
        }
        System.out.println(minWindow);
        return minWindow;
    }



}
