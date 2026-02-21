import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	static int[] A, tgt;
	static int[] operator = new int[4];
	public static void main(String[] args) throws Exception {
		// 숫자 N개, 연산자(+ - * /) N-1개
		// 숫자 순서 못바꿈. 무조건 앞에서부터 계산. 몫만 취함.
		// 음수 / 양수 = (|음수| / 양수 ) * -1
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++){
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++){
			operator[i] = Integer.parseInt(st.nextToken());
		}
		tgt = new int[N-1];
		Arrays.fill(tgt, -1);

		backtrack(0);
		System.out.println(max);
		System.out.println(min);
	}

	public static void backtrack(int idx){
		if (idx == N - 1){
			int result = cal();
			min = Math.min(min, result);
			max = Math.max(max, result);
			return;
		}

		for (int i = 0; i < 4; i++){
			if (operator[i] > 0){
				tgt[idx] = i;
				operator[i]--;
				backtrack(idx+1);
				operator[i]++;
			}
		}
	}

	public static int cal(){
		int result = A[0];
		for (int i = 1; i < N; i++){
			int op = tgt[i-1];
			if (op == 0){
				result += A[i];
			} else if (op == 1){
				result -= A[i];
			} else if (op == 2){
				result *= A[i];
			} else {
				if (result < 0)
					result = Math.abs(result) / A[i] * -1;
				else
					result = Math.abs(result) / A[i];
			}
		}
		return result;
	}
}