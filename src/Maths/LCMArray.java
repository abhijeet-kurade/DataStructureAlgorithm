package Maths;

public class LCMArray {
    // Function to find the greatest common divisor (GCD)
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Function to find the least common multiple (LCM)
    public static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    // Function to find the LCM of an array of integers
    public static int findLCM(int[] arr) {
        int result = arr[0]; // Start with the first element
        for (int i = 1; i < arr.length; i++) {
            result = lcm(result, arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {9, 12, 54}; // Example array
        System.out.println("LCM of the array is: " + findLCM(array));
    }
}

