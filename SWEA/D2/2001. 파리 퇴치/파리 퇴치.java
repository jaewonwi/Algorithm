import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, M, result;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = 0;
            for (int i = 0; i < N-M+1; i++){
                for (int j = 0; j < N-M+1; j++){
                    hit(i, j, M);
                }
            }

            sb.append("#").append(t).append(" ").append(result).append("\n");
        }

        System.out.println(sb);
    }

    static void hit(int y, int x, int M){
        int sum = 0;
        for (int i = y; i < y + M; i++){
            for (int j = x; j < x + M; j++){
                sum += map[i][j];
            }
        }

        result = Math.max(sum, result);
    }
}
