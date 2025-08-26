import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, X;
	static int[] arr;
	public static void main(String[] args) throws Exception{
    	N = Integer.parseInt(br.readLine());
		arr = new int[N];
		HashSet<Integer> set = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++){
			// arr[i] = Integer.parseInt(st.nextToken());
			set.add(Integer.parseInt(st.nextToken()));
		}
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++){
			X = Integer.parseInt(st.nextToken());
			if (set.contains(X))
				sb.append("1\n");
			else
				sb.append("0\n");
		}
		System.out.println(sb);
    }
}