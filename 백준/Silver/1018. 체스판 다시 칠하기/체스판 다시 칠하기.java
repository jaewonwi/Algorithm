import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, ans;    // 8~50
    static char[][] map;

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++){
            String str = br.readLine();
            for (int j = 0; j < M; j++){
                map[i][j] = str.charAt(j);
            }
        }

        ans = Integer.MAX_VALUE;
        for (int i = 0; i <= N - 8; i++){
            for (int j = 0; j <= M - 8; j++){
                ans = Math.min(check(i, j, 'B'), ans);
                ans = Math.min(check(i, j, 'W'), ans);
            }
        }

        System.out.println(ans);
    }

    static int check(int sy, int sx, char color){
        int cnt = 0;
        for (int i = sy; i < sy+8; i++){
            for (int j = sx; j < sx+8; j++){
                if ((i+j) % 2 == 0 && map[i][j] != color)
                    cnt++;

                else if ((i+j) % 2 != 0 && map[i][j] == color)
                    cnt++;
            }
        }
        return cnt;
    }
}
