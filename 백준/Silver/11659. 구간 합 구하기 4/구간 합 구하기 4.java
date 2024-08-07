import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, sum;
	static int[] src, sumArr;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		src = new int[N];
		sumArr = new int[N+1];
		sum = 0;
		for (int t = 0; t < N; t++) {
			src[t] = Integer.parseInt(st.nextToken());
			sum += src[t];
			sumArr[t+1] =  sum;
		}
		
		
		for (int t = 0; t < M; t++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
		
			System.out.println(sumArr[j] - sumArr[i-1]);
		}
		

	}

}
