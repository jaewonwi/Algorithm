import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int cnt = 0;
        int[] answer = new int[commands.length];
        for (int tc = 0; tc < commands.length; tc++){
            int i = commands[tc][0]-1;
            int j = commands[tc][1]-1;
            int k = commands[tc][2]-1;
            
            int len = j - i + 1;
            int[] temp = new int[len];
            // System.out.println(len);
            for (int idx = i; idx <= j; idx++){
                temp[idx-i] = array[idx];
            }
            
            Arrays.sort(temp);
            answer[cnt++] = temp[k];
        }
        
        return answer;
    }
}