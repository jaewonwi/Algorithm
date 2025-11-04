import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int TC, N;
    static double E;

    static long min;
    static long[][] L;
    public static void main(String[] args) throws Exception{
        // E(세율) * L(길이)^2 -> 최소 & N 개의 섬 연결하기
        TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++){
            N = Integer.parseInt(br.readLine());
            int[][] islands = new int[N][2];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N ; i++){
                islands[i][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N ; i++){
                islands[i][1] = Integer.parseInt(st.nextToken());
            }
            E = Double.parseDouble(br.readLine());

            L = new long[N][N];
            for (int i = 0; i < N; i++){
                for (int j = i+1; j < N; j++){
                    if (i == j) continue;

                    int ax = islands[i][0];
                    int ay = islands[i][1];
                    int bx = islands[j][0];
                    int by = islands[j][1];

                    long dx = ax - bx;
                    long dy = ay - by;
                    L[i][j] = L[j][i] = dx*dx + dy*dy;
                }
            }

            sb.append("#").append(tc).append(" ").append(Math.round(prim(0)*E)).append("\n");
        }
        System.out.println(sb);
    }

    static class Island {
        int v;
        long l;
        public Island(int v, long l){
            this.v = v;
            this.l = l;
        }
    }

    static long prim(int start) {
        PriorityQueue<Island> pq = new PriorityQueue<>(Comparator.comparingLong(i -> i.l));
        boolean[] visit = new boolean[N];
        pq.add(new Island(start, 0));

        long sum = 0;
        while (!pq.isEmpty()) {
            Island cur = pq.poll();
            if (visit[cur.v]) continue; // 이미 방문한 정점 처리
            visit[cur.v] = true;
            sum += cur.l;

            for (int i = 0; i < N; i++) {
                if (!visit[i])
                    pq.add(new Island(i, L[cur.v][i]));
            }
        }

        return sum;
    }
}