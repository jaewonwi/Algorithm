import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

	static int N, K;
	static int[][] item, dp;
    public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		item = new int[N+1][2];
		for (int i = 1; i <= N; i++){
			st = new StringTokenizer(br.readLine());
			item[i][0] = Integer.parseInt(st.nextToken());
			item[i][1] = Integer.parseInt(st.nextToken());
		}

		// dp로 i번째를 넣었을 때 vs 넣지 않았을 때를 비교하면서 최대 가치를 찾자.
		dp = new int[N+1][K+1];
		for (int i = 1; i <= N; i++){	// 물건을 하나씩 보면서  -> 100
			for (int w = 1; w <= K; w++) {	// 무게 제한을 처음부터 고려해보자 -> 10만
				if (item[i][0] <= w){	// 이 아이템이 무게를 넘지 않을 경우
					// i번째 아이템 넣는 경우 = i-1번째에서 '지금 보고있는 무게 - 지금 아이템 무게'의 총 가치에 지금 아이템 가치 더하는 것
					int item_O = dp[i-1][w-item[i][0]] + item[i][1];
					// i번째 아이템 넣지 않는 경우 = i-1번째에서 w무게 번째의 가치 그대로 가져오는 경우
					int item_X = dp[i-1][w];
					dp[i][w] = Math.max(item_O, item_X);
				} else {
					dp[i][w] = dp[i-1][w];
				}
			}
		}
		System.out.println(dp[N][K]);
    }
}