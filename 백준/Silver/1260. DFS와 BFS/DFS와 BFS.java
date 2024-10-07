import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, V;
    static int[][] matrix;
    static boolean[] visit;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        matrix = new int[N+1][N+1];
        visit = new boolean[N+1];
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            matrix[from][to] = matrix[to][from] = 1;
        }

        dfs(V);
        sb.append("\n");
        Arrays.fill(visit, false);
        bfs(V);

        System.out.println(sb);
    }

    static void dfs(int start){
        visit[start] = true;
        sb.append(start).append(" ");

        for (int i = 1; i <= N; i++){
            if (!visit[i] && matrix[start][i] == 1){
                dfs(i);
            }
        }

    }

    static void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visit[start] = true;
        sb.append(start).append(" ");

        while (!q.isEmpty()) {
            int num = q.poll();

            for (int i = 1; i <= N; i++){
                if (!visit[i] && matrix[num][i] == 1){
                    q.add(i);
                    visit[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }
    }
}
