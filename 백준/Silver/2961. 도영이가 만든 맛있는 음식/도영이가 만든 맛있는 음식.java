import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, S, B;
	static long ans;
	static int[][] ingredients;
	static boolean[] select;
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		ingredients = new int[N][2];
		select = new boolean[N];
		// S 신맛, B 쓴맛
		// 신맛 *, 쓴맛 +

		for (int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			ingredients[i][0] = Integer.parseInt(st.nextToken());
			ingredients[i][1] = Integer.parseInt(st.nextToken());
		}

		ans = Long.MAX_VALUE;
		comb(0, 0);

		System.out.println(ans);
	}

	static void comb(int idx, int cnt){
		if (idx == N){
			if (cnt == 0) return;

			S = 1;
			B = 0;
			for (int i = 0; i < N; i++){
				if (select[i]){
					S *= ingredients[i][0];
					B += ingredients[i][1];
				}
			}
			ans = Math.min(ans, Math.abs(S-B));
			return;
		}

		select[idx] = true;
		comb(idx+1, cnt+1);
		select[idx] = false;
		comb(idx+1, cnt);
	}
}