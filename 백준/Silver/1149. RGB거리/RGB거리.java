import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
    	// 1~N번 집 -> Red, Green, Blue

		// 1. 1번 집 != 2번 집
		// 2. N번 집 != N-1번 집
		// 3. i(2~N-1)번 집 != i-1, i+1번 집

		int N = Integer.parseInt(br.readLine());
		int[][] RGB = new int[N][3];
		for (int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++){
				RGB[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[N][3];
		for (int i = 0; i < 3; i++){
			dp[0][i] = RGB[0][i];
		}

		for (int i = 1; i < N; i++){
			for (int j = 0; j < 3; j++){
				dp[i][j] = Math.min(RGB[i][j] + dp[i-1][(j+1)%3], RGB[i][j] + dp[i-1][(j+2)%3]);
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++){
			min = Math.min(min, dp[N-1][i]);
		}
		System.out.println(min);
	}
}