import java.util.HashMap;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Ctrl+D to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Cmd+F8.
            System.out.println("i = " + i);
        }

        int[] array = {1,2,4,1,2,1,3,2};
        countFruit(array);
    }


    public static int countFruit(int[] fruit){
        int length=0;
        HashMap<Integer,Integer> countFrt = new HashMap<Integer,Integer>(2); //
        int prev=0;
        int next =0;

        for(int i=0;i<fruit.length;i++){
            if(countFrt.size()>2){ // true , false , true
                countFrt.put(fruit[prev], countFrt.get(fruit[prev]) - 1); //0
                if(countFrt.get(fruit[prev])==0){ //true
                    countFrt.remove(fruit[prev]);
                }
                prev++;    //1  ,2
                i--;
            }else{
                countFrt.put(fruit[next], countFrt.getOrDefault(fruit[next], 0) + 1); //map  key=0,value=0 : key=4,value=1 : , key=1,value=1 :
                next++; // 1 ,2 ,3

                if(countFrt.size()<=2){
                    length++; //2
                }
            }

        }

        return length;
    }

    public int totalFruit(int[] fruits) {
        int len =0;
        Map<Integer, Integer> map = new HashMap<>();

        int next =0, prev =0;

        for(;next < fruits.length;next += 1){
            map.put(fruits[next], map.getOrDefault(fruits[next], 0)+1);
            while(map.size() > 2){
                map.put(fruits[prev], map.getOrDefault(fruits[prev], 0)-1);
                if(map.get(fruits[prev]) == 0) map.remove(fruits[prev]);
                prev += 1;
            }
            len = Math.max(len, next - prev + 1);
        }
        return len;
    }

    public int longestSubarray(int[] nums) {
        int len =0;
        int zeros = 0;

        int next =0, prev =0;

        for(;next < nums.length;next += 1){
            if(nums[next] == 0) zeros += 1;
            while(zeros > 1){
                if(nums[prev] == 0) zeros -= 1;
                prev += 1;
            }
            len = Math.max(len, next - prev + 1);
        }
        return len-1;
    }
}

// https://github.com/abhikurade/AlgoExpert-Coding-Problems need to modify in classes
//