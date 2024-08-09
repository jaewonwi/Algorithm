import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, M;
	static int[][] map, smap;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		 
		T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N+1][N+1];
			smap = new int[N+1][N+1];
			for (int i = 1; i <= N; i ++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			sb.append("#").append(test_case).append(" ").append(cal()).append("\n");		
			
		}
		System.out.println(sb);
	}
	
	private static int cal() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				smap[i][j] = smap[i-1][j] + smap[i][j-1] - smap[i-1][j-1] + map[i][j];
			}
		}
		
		int[][] temp = new int[N+1][N+1];
		int max = Integer.MIN_VALUE;
		for (int x = M; x <= N; x++) {
			for (int y = M; y <= N; y++) {
				temp[x][y] = smap[x][y] - smap[x-M][y] - smap[x][y-M] + smap[x-M][y-M];
				
				max = Math.max(temp[x][y], max);
			}
		} 
		return max;
	}
}