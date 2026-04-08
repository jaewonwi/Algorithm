import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++){
            String name = clothes[i][0];
            String kind = clothes[i][1];
            map.put(kind, map.getOrDefault(kind, 0) + 1);
        }
        
        for (String key : map.keySet()){    // map.keySet()으로 키 전부 가져오기
            answer *= map.get(key) + 1;
        }
        return answer - 1;  // 아무것도 안입는 경우 제외
    }
}