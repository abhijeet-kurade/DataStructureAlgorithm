package DynamicProgramming.NeetCode.OneD;

public class MaximumProductSubstring {
    public int maxProduct(int[] nums) {
        int min = 1;
        int max = 1;
        int product = Integer.MIN_VALUE;

        for(int num : nums){
            int one = num;
            int two = min * num;
            int three = max * num;

            min = Math.min(Math.min(one, three), two);
            max = Math.max(Math.max(one, two), three);

            product = Math.max(product, max);
        }
        return product;
    }
}
