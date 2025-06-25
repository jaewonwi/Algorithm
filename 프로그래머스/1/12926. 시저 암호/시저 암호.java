import java.util.*;

class Solution {
    public String solution(String s, int n) {
        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray()){
            sb.append(push(c, n));
        }
        return sb.toString();
    }
    
    public char push(char c, int n){
        if (c == ' ') return c;
        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        return (char)((c - offset + n) % 26 + offset);
    }
}