import java.util.ArrayList;
import java.util.List;

public class ArraysLeetcodeExplore {
    public static void main(String[] args) {
        System.out.println(solution("11110"));

    }



    public static int solution(String s){
        int ans = 0;
         int start = -1;
         for(int i=0; i<s.length(); i++){
             if(s.charAt(i) == '1'){
                 start = i;
                 break;
             }
         }
         if(start == -1) return 0;
         for(int i=s.length()-1; i>=start; i--){
             if(s.charAt(i) == '1'){
                 ans += 2;
             }
             else ans += 1;
         }
         ans -= 1;
        return ans;
    }

    public static boolean canScan(String n, String m){
        int i=0, j=0;
        int s1 = strLen(n), s2= strLen(m);

        return false;
    }

    public static int strLen(String s){
        int i = 0, ans = 0;
        while (i < s.length()){
            if(Character.isDigit(s.charAt(i))){
                StringBuilder num = new StringBuilder();
                while (i < s.length() && !Character.isDigit(s.charAt(i))){
                    num.append(s.charAt(i));
                    i += 1;
                }
                ans += Integer.parseInt(num.toString());
            }
            else {
                ans += 1;
                i += 1;
            }
        }
        return ans;
    }

    public static void duplicateZeros(int[] arr) {
        int zeros = 0;
        int n = arr.length - 1;
        int curr = n, lastIdx = -1;
        for(int i=0; i<=n; i++){
            if(n - zeros <= i){
                if(n-zeros < i){
                    curr = i - 1;
                    lastIdx = n;
                }
                else{
                    if(arr[i] == 0){
                        arr[n] = 0;
                        curr = i - 1;
                        lastIdx = n- 1;
                    }
                    else{
                        curr = i;
                        lastIdx = n;
                    }
                }
                break;
            }

            if(arr[i] == 0){
                zeros += 1;
            }
        }

        if(zeros == 0) return;

        while(curr >= 0){
            if(arr[curr] == 0){
                arr[lastIdx--] = 0;
                arr[lastIdx--] = 0;
            }
            else{
                arr[lastIdx--] = arr[curr];
            }
            curr -= 1;
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m + n - 1;
        m -= 1;
        n -= 1;
        while(l >= 0){
            int num1 = m >= 0 ? nums1[m] : Integer.MAX_VALUE;
            int num2 = n >= 0 ? nums2[n] : Integer.MAX_VALUE;
            if(num1 >= num2){
                nums1[l] = num1;
                m -= 1;
            }
            else{
                nums1[l] = num2;
                n -= 1;
            }
            l -= 1;
        }
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            while( nums[i] > 0 && nums[i] <= n && nums[i] != i+1){
                swap(nums, i, nums[i] - 1);
            }
        }

        for(int i=0; i<n; i++){
            if(i+1 != nums[i]){
                list.add(i+1);
            }
        }

        return list;
    }

    public static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
