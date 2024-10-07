package InterviewExperiences.Mano;

public class MakeRedContinuous {
    public static void main(String[] args) {
        System.out.println(solution("WWWRWRWWR"));
    }

    public static int solution(String S){
        int n = S.length();
        int ans = 0;
        int[] leftToRight = new int[n];
        int[] rightToLeft = new int[n];
        int reds = 0;
        for(int i=0; i<n; i++){
            char c = S.charAt(i);
            if(c == 'W') leftToRight[i] = reds;
            else reds += 1;
        }
        reds = 0;
        for(int i=n-1; i>=0; i--){
            char c = S.charAt(i);
            if(c == 'W') rightToLeft[i] = reds;
            else reds += 1;
        }

        for(int i=0; i<n; i++){
            char c = S.charAt(i);
            if(c == 'W') ans += Math.min(leftToRight[i], rightToLeft[i]);
        }
        return ans;
    }

}
