import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
	static int[] tree;
    public static void main(String[] args) throws Exception{
    	// 절단하고 남은 나무가 M 이상이되, 최소가 되도록 하려고 함
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new int[N];
		st = new StringTokenizer(br.readLine());
		int max = 0;
		for (int i = 0; i < N; i++){
			tree[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, tree[i]);
		}

		long left = 0;
		long right = max;
		while (left <= right){
			long mid = (left + right) / 2;

			if (cut(mid) < M){
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(right);
    }

	static long cut(long mid){
		long sum = 0;
		for (int i = 0; i < N; i++){
			long rem = tree[i] - mid;
			if (rem < 0) continue;
			sum += rem;
		}
		return sum;
	}
}