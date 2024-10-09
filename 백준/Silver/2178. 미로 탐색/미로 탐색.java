import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, ans;
    static int[][] map;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++){
            String str = br.readLine();
            for (int j = 0; j < M; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        ans = Integer.MAX_VALUE;
        Queue<Pos> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][M];
        queue.offer(new Pos(0, 0, 1));
        visit[0][0] = true;

        while (!queue.isEmpty()){
            Pos cur = queue.poll();

            if (cur.y == N-1 && cur.x == M-1)
                ans = Math.min(ans, cur.cnt);

            for (int d = 0; d < 4; d++){
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];

                // 범위 밖, 이미 방문, 길이 아닌 곳
                if (ny < 0 || ny >= N || nx < 0 || nx >= M || visit[ny][nx] || map[ny][nx] == 0)
                    continue;

//                System.out.println("Add : " + ny + ", " + nx);
                queue.add(new Pos(ny, nx, cur.cnt+1));
                visit[ny][nx] = true;
            }
        }

        System.out.println(ans);
    }

    static class Pos{
        int y, x;
        int cnt;
        private Pos(int y, int x, int cnt){
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }

}