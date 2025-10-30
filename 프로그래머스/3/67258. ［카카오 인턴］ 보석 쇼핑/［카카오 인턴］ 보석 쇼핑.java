import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        // 진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간을 찾아서 구매
        int n = (int) Arrays.stream(gems).distinct().count();   // 보석의 종류
        Map<String, Integer> map = new HashMap<>(); 
        int left = 0, right = 0;
        int minDiff = Integer.MAX_VALUE;
        int[] answer = new int[]{1, gems.length};
        
        while (true){
            if (map.size() == n){
                // 갱신
                if (right - left < minDiff){
                    answer[0] = left+1;
                    answer[1] = right;
                    minDiff = right - left;
                }
                
                // 조건 충족했으니 왼쪽 보석 제거 => 길이 축소 시도
                String leftGem = gems[left];
                map.put(leftGem, map.get(leftGem) - 1);
                if (map.get(leftGem) == 0) map.remove(leftGem);
                left++;
            } else {    // 오른쪽 보석 추가 => 새로운 보석 넣기
                if (right == gems.length) break;
                String rightGem = gems[right];
                map.put(rightGem, map.getOrDefault(rightGem, 0) + 1);
                right++;
            }
        }
        
        return answer;
    }
}