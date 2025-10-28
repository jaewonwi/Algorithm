import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
	static int N, M;
	static int[][] maze;
	static int[] dr = {-1,0,-1}, dc = {0,-1,-1};
    public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[N][M];
		dp[0][0] = maze[0][0];
		for (int i = 0; i < N; i++){
			for (int j = 0; j < M; j++){
				int max = 0;
				for (int d = 0; d < 3; d++){
					int br = i + dr[d];
					int bc = j + dc[d];

					if (br < 0 || bc < 0 || br >= N || bc >= M) continue;

					dp[i][j] = Math.max(dp[i][j], dp[br][bc] + maze[i][j]);
				}
			}
		}

		System.out.println(dp[N - 1][M - 1]);
	}
}