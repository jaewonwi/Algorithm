import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, COUNT = -1;
	static int[][] ondo;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		// 3kg & 5kg
		int cnt = -1; 
		
		if (N % 5 == 0) {
			cnt = N/5;
		} else {
			for (int i = N/5; i >= 0; i--) {
				int rem = N - 5 * i;
				if (rem % 3 == 0) {
					cnt = i;
					cnt += rem /3;
					break;
				}
			}
		}
		
		System.out.println(cnt);
		
		
	}
}
