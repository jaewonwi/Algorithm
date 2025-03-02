import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
	static int N, C, ans;
	static int[] home;
    public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		home = new int[N];
		for (int i = 0; i < N; i++){
			home[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(home);

		// ans = Integer.MAX_VALUE;	// 최소 거리가 최대가 되게
		int left = 0;
		int right = home[N-1];
		while (left <= right) {
			int mid = (right+left) / 2;

			if (cal(mid) < C){
				right = mid-1;
			} else {
				left = mid+1;
			}
		}

		System.out.println(right);

    }

	static int cal(int dist){
		int prev = 0;
		int cnt = 1;
		for (int cur = 1; cur < N; cur++){
			if (home[cur] - home[prev] >= dist){
				prev = cur;
				cnt++;
			}
		}

		return cnt;
	}
}