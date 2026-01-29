import java.util.*;
class Solution {
    public String solution(String my_string, int[] indices) {
        String answer = "";
        char[] chArr = my_string.toCharArray();
        int idx = 1;
        for (int remove : indices){
            chArr[remove] = Character.MIN_VALUE;
        }
        for (char c : chArr){
            if (c == '\u0000') continue;
            answer+= c;
        }
        return answer;
    }
}