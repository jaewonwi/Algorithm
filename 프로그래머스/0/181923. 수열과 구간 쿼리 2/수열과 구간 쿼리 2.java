import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int idx = 0;
        for (int[] query : queries){
            int s = query[0];
            int e = query[1];
            int k = query[2];
         
            int num = find(arr, s, e, k);
            
            answer[idx++] = num;   
        }
        
        return answer;
    }
    
    private int find(int[] arr, int s, int e, int k){
        int min = Integer.MAX_VALUE;
        for (int i = s; i <= e; i++){
            if (arr[i] > k){
                min = Math.min(min, arr[i]);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}