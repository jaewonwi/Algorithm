import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
	static int N, M, R;
	static int[][] arr;
    public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 세로
		M = Integer.parseInt(st.nextToken());	// 가로
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int idx = Math.min(N, M) / 2;
		for (int i = 0; i < idx; i++){
			int r = (N-1-i-i)*2 + (M-1-i-i)*2;
			rotate(i,N-1-i, i, M-1-i, R % r);
		}

		print();
    }

	// 회전
	static void rotate(int u, int d, int l, int r, int cnt){
		while (cnt > 0){
			int temp = arr[u][l];
			// 위
			for (int idx = 0; idx < r-l; idx++){
				arr[u][l+idx] = arr[u][l+idx+1];
			}
			// 오른쪽
			for (int idx = 0; idx < d-u; idx++){
				arr[u+idx][r] = arr[u+idx+1][r];
			}
			// 아래
			for (int idx = 0; idx < r-l; idx++){
				arr[d][r-idx] = arr[d][r-idx-1];
			}
			// 오른쪽
			for (int idx = 0; idx < d-u; idx++){
				arr[d-idx][l] = arr[d-idx-1][l];
			}
			arr[u+1][l] = temp;
			cnt--;
		}
	}

	// 출력
	static void print(){
		for (int i = 0; i < N; i++){
			for (int j = 0; j < M; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}