import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] tgt;
	static boolean[] select;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tgt = new int[M];
		select = new boolean[N+1];
		perm(0);
		System.out.println(sb.toString());
	}

	public static void perm(int cnt){
		if (cnt == tgt.length){
			for (int n : tgt){
				sb.append(n).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++){
			if (select[i]) continue;

			tgt[cnt] = i;
			select[i] = true;
			perm(cnt+1);
			select[i] = false;
		}
	}
}