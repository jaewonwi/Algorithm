import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
    	int N = Integer.parseInt(br.readLine());
		int[] T = new int[N];
		int[] P = new int[N];
		for (int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		long[] dp = new long[N+1];
		for (int i = 0; i < N; i++){
			if (i + T[i] <= N)	// 상담 O
				dp[i + T[i]] = Math.max(dp[i+ T[i]], dp[i] + P[i]);
			dp[i+1] = Math.max(dp[i+1], dp[i]);	// 상담 X
		}
		System.out.println(dp[N]);
    }
}