import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		// 가장작은 생성자 찾기
		int M = N;
		int ans = Integer.MAX_VALUE;
		while (M > 0) {
			int m = cal(M);
			if (m == N){
				ans = Math.min(ans, M);
			}
			M--;
		}
		System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
		return;
	}

	static int cal(int n){
		int result = n;
		while (n > 0){
			result += n % 10;
			n /= 10;
		}
		return result;
	}
}