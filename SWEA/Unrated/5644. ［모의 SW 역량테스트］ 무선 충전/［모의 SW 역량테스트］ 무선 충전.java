import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

	static int T, M, A, ans;
    static int ax, ay, bx, by;
    static int[] moveA, moveB;
    static Battery[] batteries;
    static int[] dy = {0,-1,0,1,0}, dx = {0,0,1,0,-1};  // 제자리,상,우,하,좌
    public static void main(String[] args) throws Exception{
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++){
            ans = 0;
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());   // 총 이동시간
            A = Integer.parseInt(st.nextToken());   // BC의 개수

            ax = 0; ay = 0;
            bx = 9; by = 9;
            moveA = new int[M];
            moveB = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++){
                moveA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++){
                moveB[i] = Integer.parseInt(st.nextToken());
            }

            batteries = new Battery[A];
            for (int a = 0; a < A; a++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;   // 좌표
                int y = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken());   // 충전 범위
                int p = Integer.parseInt(st.nextToken());   // 처리량
                batteries[a] = new Battery(x,y,c,p);
            }

            charge();
            for (int i = 0; i < M; i++){
                ax += dx[moveA[i]];
                ay += dy[moveA[i]];
                bx += dx[moveB[i]];
                by += dy[moveB[i]];
                charge();
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static void charge(){
        int max = 0;
        // 현재 위치에서 충전할 수 있는 최대 충전치 구하기
        for (int i = 0; i < A; i++){
            for (int j = 0; j < A ; j++){
                int sum = 0;
                int aP = getP(batteries[i], ax, ay);
                int bP = getP(batteries[j], bx, by);

                if (aP == 0 && bP == 0) continue;

                if (i != j){
                    sum = aP + bP;
                } else {
                    sum = Math.max(aP, bP);
                }

                max = Math.max(max, sum);
            }
        }

        ans += max;
    }

    static int getP(Battery battery, int x, int y){
        if (Math.abs(battery.x - x) + Math.abs(battery.y - y) <= battery.c) return battery.p;
        return 0;
    }

    public static class Battery{
        int x, y, c, p;

        public Battery(int x, int y, int c, int p){
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }
    }
}
