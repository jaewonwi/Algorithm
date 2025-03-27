import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> stk = new ArrayDeque<>();
        
        int i = 0;
        while (i < arr.length){
            if (stk.isEmpty()){
                stk.push(arr[i]);
                i++;
            } else if (stk.peek() < arr[i]) {
                stk.push(arr[i]);
                i++;
            } else if (stk.peek() >= arr[i]){
                stk.pop();
            }
        }
        
        int size = stk.size();
        int[] ans = new int[size];
        for (i = 0; i < size; i++){
            ans[size-i-1] = stk.pop();
        }
        return ans;
    }
}