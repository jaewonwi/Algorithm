import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> answer = new ArrayList<>();
        
        for (int i = l; i <= r; i++){
            String number = String.valueOf(i);
            
            boolean flag = true;
            int idx = 0;
            for (int j = 0; j < number.length(); j++){
                char c = number.charAt(j);
                if (!(c == '0' || c == '5')){
                    flag = false;  
                    continue;
                }
            }
            
            if (flag) answer.add(i);
        }
        
        return answer.isEmpty() ? new int[]{-1} : answer.stream().mapToInt(Integer::intValue).toArray();
    }
}