import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] dy = {0, 0, -1}, dx = {-1, 1, 0};        // 좌,우,상
	static int[][] map = new int[100][100];

	public static void main(String[] args) throws Exception {
		int sy = 0, sx = 0;
		for (int tc = 1; tc <= 10; tc++) {
			// 입력
			br.readLine();							// ** 테케 번호 무시
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					int n = Integer.parseInt(st.nextToken());
					if (n == 2) {
						sy = i;
						sx = j;
					}
					map[i][j] = n;
				}
			}

			map[sy][sx] = 3;
			while (sy > 0) {	// 계산
				int ny = sy;
				int nx = sx;

				if (isIn(ny+dy[0], nx+dx[0])) {
					map[ny+dy[0]][nx+dx[0]] = 3;
					sx = nx + dx[0];
				} else if (isIn(ny+dy[1], nx+dx[1])) {
					map[ny+dy[1]][nx+dx[1]] = 3;
					sx = nx + dx[1];
				} else {
					map[ny+dy[2]][nx+dx[2]] = 3;
					sy = ny + dy[2];
				}
			}
			sb.append("#").append(tc).append(" ").append(sx).append("\n");
		}
		System.out.print(sb);
	}

	static boolean isIn(int ny, int nx){
		if (ny < 0 || ny >= 100 || nx < 0 || nx >= 100 || map[ny][nx] != 1)
			return false;
		return true;
	}

}