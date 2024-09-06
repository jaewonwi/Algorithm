import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, L, ans;
	static int[] taste, kal;
	static boolean[] select;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	//재료의 수
			L = Integer.parseInt(st.nextToken());	//제한 칼로리
			
			taste = new int[N];
			kal = new int[N];
			select = new boolean[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				taste[i] = Integer.parseInt(st.nextToken());
				kal[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = Integer.MIN_VALUE;
			subset(0);
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
			
		System.out.println(sb);
	}
	
	static void subset(int srcIdx) {
		if (srcIdx == N) {	// 기저조건
			int sumkal = 0;
			int sumscore = 0;
			for (int i = 0; i < N; i++) {
				if (select[i]) {
					sumkal += kal[i];
					sumscore += taste[i];
				}
			}
			if (sumkal <= L)
				ans = Math.max(ans, sumscore);
			
			return;
		}
		
		select[srcIdx] = true;
		subset(srcIdx + 1);
		select[srcIdx] = false;
		subset(srcIdx + 1);
		
	}
}
