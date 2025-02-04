import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static boolean isPrint = false;
	static int[][] map = new int[9][9];
	static ArrayList<Pos> blanks = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0){
					blanks.add(new Pos(i, j));
				}
			}
		}

		for (int i = 0; i < blanks.size(); i++){
			find_square(i);
			find_cross(i);
        }
		backtracking(0);
	}

	static void print(){
		for (int i = 0; i < 9; i++){
			for (int j = 0; j < 9; j++){
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void backtracking(int idx){
		if (idx == blanks.size()){
			print();
			isPrint = true;
			return;
		}

		Pos cur = blanks.get(idx);
		for (int i = 1; i <= 9; i++){
			if (cur.flag[i]) continue;

			if (check_square(cur.y, cur.x, i) && check_cross(cur.y, cur.x, i)){
				map[cur.y][cur.x] = i;
				backtracking(idx+1);
			}

			if (isPrint) return;

			map[cur.y][cur.x] = 0;
		}
	}

	static void find_square(int idx){
		Pos cur = blanks.get(idx);

		int sy = cur.y, sx = cur.x; 	// 0, 3, 6
		while (sy % 3 != 0){
			sy--;
		}
		while (sx % 3 != 0){
			sx--;
		}

		for (int i = sy; i < sy + 3; i++){
			for (int j = sx; j < sx + 3; j++){
				if (map[i][j] != 0) {
					cur.flag[map[i][j]] = true;
				}
			}
		}
	}

	static void find_cross(int idx){
		Pos cur = blanks.get(idx);
		for (int i = 0; i < 9; i++){		// 세로
			if (map[i][cur.x] != 0)
				cur.flag[map[i][cur.x]] = true;
		}
		for (int i = 0; i < 9; i++){		// 가로
			if (map[cur.y][i] != 0)
				cur.flag[map[cur.y][i]] = true;
		}
	}

	static boolean check_square(int y, int x, int num){
		int sy = y, sx = x; 	// 0, 3, 6
		while (sy % 3 != 0){
			sy--;
		}
		while (sx % 3 != 0){
			sx--;
		}

		for (int i = sy; i < sy + 3; i++){
			for (int j = sx; j < sx + 3; j++){
				if (map[i][j] == num)
					return false;
			}
		}

		return true;
	}

	static boolean check_cross(int y, int x, int num){
		for (int i = 0; i < 9; i++){
			if (map[i][x] == num)
				return false;
			if (map[y][i] == num)
				return false;
		}
		return true;
	}

	static class Pos{
		int y, x;
		boolean[] flag = new boolean[10];
		public Pos(int r, int c){
			this.y = r;
			this.x = c;
		}
	}
}