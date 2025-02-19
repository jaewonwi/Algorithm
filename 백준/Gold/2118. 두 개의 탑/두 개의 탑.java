import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
	static int N;	// 원형으로 연결된 지점들. 이 중 두곳에 탑을 세우려고하는데 거리가 최대가 되도록.
	// 거리 = 시계 & 반시계 중 더 작은 값
	// 각 지점 사이의 거리 = 최대 10억
	static long[] dist, prefixSum;
    public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		dist = new long[N];			// 두 지점 사이의 거리
		prefixSum = new long[N+1];	// 누적합 배열
		for (int i = 0; i < N; i++){
			dist[i] = Long.parseLong(br.readLine());
			prefixSum[i+1] = dist[i] + prefixSum[i];
		}

		long total = prefixSum[N];	// 0 ~ 0 까지 거리 = 원 둘레
		long ans = 0;
		// int left = 0;
		for (int left = 0; left < N-1; left++) {
			for (int right = left+1; right < N; right++) {
				long clock = prefixSum[right] - prefixSum[left];    // 시계방향 거리 = 누적합[오른쪽 포인터] - 누적합[왼쪽 포인터] = 그 사이의 거리
				long cClock = total - clock;                        // 반시계 방향 거리 = 전체 둘레 - 시계방향 거리
				ans = Math.max(ans, Math.min(clock, cClock));
			}
		}
		System.out.println(ans);
    }
}