import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

	static int N;
	static int[][] input, min, max;

    public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		input = new int[N][3];
		for (int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
			input[i][2] = Integer.parseInt(st.nextToken());
		}

		min = new int[N][3];
		max = new int[N][3];

		for (int i = 0; i < 3; i++){
			min[0][i] = input[0][i];
			max[0][i] = input[0][i];
		}

		for (int r = 1; r < N; r++){
			for (int c = 0; c < 3; c++){
				max[r][c] = max[r-1][c] + input[r][c];
				min[r][c] = min[r-1][c] + input[r][c];
				for (int d = -1; d <= 1; d += 2){
					int nc = c + d;
					if (nc < 0 || nc >= 3 ) continue;

					max[r][c] = Math.max(max[r][c], input[r][c] + max[r-1][nc]);
					min[r][c] = Math.min(min[r][c], input[r][c] + min[r-1][nc]);
				}
			}
		}

		int minVal = Integer.MAX_VALUE;
		int maxVal = 0;
		for (int i = 0; i < 3; i++){
			minVal = Math.min(minVal, min[N-1][i]);
			maxVal = Math.max(maxVal, max[N-1][i]);
		}

		System.out.print(maxVal+" "+minVal);
	}
}