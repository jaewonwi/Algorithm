import java.util.*;

class Solution {
    public String solution(String rsp) {
        String answer = "";
        
        for (int i = 0; i < rsp.length(); i++){
            char input = rsp.charAt(i);
            
            if (input == '0'){
                answer += "5";
            } else if (input == '2'){
                answer += "0";
                System.out.println(answer);
            } else if (input == '5'){
                answer += "2";
            }
        }
        
        return answer;
    }
}