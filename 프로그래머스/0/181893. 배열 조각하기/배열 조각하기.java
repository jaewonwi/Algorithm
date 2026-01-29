import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int[] answer = {};
        int left = 0;
        int right = arr.length - 1;
        for (int i = 0; i < query.length; i++){
            if (i % 2 == 0){
                right = left + query[i];
            } else {
                left = left + query[i];
            }
            
            // System.out.println(Arrays.toString(Arrays.copyOfRange(arr, left, right+1)));
        }
        return answer = Arrays.copyOfRange(arr, left, right+1);
    }
}