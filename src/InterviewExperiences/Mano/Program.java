package InterviewExperiences.Mano;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        //System.out.println(solution(5, 6, new int[]{3,3,6,3,3}));


        //System.out.println(busyMonth(Arrays.asList("2023-01-02","2023-01-02","2023-05-02","2023-07-02","2023-07-02","2023-01-02","2023-07-02")));

    }

    static int solution(int N, int K, int[] money){
        int default_followers = 0;
        for(int m : money){
            if(m == K) default_followers += 1;
        }
        int ans = default_followers;

        for(int i=0; i<N; i++){
            Map<Integer, Integer> counts = new HashMap<>();
            int mx = 0, follow =0;
            for(int j=i; j<N; j++){
                int mny = money[j];
                if(mny == K){
                    follow += 1;
                    continue;
                }
                counts.put(mny, counts.getOrDefault(mny, 0) + 1);
                mx = Math.max(mx, counts.get(mny));
            }
            ans = Math.max(ans, mx + (default_followers - follow));
        }
        return ans;
    }

    public static int timeMachine(int[] years){
        int ans = 0;
        for(int i=1; i<years.length; i++){
            if(years[i-1] == years[i]) continue;
            else if(years[i-1] < years[i]) ans += 1;
            else ans += 2;
        }
        return ans;
    }

    public static int longestPrefix(int[] firstArray, int[] secondArray){
        int ans = 0;
        for(int num1 : firstArray){
            for(int num2 : secondArray){
                int curr = prefix(String.valueOf(num1), String.valueOf(num2));
                ans = Math.max(ans, curr);
            }
        }
        return ans;
    }

    private static int prefix(String str1, String str2){
        int ans = 0;
        while(ans < str1.length() && ans < str2.length()){
            if(str1.charAt(ans) != str2.charAt(ans)) return ans;
            ans += 1;
        }
        return ans;
    }
    public static int longestPrefix1(int[] firstArray, int[] secondArray){

        Map<Character, List<String>> firstMap = new HashMap<>();
        Map<Character, List<String>> secondMap = new HashMap<>();
        for(int num : firstArray){
            String n = String.valueOf(num);
            List<String> list = firstMap.getOrDefault(n.charAt(0), new ArrayList<>());
            list.add(n);
        }

        for(int num : secondArray){
            String n = String.valueOf(num);
            List<String> list = secondMap.getOrDefault(n.charAt(0), new ArrayList<>());
            list.add(n);
        }

        int ans = 0;
        while(true){
            if(firstMap.size() == 0 && secondMap.size() == 0) return ans;
            Map<Character, List<String>> m1 = new HashMap<>();
            Map<Character, List<String>> m2 = new HashMap<>();
            boolean isThereMatch  = false;
            for(int i=0; i<=9; i++){
                if(firstMap.get((char)i).size() != 0 && secondMap.get((char)i).size() != 0){
                    isThereMatch = true;
                    for(int num : firstArray){
                        String n = String.valueOf(num);
                        if(ans >= n.length()) continue;
                        List<String> list = m1.getOrDefault(n.charAt(ans+1), new ArrayList<>());
                        list.add(n);
                    }
                    for(int num : firstArray){
                        String n = String.valueOf(num);
                        if(ans >= n.length()) continue;
                        List<String> list = m1.getOrDefault(n.charAt(ans+1), new ArrayList<>());
                        list.add(n);
                    }
                }
            }
            if(isThereMatch) ans += 1;
            else return ans;
        }
    }
}
