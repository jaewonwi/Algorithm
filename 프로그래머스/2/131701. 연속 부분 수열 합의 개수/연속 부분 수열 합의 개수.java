import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int N = elements.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++){
            int sum = 0;
            for (int j = 0; j < N-1; j++){
                sum += elements[(i+j)%N]; 
                set.add(sum);  
            }
        }
        
        set.add(Arrays.stream(elements).sum());
        
        return set.size();
    }
}