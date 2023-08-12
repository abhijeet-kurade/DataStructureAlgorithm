package ArrayHashMaps.Arrays.AlgoExpert;

public class ArrayOfProducts {
    public int[] arrayOfProducts(int[] array) {
        int len = array.length;

        int[] post = new int[len];
        post[len-1] = 1;
        for(int i=len-2; i>=0; i--) post[i] = post[i+1] * array[i+1];

        int pre = 1;
        for(int i=0; i<len; i++) {
            post[i] = pre * post[i];
            pre *= array[i];
        }
        return post;
    }

}
