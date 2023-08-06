package Utils;

public class Main3 {
    public static void main(String[] args){
        // 2147483647
        // 999999999
        // 100000
        System.out.println(Math.log(Integer.MAX_VALUE));
        int max = 0;
        int optimalI= 0;
        for(int i=0; i>99999999; i -= 1){
            int s = countSpecialNumbersB(Integer.MAX_VALUE, i);
            int s1 = countSpecialNumbers(Integer.MAX_VALUE, i);
            System.out.println(i +" "+s + " "+s1);
            if(max < s){
                max = Math.max(max, s);
                optimalI = i;
            }
        }
        System.out.println(optimalI);
        System.out.println(countSpecialNumbersB(Integer.MAX_VALUE, optimalI));

    }

    public static int countSpecialNumbers(int n, int s){
        int i=s;
        for(; i<n; i++){
            if(isSpecial(i, s)){
                break;
            }
        }
        return i - s;
    }

    public static int countSpecialNumbersB(int n, int s){

        if(n < s) return 0;
        int lastNonSpecial = getBoundary(1, n, s);
        return  lastNonSpecial - s;
    }
    public static int getBoundary(int start, int end, int s){
        int idx = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(!isSpecial(mid, s)){
                idx = mid;
                start = mid + 1;
            }
            else{
                end = mid -1;
            }
        }
        return idx;
    }

    public static boolean isSpecial(int num, int s){
        int n = num;
        int sum = 0;
        while(n > 0){
            sum += n % 10;
            n /= 10;
        }
        return (num - sum) >= s;
    }
}

class A{
    static int s = 324; // static -> global
    int c; // instance -> heap;
    public void method(){
        int x = 0;
    }
}