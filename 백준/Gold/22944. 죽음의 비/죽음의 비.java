import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, H, D, K = 0, ans = Integer.MAX_VALUE;
	static char[][] map;
	static int sr, sc, er, ec;
	static int[][] umbrellas = new int[10][2];
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'E') {
					er = i;
					ec = j;
				} else if (map[i][j] == 'S') {
					sr = i;
					sc = j;
				}
			}
		}

		bfs();

		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

	static void bfs(){
		// 1.이동
		// 2.도착지일 경우 종료
		// 3.우산이 있다면 우산 들기 = 우산 내구도 갱신 & 맵에서 제거
		// 4.비내림 -> 내구도 감소 or 체력 감소
		// 5.우산 내구도 0 ? 우산 사라짐
		// 6.체력 0 ? 사망
		Queue<Pos> q = new ArrayDeque<>();
		q.offer(new Pos(sr, sc,0,0, H));
		int[][] dist = new int[N][N];

		while (!q.isEmpty()){
			Pos cur = q.poll();
			if (cur.r == er && cur.c == ec && cur.h > 0){	// 탈출구라면 종료
				ans = cur.cnt;
				break;
			}

			for (int dir = 0; dir < 4; dir++){	// 이동
				int nr = cur.r + dr[dir];
				int nc = cur.c + dc[dir];

				if (!isIn(nr,nc)) continue;

				int cnt = cur.cnt;
				int d = cur.d;
				int h = cur.h;

				if (map[nr][nc] == 'E'){	// ** 다음 칸이 탈출구라면
					q.offer(new Pos(nr, nc, cnt+1, d, h));
				} else if (map[nr][nc] == 'U'){	// 우산이 있다면 우산 쓰기
					d = D;
				}

				if (d > 0) d--;	// 비내림 = 우산 내구도 or 체력 감소
				else h--;

				int sum = h + d;
				if (h > 0 && dist[nr][nc] < sum){    // 체력 0일 경우 사망, '우산 내구도 + 남은 체력'이 기존에 dist 배열에 기록해놓은 것보다 많다면
					dist[nr][nc] = sum;
					q.offer(new Pos(nr, nc, cnt+1, d, h));
				}
			}
		}
	}

	static class Pos {
		int r, c, cnt, d, h;	// d: 내구도, h: 체력
		public Pos(int r, int c, int cnt, int d, int h){
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.d = d;
			this.h = h;
		}
	}

	static boolean isIn(int r, int c){
		if (r >= 0 && r < N && c >= 0 && c < N) return true;
		return false;
	}
}