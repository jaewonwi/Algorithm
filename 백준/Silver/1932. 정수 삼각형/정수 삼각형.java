import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
    	int n = Integer.parseInt(br.readLine());
		int[][] triangle = new int[n][n];
		for (int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++){
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[n][n];
		dp[0][0] = triangle[0][0];
		for (int i = 0; i < n-1; i++){
			for (int j = 0; j <= i; j++){
				dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + triangle[i+1][j]);
				dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + triangle[i+1][j+1]);
			}
		}
		System.out.println(Arrays.stream(dp[n-1]).max().getAsInt());
    }
}