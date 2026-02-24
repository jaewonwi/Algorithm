import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, answer = 0;    // 사무실 세로, 가로
	static int[][] map;

	static List<Position> cctvList = new ArrayList<>();
	static int[] dy = {-1,0,1,0}, dx = {0,1,0,-1};	// 상 우 하 좌
	static int[][][] direction = {
		{},
		{{0},{1},{2},{3}},	// 1방향
		{{0,2}, {1,3}},		// 2방향 (반대)
		{{0,1}, {1,2}, {2,3}, {3,0}},	// 2방향 (수직)
		{{0,1,2}, {1,2,3}, {2,3,0}, {3,0,1}},	// 3방향
		{{0,1,2,3}}			// 4방향
	};

	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++){
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;

				if (n != 0 && n != 6){  // cctv인 경우
					cctvList.add(new Position(i, j, n));
				}

				if (n == 0) answer++;
			}
		}

		backtrack(0);

		System.out.println(answer);
		return;
	}

	public static void backtrack(int idx){
		if (idx == cctvList.size()) {	// 마지막 씨씨티비까지 다 확인했다면
			answer = Math.min(countBlank(), answer);
			return;
		}

		Position cctv = cctvList.get(idx);
		int y = cctv.y;
		int x = cctv.x;
		int type = cctv.type;

		for (int i = 0; i < direction[type].length; i++){
			mark(y,x,direction[type][i]);
			backtrack(idx+1);
			unmark(y,x,direction[type][i]);
		}
	}

	static void mark(int sy, int sx, int[] dirs){
		for (int d : dirs){
			int ny = sy;
			int nx = sx;
			while (true){
				ny += dy[d];
				nx += dx[d];

				if (!isInMap(ny, nx) || map[ny][nx] == 6) break;

				if (map[ny][nx] <= 0){
					map[ny][nx]--;
				}
			}
		}
	}

	static void unmark(int sy, int sx, int[] dirs){
		for (int d : dirs){
			int ny = sy;
			int nx = sx;
			while (true){
				ny += dy[d];
				nx += dx[d];

				if (!isInMap(ny,nx) || map[ny][nx] == 6) break;

				if (map[ny][nx] < 0){
					map[ny][nx]++;
				}
			}
		}
	}

	static boolean isInMap(int y, int x){
		if (y < 0 || y >= N || x < 0 || x >= M) return false;
		return true;
	}

	public static int countBlank(){
		int result = 0;
		for (int i = 0; i < N; i++){
			for (int j = 0; j < M; j++){
				if (map[i][j] == 0) result++;
			}
		}
		return result;
	}

	static class Position {
		int y, x, type;
		public Position(int y, int x, int type){
			this.y = y;
			this.x = x;
			this.type = type;
		}
	}
}