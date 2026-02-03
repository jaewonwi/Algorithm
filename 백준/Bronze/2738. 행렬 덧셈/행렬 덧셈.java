import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] matrix = new int[N][M];
		for (int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++){
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++){
				matrix[i][j] += Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++){
			for (int j = 0; j < M; j++){
				sb.append(matrix[i][j]).append(" ");
			}
			sb.append("\n");
		}

		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
	}
}