import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int M, S, sr, sc, maxEat, ans = 0;	// (sr,sc): 상어의 현재 위치
	static int[][][] map = new int[4][4][8], copymap = new int[4][4][8];
	static int[][] smell = new int[4][4];
	static int[] dr = {0,-1,-1,-1,0,1,1,1}, dc = {-1,-1,0,1,1,1,0,-1};	// 좌 ~ 좌하 (시계방향)
	static int[] sdr = {-1,0,1,0}, sdc = {0,-1,0,1};	// 상좌하우
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;	// 좌표 (0,0) ~ (3,3)
			int y = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;	// 방향 0~7

			map[x][y][d]++;
		}

		st = new StringTokenizer(br.readLine());
		sr = Integer.parseInt(st.nextToken()) - 1;
		sc = Integer.parseInt(st.nextToken()) - 1;

		for (int t = 0; t < S; t++){
			// 1. 물고기 복제 시작
			copyStart();
			// 2. 모든 물고기 한 칸 씩 이동
			moveFish();
			// 3. 상어 연속 3칸 이동 (상좌하우)
			moveShark();
			// 4. 2턴 전에 생긴 물고기 냄새 사라짐
			removeSmell();
			// 5. 물고기 복제 완료 및 발생
			copyEnd();
		}

		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				for (int k = 0; k < 8; k++){
					ans += map[i][j][k];
				}
			}
		}

		System.out.println(ans);
	}

	// 1. 물고기 복제 시작
	static void copyStart(){
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				for (int k = 0; k < 8; k++){
					copymap[i][j][k] = map[i][j][k];
				}
			}
		}
	}

	// 2. 모든 물고기 한 칸 씩 이동
	static void moveFish(){
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				Arrays.fill(map[i][j], 0);	// copymap에 초기 상태를 복사해놨으니까, 이걸 보면서 map에다가 이동한 결과를 넣어준다.
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 8; k++){
					if (copymap[i][j][k] == 0) continue;

					int d = findDir(i,j,k);
					if (d != -1){	// ** 방향 바뀐 것도 고려해야 함!
						map[i+dr[d]][j+dc[d]][d] += copymap[i][j][k];
					} else {	// ** 이동하지 않은 경우도 고려해야 함!
						map[i][j][k] += copymap[i][j][k];
					}
				}
			}
		}
	}

	// 3. 상어 연속 3칸 이동 (상좌하우)
	static int[] tgt = new int[3], moved = new int[3];
	static boolean[][] visit = new boolean[4][4];
	static void moveShark(){
		for (int i = 0; i < 4; i++){
			Arrays.fill(visit[i], false);
		}
		Arrays.fill(tgt, 0);
		Arrays.fill(moved, -1);
		maxEat = -1;

		dfs(sr, sc, 0, 0);		// 물고기를 최대로 먹는 상어 이동경로 구하기

		// 상어 이동시키면서 해당 칸에 물고기 제거 & 냄새 남김
		for (int i = 0; i < 3; i++) {
			int d = moved[i];
			sr += sdr[d];
			sc += sdc[d];

			if (Arrays.stream(map[sr][sc]).sum() > 0){	// ** 물고기가 있었던 칸만 냄새가 남는다.
				Arrays.fill(map[sr][sc], 0);    // 물고기 제거
				smell[sr][sc] = 3;    // 냄새 남기기
			}
		}
	}

	// 4. 2턴 전에 생긴 물고기 냄새 사라짐
	static void removeSmell(){
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				if (smell[i][j] > 0)
					smell[i][j]--;
			}
		}
	}

	// 5. 물고기 복제 완료 및 발생
	static void copyEnd(){
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				for (int k = 0; k < 8; k++){
					map[i][j][k] += copymap[i][j][k];
				}
			}
		}
	}

	static void dfs(int r, int c, int cnt, int curEat){
		if (cnt == 3){
			if (curEat > maxEat){
				maxEat = curEat;
				for (int i = 0; i < 3; i++){
					moved[i] = tgt[i];
				}
			}
			return;
		}

		for (int d = 0; d < 4; d++){
			int nr = r + sdr[d];
			int nc = c + sdc[d];

			if (!isInner(nr, nc)) continue;

			if (!visit[nr][nc]){
				int eatFish = Arrays.stream(map[nr][nc]).sum();
				tgt[cnt] = d;
				visit[nr][nc] = true;
				dfs(nr, nc, cnt+1, curEat + eatFish);
				visit[nr][nc] = false;
			} else {
				tgt[cnt] = d;
				dfs(nr, nc, cnt+1, curEat);
			}
		}
	}

	static boolean isInner(int r, int c){
		if (r >= 0 && r < 4 && c >= 0 && c < 4) return true;
		return false;
	}

	static int findDir(int r, int c, int d){
		int result = -1;
		for (int i = 8; i > 0; i--){
			int dir = (d+i)%8;
			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if (!isInner(nr, nc)) continue;		// 범위 밖
			if (nr == sr && nc == sc) continue;	// 상어가 있는 칸
			if (smell[nr][nc] > 0) continue;	// 물고기 냄새가 있는 칸

			result = dir;
			break;
		}
		return result;
	}
}