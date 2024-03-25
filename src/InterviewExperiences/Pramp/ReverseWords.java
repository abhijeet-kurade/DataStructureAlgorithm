package InterviewExperiences.Pramp;

public class ReverseWords {

    static char[] reverseWords(char[] arr) {
        int n = arr.length;
        if(n == 0) return arr;
        reverse(arr, 0, n-1);
        int start = 0, end =0;
        while(start<n && end<n){
            while(end<n && arr[end] != ' '){
                end += 1;
            }
            end -= 1;
            reverse(arr, start, end);
            start = end + 2;
        }
        return arr;
    }

    static void reverse(char[] arr, int left, int right){
        while(left <= right){
            char c = arr[left];
            arr[left] = arr[right];
            arr[right] = c;

            left += 1;
            right -= 1;
        }

    }

    public static void main(String[] args) {
        char[] arr = {'a', 'b', ' ', 'c', 'c'};
        //reverseWords(arr);
        for(char c : reverseWords(arr)){
            System.out.println(c + " ");
        }
    }
}
