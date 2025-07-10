import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T, N, M, ans;
	static int[][] arr;
	static int[] dy = {-1,-1,0,1,1,1,0,-1}, dx = {0,1,1,1,0,-1,-1,-1};	// 상 -> 시계방향
	public static void main(String[] args) throws Exception{
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++){
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			arr = new int[N][N];
			for (int i = 0; i < N; i++){
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = 0;
			for (int i = 0; i < N; i++){
				for (int j = 0; j < N; j++){
					ans = Math.max(calculate(i, j), ans);
				}
			}

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}

	static int calculate(int y, int x){
		int plus = arr[y][x];
		int cross = arr[y][x];
		for (int m = 1; m < M; m++){
			for (int d = 0; d < 8; d++){
				if (d % 2 == 0){	// plus
					plus += cal(y, x, d, m);
				} else {	// cross
					cross += cal(y, x, d, m);
				}
			}
		}
		return Math.max(plus, cross);
	}

	static int cal(int y, int x, int d, int m){
		int ny = y + dy[d] * m;
		int nx = x + dx[d] * m;

		if (ny >= 0 && ny < N && nx >= 0 && nx < N)
			return arr[ny][nx];
		return 0;
	}
}