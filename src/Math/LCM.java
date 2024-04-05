package Math;

public class LCM {
    public static void main(String[] args) {
        System.out.println(lcm(10,12));
    }

    public static int lcm(int a, int b){
        return (a / GCD.gcd(a,b)) * b;
    }
}
