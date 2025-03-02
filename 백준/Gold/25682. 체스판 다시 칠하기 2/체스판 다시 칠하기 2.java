import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, K;
	static char[][] input;
	static int[][] white, black;
    public static void main(String[] args) throws Exception{
    	st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		input = new char[N+1][M+1];
		white = new int[N+1][M+1];
		black = new int[N+1][M+1];

		for (int i = 1; i <= N; i++){
			String str = br.readLine();
			for (int j = 0; j < M; j++){
				input[i][j+1] = str.charAt(j);
			}
		}

		setPsum(white, 'W', 'B');
		setPsum(black, 'B', 'W');

		int ans = Integer.MAX_VALUE;
		for (int i = K; i <= N; i++){
			for (int j = K; j <= M; j++){
				int w = white[i][j] - white[i-K][j] - white[i][j-K] + white[i-K][j-K];
				int b = black[i][j] - black[i-K][j] - black[i][j-K] + black[i-K][j-K];
				int min = Math.min(w, b);
				ans = Math.min(ans, min);
			}
		}
		System.out.println(ans);
	}

	static void setPsum(int[][] psum, char even, char odd){
		for (int i = 1; i <= N; i++){
			for (int j = 1; j <= M; j++){
				if ((i+j) % 2 == 0){
					if (input[i][j] != even) {    // 합이 짝수라면 white여야 함
						psum[i][j] = psum[i - 1][j] + psum[i][j - 1] - psum[i - 1][j - 1] + 1;
					} else {
						psum[i][j] = psum[i - 1][j] + psum[i][j - 1] - psum[i - 1][j - 1];
					}
				} else if ((i+j) % 2 == 1){
					if (input[i][j] != odd) {	// 합이 홀수라면 black이어야 함
						psum[i][j] = psum[i - 1][j] + psum[i][j - 1] - psum[i - 1][j - 1] + 1;
					} else {
						psum[i][j] = psum[i - 1][j] + psum[i][j - 1] - psum[i - 1][j - 1];
					}
				}
			}
		}
	}
}