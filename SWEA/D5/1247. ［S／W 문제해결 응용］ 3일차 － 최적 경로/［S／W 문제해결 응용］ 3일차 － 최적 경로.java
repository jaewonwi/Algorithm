import java.io.*;
import java.util.*;

// swea_1247
public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
	static int T, N, ans;
	static Pos home, company;
	static List<Pos> customer = new ArrayList<>();
	static int[] target;
	static boolean[] select;

    public static void main(String[] args) throws Exception{
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++){
			N = Integer.parseInt(br.readLine().trim());
			st = new StringTokenizer(br.readLine().trim());
			company = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			home = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			customer.clear();
			ans = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++){
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				customer.add(new Pos(x,y));
			}

			// 풀이
			target = new int[N];
			select = new boolean[N];
			perm(0);

			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
    }

	static void cal(){
		int sum = 0;
		Pos cur = company;
		for (int i = 0; i < N; i++){
			Pos next = customer.get(target[i]);
			sum += getDistance(cur, next);
			cur = next;
		}
		sum += getDistance(cur, home);

		ans = Math.min(sum, ans);
	}

	static void perm(int cnt){
		if (cnt == N){
			cal();
			return;
		}

		for (int i = 0; i < N; i++){
			if (select[i]) continue;

			target[cnt] = i;
			select[i] = true;
			perm(cnt+1);
			select[i] = false;
		}
	}

	static int getDistance(Pos a, Pos b){
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}

	static class Pos{
		int x, y;
		public Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}