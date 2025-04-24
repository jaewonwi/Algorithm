import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        
        // 참가자 카운트 (**동명이인) -> key 이름 : value 수 
        for (int i = 0; i < participant.length; i++){
            String name = participant[i];
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        // 완주자 카운트
        for (int i = 0; i < completion.length; i++){
            String name = completion[i];
            map.put(name, map.get(name) - 1);
        }

        // map에 수가 0이 아니라면 완주하지 못한 것
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            if (entry.getValue() != 0){
                answer = entry.getKey();
            }
        }
        return answer;
    }
}