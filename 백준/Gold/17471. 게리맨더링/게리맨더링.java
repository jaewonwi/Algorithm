import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, ans;   // 1~N번 구역 -> 2개의 선거구로 나누어야 하며, 한 선거구는 모두 연결되어있어야 함
    static int[] people;
    static boolean[] select, visit;
    static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());    // 구역의 수

        // 인구 수 입력
        people = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }

        // 인접 구역 정보
        for (int i = 0; i < N; i++){
            list.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int n = 0; n < num; n++){
                int next = Integer.parseInt(st.nextToken()) - 1;
                list.get(i).add(next);
            }
        }

        ans = Integer.MAX_VALUE;
        select = new boolean[N];
        visit = new boolean[N];

        subset(0);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static int calDiff(){
        int sumA = 0;
        int sumB = 0;

        for (int i = 0; i < N; i++){
            if (select[i]) sumA += people[i];
            else sumB += people[i];
        }

        return Math.abs(sumA-sumB);
    }

    static int bfs(int start, boolean flag){  // 연결 체크
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visit[start] = true;

        int cnt = 0;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            cnt++;

            for (int i = 0; i < list.get(cur).size(); i++){
                int next = list.get(cur).get(i);
                if (select[next] == flag && !visit[next]){
                    visit[next] = true;
                    queue.add(next);
                }
            }
        }

        return cnt;
    }

    static void subset(int srcIdx){
        if (srcIdx == N){
            Arrays.fill(visit, false);

            int connA = 0, connB = 0;
            for (int i = 0; i < N; i++){
                if (select[i]){
                    connA = bfs(i, true);
                    break;
                }
            }
            for (int i = 0; i < N; i++){
                if (!select[i]){
                    connB = bfs(i, false);
                    break;
                }
            }

            if (connA + connB == N){    // 다 연결되어있다면
                ans = Math.min(ans, calDiff());     // 차이가 최소가 되도록 갱신
            }

            return;
        }

        select[srcIdx] = true;
        subset(srcIdx+1);
        select[srcIdx] = false;
        subset(srcIdx+1);
    }
}
