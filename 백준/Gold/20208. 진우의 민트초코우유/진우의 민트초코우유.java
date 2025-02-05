import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

	static int N, M, H, size, ans;
	static int[][] map;
	static List<Pos> milks = new ArrayList<>();

	static boolean[] visit;

	// 민초단 진우 -> 매일 아침 특정 지역들에서 민초우유가 배달되는 마을로 이사까지 해버림;
	// 아침마다 마을에 우유 찾으러 돌아다님 (초기체력 M = 진우가 총 이동할 수 있는 거리)
	// 이동 -1 / 우유 마심 +H (초기체력 이상으로 증가할 수 있음. 0이되는 순간 이동할 수 없음)
	// 최대한 많은 초코우유를 먹고 집에 다시 돌아오는 경우를 찾자.(=탐색중에 체력이 0이 되면 안됨)
    public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		milks.add(new Pos(0,0));
		for (int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 1) {
					milks.set(0, new Pos(i,j));		// 0번째 = 집
				}
				if (map[i][j] == 2) milks.add(new Pos(i, j));
			}
		}

		size = milks.size();
		visit = new boolean[size];
		ans = 0;
		backtracking(0, 0, M);
		System.out.println(ans);
    }

	static int distance(int a, int b){
		Pos pa = milks.get(a);
		Pos pb = milks.get(b);

		int ay = pa.y, ax = pa.x;
		int by = pb.y, bx = pb.x;

		return Math.abs(ay - by) + Math.abs(ax - bx);
	}

	static void backtracking(int cnt, int last, int h){
		if (h - distance(last, 0) >= 0){
			ans = Math.max(ans, cnt);
		}

		for (int i = 1; i < size; i++){
			if (visit[i]) continue;

			int rem = h - distance(last, i);
			if (rem >= 0){
				visit[i] = true;
				backtracking(cnt+1, i, rem+H);
				visit[i] = false;
			}
		}
	}

	static class Pos{
		int y, x;
		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}