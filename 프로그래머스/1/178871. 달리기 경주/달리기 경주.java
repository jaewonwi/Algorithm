import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++){
            map.put(players[i], i);
            answer[i] = players[i];
        }
        
        for (int i = 0; i < callings.length; i++){
            int grade = map.get(callings[i]);   // 이름 불린 선수의 현재 등수
            
            // 추월 (a <-> a-1)
            String temp = answer[grade];
            answer[grade] = answer[grade-1];
            answer[grade-1] = temp;
            
            String b = answer[grade]; // 추월당한 선수 이름
            map.put(callings[i], grade-1);
            map.put(b, grade);
        }
        
        return answer;
    }
}