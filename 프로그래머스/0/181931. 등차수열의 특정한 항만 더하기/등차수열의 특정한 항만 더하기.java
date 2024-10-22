import java.util.*;

class Solution {
    public int solution(int a, int d, boolean[] included) {
        // 등차수열: ai+D;
        int n = included.length;
        int answer = 0;
        int base = a;
        for (int i = 0; i < n; i++){
            if (included[i]){
                int num = base + d * i;
                answer += num;
            }   
        }
        
        return answer;
    }
}