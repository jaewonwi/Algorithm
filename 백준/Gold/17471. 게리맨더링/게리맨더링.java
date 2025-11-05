import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, ans = Integer.MAX_VALUE;
    static int[] people;
    static boolean[] select, visit;     // select: 구역 선택 여부, visit: 방문 체크용
    static List<List<Integer>> adjList = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        people = new int[N];
        select = new boolean[N];
        visit = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            people[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++){
            adjList.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++){
                adjList.get(i).add(Integer.parseInt(st.nextToken()) - 1);
            }
        }

        // 조합 - 두 선거구 나누기
        subset(0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void subset(int idx){
        if (idx == N){;
            calculate();
            return;
        }

        select[idx] = true;
        subset(idx+1);
        select[idx] = false;
        subset(idx+1);
    }

    static void calculate(){
        // A, B 구역이 각각 연결되어있는지 체크
        Arrays.fill(visit, false);
        int cntA = 0, cntB = 0;                    // a,b 구역 탐색 시작점
        for (int i = 0; i < N; i++){
            if (select[i]) {
                cntA = connect(i, true);
                break;
            }
        }

        for (int i = 0; i < N; i++){
            if (!select[i]) {
                cntB = connect(i, false);
                break;
            }
        }

        if (cntA+cntB != N) return;

        // 각 구역의 인구수 차이 체크 후 갱신
        int sumA = 0, sumB = 0;
        for (int i = 0; i < N; i++){
            if (select[i]) sumA += people[i];
            else sumB += people[i];
        }

        ans = Math.min(ans, Math.abs(sumA - sumB));
    }

    static int connect(int start, boolean flag){
        int cnt = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visit[start] = true;
        while (!q.isEmpty()){
            int cur = q.poll();
            cnt++;
            for (int next : adjList.get(cur)){
                if (!select[next] == flag || visit[next]) continue;

                visit[next] = true;
                q.offer(next);
            }
        }
        return cnt;
    }
}