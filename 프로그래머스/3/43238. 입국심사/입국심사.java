import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        int max = Arrays.stream(times).max().getAsInt();
        long left = 0;
        long right = (long) max * n;
        while (left <= right){
            long mid = (left+right)/2;
            
            if (cal(mid, times) < n){
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
            
        return left;
    }
    
    public long cal(long mid, int[] times){
        long sum = 0;
        for (int i = 0; i < times.length; i++){
            sum += mid / times[i];
        }
        return sum;
    }
}