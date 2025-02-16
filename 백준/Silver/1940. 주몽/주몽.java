import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
    	// N, M 입력받고 저장
		// N 고유번호 정렬 -> O(NlogN) = 15000 * 130 = 2*10^6 = 1s
		// 투포인터로 두개의 합이 M이 되는지 체크하면서 포인터 증가시키기
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int startIdx = 0;
		int endIdx = N-1;

		int cnt = 0;
		while (startIdx < endIdx){
			int sum = arr[startIdx] + arr[endIdx];
			if (sum == M){
				cnt++;
				startIdx++;
				endIdx--;
			} else if (sum < M){
				startIdx++;
			} else if (sum > M){
				endIdx--;
			}
		}

		System.out.println(cnt);
    }
}