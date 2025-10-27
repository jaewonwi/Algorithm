import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
	static int K, N;
	static int[] score;
    public static void main(String[] args) throws Exception{
    	K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++){
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			score = new int[N];
			for (int j = 0; j < N; j++){
				score[j] = Integer.parseInt(st.nextToken());
			}

			int max = Arrays.stream(score).max().getAsInt();
			int min = Arrays.stream(score).min().getAsInt();
			Arrays.sort(score);
			int gap = 0;
			for (int j = 1; j < N; j++){
				gap = Math.max(gap, score[j] - score[j-1]);
			}

			sb.append("Class ").append(i+1).append("\n");
			sb.append("Max ").append(max).append(", Min ").append(min).append(", Largest gap ").append(gap).append("\n");
		}
		System.out.print(sb);
    }
}