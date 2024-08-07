// BOJ 12660. 구간합 구하기 5

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N*N인 배열. (x1, y1) ~ (x2, y2) 합 구하기
public class Main {
    static int N, M, result;
    static int[][] arr, sarr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        sarr = new int[N+1][N+1];

        for (int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2차원 배열 구간합 구하기
        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= N; j++){
                sarr[i][j] = sarr[i-1][j] + sarr[i][j-1] - sarr[i-1][j-1] + arr[i][j];
            }
        }

        for (int t = 0; t < M; t++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            result = sarr[x2][y2] - sarr[x2][y1-1] - sarr[x1-1][y2] + sarr[x1-1][y1-1];

            sb.append(result).append("\n");
        }

        System.out.print(sb.toString());

    }
}
