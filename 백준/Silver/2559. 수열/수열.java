import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{
    	st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] temperature = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++){
			temperature[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = K;
		int answer = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = left; i < right; i++){
			sum += temperature[i];
		}
		answer = Math.max(answer, sum);

		while (right < N){
			sum -= temperature[left];
			sum += temperature[right];
			left++;
			right++;
			answer = Math.max(answer, sum);
		}

		System.out.println(answer);
    }
}