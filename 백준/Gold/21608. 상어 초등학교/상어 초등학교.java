import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

	static int N, me, blanks, likes, ans = 0;	// 교실 크기 N, 학생 수 N^2
	static int[][] map, student;
	static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1}, satis = {0,1,10,100,1000};
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		student = new int[N*N+1][4];
		for (int i = 0; i < N*N; i++){
			st = new StringTokenizer(br.readLine());
			me = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 4; j++){
				int friend = Integer.parseInt(st.nextToken());
				student[me][j] = friend;
			}

			sit(me);
		}

		for (int r = 0; r < N; r++){
			for (int c = 0; c < N; c++){
				int me = map[r][c];
				int likes = 0;
				for (int d = 0; d < 4; d++){
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (!isIn(nr,nc)) continue;

					if (isLike(me, map[nr][nc])) likes++;
				}
				ans += satis[likes];
			}
		}
		System.out.println(ans);
    }

	static void sit(int me){	// num번째 학생을 앉히자
		int curR = 0;
		int curC = 0;
		int maxBlanks = -1;
		int maxLikes = -1;
		for (int r = 0; r < N; r++){
			for (int c = 0; c < N; c++){	// 빈 칸 전체를 보면서
				if (map[r][c] != 0) continue;

				blanks = 0;
				likes = 0;
				for (int d = 0; d < 4; d++){
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (!isIn(nr,nc)) continue;

					if (map[nr][nc] == 0){
						blanks++;
					} else if (isLike(me, map[nr][nc])){
						likes++;
					}
				}

				if (maxLikes < likes){	// 좋아하는 학생이 더 많은 칸
					curR = r;
					curC = c;
					maxLikes = likes;
					maxBlanks = blanks;
				} else if (maxLikes == likes){	// 좋아하는 학생이 같으면
					if (maxBlanks < blanks){	// 빈칸이 더 많은 칸
						curR = r;
						curC = c;
						maxBlanks = blanks;
					}
				}
			}
		}

		map[curR][curC] = me;
	}

	static boolean isIn(int nr, int nc){
		if (nr < 0 || nc < 0 || nr >= N || nc >= N) return false;
		return true;
	}

	static boolean isLike(int me, int friend){
		for (int i = 0; i < 4; i++){
			if (student[me][i] == friend){
				return true;
			}
		}
		return false;
	}
}