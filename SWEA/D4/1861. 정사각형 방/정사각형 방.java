import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T, N, ans, an;
    static int[][] map;
    public static void main(String[] args) throws Exception{
    	// 상하좌우 이동가능, 현재방보다 정확히 1 클때!
        // 어떻게 가장 많은 개수의 방을 이동할 수 있을까?
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++){
            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ans = 1;
            an = N*N;
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    int result = find(i,j);
                    if (result == ans) {
                        an = Math.min(an, map[i][j]);
                    } else if (result > ans){
                        ans = result;
                        an = map[i][j];
                    }
                }
            }

            sb.append(an).append(" ").append(ans).append(" ").append("\n");
        }
        System.out.println(sb);
    }

    static int[] dy = {-1,1,0,0}, dx = {0,0,-1,1};
    static int find(int y, int x){
        Queue<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(y,x,1,N*N));
        int result = 1;

        while (!q.isEmpty()){
            Pos cur = q.poll();
            if (result <= cur.cnt) result = cur.cnt;

            for (int d = 0; d < 4; d++){
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];

                if (!isIn(ny,nx)) continue;
                if ((cur.num + 1) != map[ny][nx]) continue;
                // if (cur.cnt + cur.rem < ans) continue;

                q.offer(new Pos(ny,nx,cur.cnt+1, cur.rem-1));
            }
        }

        return result;
    }

    static boolean isIn(int y, int x){
        if (y < 0 || y >= N || x < 0 || x >= N) return false;
        return true;
    }

    static class Pos{
        int y, x, num, cnt, rem;
        public Pos(int y, int x, int cnt, int rem){
            this.y = y;
            this.x = x;
            this.num = map[y][x];
            this.cnt = cnt;
            this.rem = rem;
        }
    }
}