import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

	static int tot = 0, ans = Integer.MAX_VALUE;
	static int[][] map = new int[10][10];
	static boolean[][] visit = new boolean[10][10];
	static int[] count = new int[5];	// 0 ~ 5
	static int[] dy = {0,1,1}, dx = {1,1,0};	// 우 우하 하
    public static void main(String[] args) throws Exception{
    	for (int i = 0; i < 10; i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) tot++;
			}
		}

		search(0, 0);

		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

	static void search(int y, int x){
		// 종료조건
		if (tot == 0){	// 더이상 채워야 할 칸이 없다면
			int sum = 0;
			for (int i = 0; i < 5; i++){
				sum += count[i];
			}
			ans = Math.min(ans, sum);
			return;
		}

		if (y > 9 || x > 9) return;		// 0,0부터 보다가 범위를 벗어나면

		if (map[y][x] == 1 && !visit[y][x]){		// 아직 붙이지 않은 1인 칸을 만나면
			for (int k = 4; k >= 0; k--){		// 종이를 하나씩 대보면서
				if (count[k] >= 5) continue;	// 이미 5장 사용했다면 패스

				if (isAvailable(y, x, k)){	// 이 종이를 붙일 수 있다면 붙여주자
					double cnt = Math.pow(k+1, 2);
					// 색종이 붙이기
					fill(y,x,k,true);
					tot -= cnt;

					// 다음 칸 살펴보러 가자
					if (x == 9)				// 종이의 오른쪽 끝이라면
						search(y+1, 0);
					else
						search(y,x+1);

					// 원상복구
					fill(y,x,k,false);
					tot += cnt;
				}
			}
		}

		else {	// 0 이라면 다음칸 바로 보자
			if (x == 9)				// 종이의 오른쪽 끝이라면
			{
				search(y+1, 0);
			}
			else
				search(y,x+1);
		}
	}

	static void fill(int y, int x, int size, boolean flag){
		for (int i = y; i <= y + size; i++){
			for (int j = x; j <= x + size; j++){
				visit[i][j] = flag;
			}
		}

		if (flag) count[size]++;
		else count[size]--;
	}

	static boolean isAvailable(int y, int x, int size){
		for (int i = y; i <= y + size; i++){
			for (int j = x; j <= x + size; j++){
				if (!isIn(i, j)) return false;	// 범위 밖
				if (visit[i][j]) return false;	// 이미 종이가 붙여져있다면
				if (map[i][j] == 0) return false;	// 0인 칸
			}
		}
		return true;
	}

	static boolean isIn(int y, int x){
		if (y < 0 || y >= 10 || x < 0 || x >= 10) return false;
		return true;
	}
}