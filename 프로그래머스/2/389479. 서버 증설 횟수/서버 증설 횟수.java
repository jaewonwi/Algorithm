import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        // if (n*m <= 이용자 < (n+1)*m) => + n대 증설
        // k 시간 운영 후 반납
        int[] added = new int[24];
        int cur = 0;
        List<int[]> list = new ArrayList<>();    // <증설한 개수, 남은 시간>
        for (int i = 0; i < players.length; i++){
            int people = players[i];        // 사용자 수
            int n = people / m;             // 필요한 서버 수
            
            if (cur < n) {   // 서버 증설이 필요하다면
                int diff = n - cur;
                answer += diff;
                cur += n - cur;
                list.add(new int[]{diff, k});
            }
            
            for (int j = list.size()-1; j >= 0; j--){ // 서버 점검
                list.get(j)[1]--;
                if (list.get(j)[1] == 0){   // 서버 시간이 다됐으면
                    cur -= list.get(j)[0];
                    list.remove(j);
                }
            }
        }
        
        return answer;
    }
}