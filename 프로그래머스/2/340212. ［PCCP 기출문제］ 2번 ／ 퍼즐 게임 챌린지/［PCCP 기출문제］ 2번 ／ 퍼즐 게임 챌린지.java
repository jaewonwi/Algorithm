import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int start = 1;
        int end = Arrays.stream(diffs).max().getAsInt();
        
        while (start < end){
            int level = (start + end) / 2;
            long time = cal(diffs, times, level);
            
            if (limit >= time){
                end = level;
            } else {
                start = level + 1;
            }
        }
        
        return end;
            
    }
    
    private long cal(int[] diffs, int[] times, int level){
        long time = 0;
        for (int i = 0; i < diffs.length; i++){
            int levDiff = diffs[i] - level;
            
            if (levDiff <= 0){
                time += times[i];
            } else {
                int time_prev = i == 0 ? 0 : times[i-1];
                int time_cur = times[i];
                
                time += (time_prev + time_cur) * levDiff + time_cur;
            }
        }
        return time;
    }
}