import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		int cnt = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(st.nextToken());	// 최대 10억
		}

		Arrays.sort(arr);
		
		// ** tgt를 3번째부터 보고, right를 tgt-1로 하니까 첫번째 두번쨰 세번째가 같은 경우일 때도 건너뛰게 됨 -> 첫번째부터 다 보되, tgt를 N-1부터 다 보는걸로 변경
		for (int tgt = 0; tgt < N; tgt++){	
			long find = arr[tgt];
			int left = 0;
			int right = N-1;

			while (left < right){
				long sum = arr[left] + arr[right];
				if (sum == find){
					// ** 자기 자신을 포함해서 좋은 수를 만드는 경우를 제외시켜야 함
					if (left != tgt && right != tgt){
						cnt++;
						break;
					} else if (left == tgt){
						left++;
					} else if (right == tgt){
						right--;
					}
				} else if (sum > find){
					right--;
				} else {
					left++;
				}
			}
		}

		System.out.println(cnt);
    }
}