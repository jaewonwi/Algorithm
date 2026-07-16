import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        // 모든 음식 스코빌 지수 >= K 
        // 가장 낮은 두개 mix => 가장 낮은 것 + 두번째로 낮은 것*2
        int answer = 0;
        int n = scoville.length;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        
        int cnt = 0;
        for (int s : scoville){
            if (s >= K) cnt++;
            pq.offer(s);
        }
        
        while (cnt <= n){
            if (n < 2){
                if (pq.poll() < K)
                    answer = -1;
                break;
            } 
            
            int first = pq.poll();
            int second = pq.poll();
            if (first >= K && second >= K){
                break;
            }

            int mixed = first + 2 * second;
            
            if (mixed >= K){
                cnt++;
            }
            
            pq.offer(mixed);
            
            n--; 
            answer++;
        }
        
        return answer;
    }
}