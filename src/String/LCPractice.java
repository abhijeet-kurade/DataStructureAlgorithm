package String;

public class LCPractice {
    public static void main(String[] args) {
        System.out.println(maximumOddBinaryNumber("010"));
    }

    public static String maximumOddBinaryNumber(String s) {
        int n = s.length()-1;
        StringBuilder str = new StringBuilder();
        int ones = 0, zeros = 0;
        for(char c : s.toCharArray()){
            if(c == '0'){
                zeros += 1;
            }
            else{
                ones += 1;
            }
        }

        for(int i=0; i<s.length()-1; i++){
            if(ones > 1){
                str.append("1");
                ones -= 1;
            }else{
                str.append("0");
            }
        }
        str.append("1");

        return str.toString();
    }
}
