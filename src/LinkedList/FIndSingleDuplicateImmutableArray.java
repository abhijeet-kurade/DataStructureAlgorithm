package LinkedList;

public class FIndSingleDuplicateImmutableArray {
    public static void main(String[] args) {

    }

    static int findDuplicate(int[] arr){
        int n = arr.length;

        if(n==0) return 0;

        int slow = arr[0];
        int fast = arr[0];

        do{
            slow = arr[slow];
            fast = arr[arr[fast]];
        }while (slow != fast);

        fast = arr[0];

        while(slow != fast){
            slow =arr[slow];
            fast = arr[fast];
        }

        return slow;
    }
}
