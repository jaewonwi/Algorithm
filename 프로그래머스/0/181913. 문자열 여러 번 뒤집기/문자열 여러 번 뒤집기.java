import java.util.*;

class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] str = new char[my_string.length()];
        for (int i = 0; i < my_string.length(); i++){
            str[i] = my_string.charAt(i);
        }
        
        Queue<Character> queue = new ArrayDeque<>();
        for (int q = 0; q < queries.length; q++){
            int s = queries[q][0];
            int e = queries[q][1];
            
            for (int i = s; i <= e; i++){
                queue.offer(str[i]);
            }
            for (int j = e; j >= s; j--){
                str[j] = queue.poll();
            }
        }
        
        
        String answer = "";
        for (int i = 0; i < my_string.length(); i++){
            answer += str[i];
        }
        return answer;
    }
}