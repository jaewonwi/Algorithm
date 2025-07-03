import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
	static int N, M, ans;
	static int[] src;
	static int[] tgt = new int[3];
    public static void main(String[] args) throws Exception{
		// 10만을 넘지 않는 양의 정수 3개의 합 < int
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		src = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++){
			src[i] = Integer.parseInt(st.nextToken());
		}

		comb(0, 0);
		System.out.println(ans);
    }

	static void comb(int idx, int cnt){
		if (cnt == 3){
			int sum = 0;
			for (int n : tgt){
				sum += src[n];
			}
			if (sum <= M){
				ans = Math.max(sum, ans);
			}
			return;
		}

		if (idx == N) return;

		tgt[cnt] = idx;
		comb(idx+1, cnt+1);
		comb(idx+1, cnt);

	}
}