import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N;
	static final int INF = 999999;	// Integer.MAX_VALUE의 오버플로우 방지(맵 크기 상 필요없을듯)
	static int[][] map, dist;
	static boolean[][] visit;
	static int[] dy = {-1,1,0,0}, dx = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
		// 흰 -> 흰: 가능. 검은방(0) 진입X
		// 시작방(0,0) -> 끝방(n-1,n-1)을 가기 위해서 바꾸어야하는 검은 방의 최소 개수
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dist = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++){
			String str = br.readLine();
			for (int j = 0; j < N; j++){
				map[i][j] = str.charAt(j)-'0';
			}
		}

		for (int i = 0; i < N; i++){	// 최단거리 배열 초기화
			Arrays.fill(dist[i], INF);
		}

		// BFS로 최단거리 찾기 + 한 칸씩 바꾸는 경우랑 비교하기
		dijkstra(0, 0);

		System.out.println(dist[N-1][N-1]);
    }

	static void dijkstra(int y, int x){
		Queue<Pos> pq = new ArrayDeque<>();
		pq.add(new Pos(y,x,0));
		visit[y][x] = true;

		while (!pq.isEmpty()){
			Pos cur = pq.poll();

			for (int d = 0; d < 4; d++){
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];

				if (!isInner(ny, nx)) continue;

				int before = dist[ny][nx];
				if (map[ny][nx] == 1){	// 흰 방일 경우
					dist[ny][nx] = Math.min(dist[ny][nx], cur.cost);
				} else {	// 검은 방일 경우 -> 방 바꿔줘야 함
					dist[ny][nx] = Math.min(dist[ny][nx], cur.cost + 1);
				}

				if (before != dist[ny][nx]){	// 이전이랑 값이 바뀌었다면 -> 또 보자 -> pq에 넣자.
					pq.add(new Pos(ny, nx, dist[ny][nx]));
				}
			}
		}
	}

	static boolean isInner(int ny, int nx){
		if (ny >= 0 && ny < N && nx >= 0 && nx < N) return true;
		return false;
	}

	static class Pos{
		int y, x, cost;
		public Pos(int y, int x, int cost){
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
	}
}