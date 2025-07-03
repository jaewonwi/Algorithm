import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static boolean[] selected;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		selected = new boolean[N+1];

		comb(1, 0);
		System.out.println(sb);
	}

	static void comb(int idx, int cnt){
		if (cnt == M){
			for (int i = 1; i <= N; i++){
				if (selected[i])
					sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		if (idx > N) return;

		selected[idx] = true;
		comb(idx+1, cnt+1);
		selected[idx] = false;
		comb(idx+1, cnt);
	}
}