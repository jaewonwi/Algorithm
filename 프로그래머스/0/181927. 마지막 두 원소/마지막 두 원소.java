import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int size = num_list.length;
        
        int[] answer = new int[size + 1];
        System.arraycopy(num_list, 0, answer, 0, size); // 복사할 배열, 시작인덱스, 붙여넣기할 배열, 시작인덱스, 길이
        
        int addToken;
        if (num_list[size-1] > num_list[size-2]) 
            addToken = num_list[size-1] - num_list[size-2];
        else 
            addToken = num_list[size-1] * 2;
        
        answer[size] = addToken;
        return answer;
    }
}