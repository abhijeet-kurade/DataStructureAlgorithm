package Recursion;

public class SimpleRecursiveProgram {
    public static void main(String[] args) {
        // 3 * 4
        // 3 + 3 + 3 + 3

        System.out.println(recursionMultiplication(4, 3));

    }

    public static int recursionMultiplication(int num1, int num2){
        if(num2 == 0 ) return 0;
        int multiplication = num1 + recursionMultiplication(num1, num2-1);
        return multiplication;

    }
}
