import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N; 
	static long ans = 0;
	static int[] A;

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		A = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A); // 정렬 (O(N log N))

		for (int i = 0; i < N - 2; i++) {
			int left = i + 1, right = N - 1;
			while (left < right) {
				int sum = A[i] + A[left] + A[right];

				if (sum == 0) {
					// **중복 개수를 고려하여 정확히 계산**
					if (A[left] == A[right]) {
						int count = right - left + 1;
						ans += (count * (count - 1)) / 2; // 조합의 개수 (nC2)
						break;
					}

					int leftCount = 1, rightCount = 1;

					while (left < right && A[left] == A[left + 1]) {
						left++;
						leftCount++;
					}
					while (left < right && A[right] == A[right - 1]) {
						right--;
						rightCount++;
					}

					ans += leftCount * rightCount;
					left++;
					right--;

				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}

		System.out.println(ans);
	}
}