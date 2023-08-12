package String;

import java.util.ArrayList;

public class RunLengthCoding {
    public String runLengthCoding(String input){
        ArrayList<Character> code = new ArrayList<>();
        char prev ='0';
        int len = input.length();
        for(int i=0; i<len; i++){
            if(i%2 == 0){
                prev = input.charAt(i);
            }
            else {
                int repeat = Integer.parseInt(String.valueOf(input.charAt(i)));
                for(int j=0; j<=repeat;j++){
                    code.add(prev);
                }
            }
        }

        char[] chars = new char[code.size()];
        for(int i=0; i<code.size(); i++){
            chars[i] = code.get(i);
        }

        return String.valueOf(chars);
    }

}
