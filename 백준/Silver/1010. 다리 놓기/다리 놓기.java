import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++){	// mCn의 개수 구하기
			st = new StringTokenizer(br.readLine());
			long N = Long.parseLong(st.nextToken());
			long M = Long.parseLong(st.nextToken());

			long diff = N;
			if ((M-N) < N){
				diff = M-N;
				N = diff;
			}

			long num = 1;
			for (int i = 0; i < diff; i++){
				num *= M--;
			}
			for (int i = 0; i < diff; i++){
				num /= N--;
			}
			sb.append(num).append("\n");
		}
		System.out.print(sb);
	}
}