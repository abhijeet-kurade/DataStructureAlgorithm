package Maths;

public class GCDArray {
    // Function to find the greatest common divisor (GCD)
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to find the GCD of an array of integers
    public static int findGCD(int[] arr) {
        int result = arr[0]; // Start with the first element
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {20, 40, 60}; // Example array
        System.out.println("GCD of the array is: " + findGCD(array));
    }
}

