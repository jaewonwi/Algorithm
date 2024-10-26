import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int l = 0; l < queries.length; l++){
            int i = queries[l][0];
            int j = queries[l][1];
            
            change(arr, i, j);
        }
        return arr;
    }
    
    private void change(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}