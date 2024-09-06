import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, ans, max;   // N*N
    static int[][] map;
    static int[] dy = {-1,1,0,0};   // 상하좌우
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        T = Integer.parseInt(st.nextToken());
        for (int test_case = 1; test_case <= T; test_case++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for (int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 맵 탐색 -> 정답 갱신
            ans = Integer.MAX_VALUE;
            max = 0;
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    int cnt = search(i, j);

                    if (cnt > max){
                        max = cnt;
                        ans = map[i][j];
                    } else if (cnt == max){
                        ans = Math.min(ans, map[i][j]);
                    }

                }
            }

            sb.append("#").append(test_case).append(" ").append(ans).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }

    static int search(int sy, int sx){
        int cnt = 1;
        boolean flag = true;

        while (flag) {
            int y = sy;
            int x = sx;
            for (int d = 0; d < 4; d++) {
                int ny = sy + dy[d];
                int nx = sx + dx[d];

                if (ny >= 0 && ny < N && nx >= 0 && nx < N && map[ny][nx] == map[sy][sx] + 1) {
                    sy = ny;
                    sx = nx;
                    cnt++;
                    break;
                }
            }

            if (y == sy && x == sx)
                flag = false;
        }

        return cnt;
    }
}
