import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
	static int N;
	static int[][] input;
	static int[] dp;
    public static void main(String[] args) throws Exception{
    	N = Integer.parseInt(br.readLine());
		input = new int[N][2];
		for (int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(input, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2){
				return o1[0] - o2[0];
			}
		});

		dp = new int[N];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++){
			dp[i] = 1;
			for (int j = 0; j < i; j++){
				if (input[i][1] > input[j][1])
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
			max = Math.max(max, dp[i]);
		}

		System.out.println(N - max);
    }
}