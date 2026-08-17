import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        // 진도가 100퍼일때 반영.
        // 뒤에있는 기능은 먼저 개발완료되어도 앞 기능이 배포될때 같이 배포됨
        Queue<Node> q = new ArrayDeque<>();
        int n = progresses.length;
        for (int i = 0; i < n; i++){
            q.offer(new Node(progresses[i], speeds[i]));
        }
        
        if (n == 0) 
            return new int[]{};
            
        Node cur = q.poll();
        int time = (100 - cur.progress) % cur.speed == 0 ? (100 - cur.progress) / cur.speed : (100 - cur.progress) / cur.speed + 1;
        int cnt = 1;
        while (!q.isEmpty()){
            int startTime = time;
            cur = q.poll();
            int rem = 100 - cur.progress - cur.speed * time;
            while (rem > 0){
                time++;
                rem -= cur.speed;
            }
            
            if (startTime == time){
                cnt++;
            } else {
                answer.add(cnt);
                cnt = 1;
            }
        }
        answer.add(cnt);
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    class Node {
        int progress, speed;
        public Node(int p, int s){
            this.progress = p;
            this.speed = s;
        }
    }
}