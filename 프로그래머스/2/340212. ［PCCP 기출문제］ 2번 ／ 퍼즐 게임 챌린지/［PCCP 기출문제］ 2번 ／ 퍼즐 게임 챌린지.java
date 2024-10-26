import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int minVal = 1;
        int maxVal = Arrays.stream(diffs).max().getAsInt();
        int level = (minVal + maxVal)/2;
        
        while (minVal <= maxVal){
            long time = cal(diffs, times, level);
            
            if (limit == time){
                return level;
            } else if (limit > time){
                long nextTime = level == 1? limit+1 : cal(diffs, times, level-1);
                if (limit < nextTime){
                    return level;
                } else {
                    maxVal = level - 1;
                }
            } else {
                minVal = level + 1;
            }
            
            level = (minVal + maxVal)/2;
        }
        
        return -1;
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