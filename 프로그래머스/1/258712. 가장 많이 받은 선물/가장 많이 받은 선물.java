import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int[][] adjMatrix = new int[friends.length][friends.length];
        int[][] giftIdx = new int[friends.length][2];
        int[] answer = new int[friends.length];
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < friends.length; i++){
            map.put(friends[i],i);
        }
        
        for (int i = 0; i < gifts.length; i++){    
            String[] names = gifts[i].split(" ");
            int from = map.get(names[0]);
            int to = map.get(names[1]);
            adjMatrix[from][to]++;
            giftIdx[from][0]++;
            giftIdx[to][1]++;
        }
        
        for (int i = 0; i < friends.length; i++){
            for (int j = i+1; j < friends.length; j++){
                if (i == j) continue;
                
                int a = adjMatrix[i][j];
                int b = adjMatrix[j][i];
                
                if ((a == 0 && b == 0) || a == b){  // 2. 기록 X, = -> 선물지수
                    // 선물 지수: 이번달까지 내가 준 선물 수 - 받은 선물 수
                    int giftA = giftIdx[i][0] - giftIdx[i][1];
                    int giftB = giftIdx[j][0] - giftIdx[j][1];
                    
                    if (giftA == giftB) continue;   // 3. 선물 지수도 같으면 선물 주고받기 X
                    
                    answer[giftA > giftB ? i : j]++;    // 큰 사람 <- 작은사람
                } else {    // 1. 둘 중 선물을 더 많이 준 사람이 다음달에 받음
                    answer[a > b ? i : j]++;   
                }
            }    
        }
        
        int max = 0;
        for (int i = 0; i < friends.length; i++){
            max = Math.max(answer[i], max);
        }
        
        return max;  // 다음달에 가장 선물을 많이 받는 친구가 받을 선물의 수
        
    }
}