import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
    public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++){
			int n = Integer.parseInt(st.nextToken());
			min = Math.min(n, min);
			max = Math.max(n, max);
		}

		System.out.println(min+" "+max);
    }
}