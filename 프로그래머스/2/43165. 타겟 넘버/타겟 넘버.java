import java.util.*;

class Solution {
    static int answer = 0, size = 0, target;
    static int[] mult = {-1, 1}, numbers;
    public int solution(int[] ns, int t) {
        numbers = ns;
        target = t;
        size = numbers.length;
        
        dfs(0, 0);
        
        return answer;
    }
    
    static void dfs(int cnt, int sum){
        if (cnt == size && sum == target){
            // System.out.println(sum);
            answer++;
            return;
        }
        
        if (cnt == size) return;
        
        for (int d = 0; d < 2; d++){
            int num = numbers[cnt] * mult[d];
            
            dfs(cnt+1, sum+num);
        }
    }
}