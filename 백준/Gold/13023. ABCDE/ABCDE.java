import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, a, b, ans;
//    static boolean[][] matrix;
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visit;

    // A-B-C-D-E 순서로 친구인지 확인 (01234)
    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

//        matrix = new boolean[N][N];
        for (int i = 0; i < N; i++){
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

//            matrix[a][b] = matrix[b][a] = true;
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        visit = new boolean[N];
        for (int i = 0; i < N; i++){
            visit[i] = true;
            if (dfs(i, 1)) {
                ans = 1;
                break;
            }
            visit[i] = false;
        }

        System.out.println(ans);
    }

    static boolean dfs(int me, int cnt){
        if (cnt >= 5){
            return true;
        }

        List<Integer> myFriends = adjList.get(me);
        for (int i = 0; i < myFriends.size(); i++){
            int friend = myFriends.get(i);
            if (visit[friend]) continue;

            visit[friend] = true;
            if (dfs(friend, cnt+1)) return true;
            visit[friend] = false;
        }

        return false;
    }
}
