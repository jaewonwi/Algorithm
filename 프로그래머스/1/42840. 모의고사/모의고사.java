import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] st1 = new int[]{1,2,3,4,5};   // 5개 (0~4)
        int[] st2 = new int[]{2,1,2,3,2,4,2,5}; // 8개 (0~7)
        int[] st3 = new int[]{3,3,1,1,2,2,4,4,5,5}; // 10개 (0~9)
        
        int[] score = new int[3];
        for (int i = 0; i < answers.length; i++){
            int ans = answers[i];
            if (st1[i % 5] == ans) score[0]++;
            if (st2[i % 8] == ans) score[1]++;
            if (st3[i % 10] == ans) score[2]++;
            
        }
        int maxScore = Math.max(Math.max(score[0],score[1]),score[2]);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            if (score[i] == maxScore) list.add(i+1);
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}