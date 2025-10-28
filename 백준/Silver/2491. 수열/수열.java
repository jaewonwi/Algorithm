import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
		int N = Integer.parseInt(br.readLine());
		int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(i-> Integer.parseInt(i)).toArray();

		int[] dpInc = new int[N];
		dpInc[0] = 1;
		int inc = nums[0];
		int[] dpDec = new int[N];
		dpDec[0] = 1;
		int dec = nums[0];
		for (int i = 1; i < N; i++){
			if (nums[i] >= inc){
				dpInc[i] = dpInc[i-1] + 1;
			} else {
				dpInc[i] = 1;
			}
			inc = nums[i];

			if (nums[i] <= dec){
				dpDec[i] = dpDec[i-1] + 1;
			} else {
				dpDec[i] = 1;
			}
			dec = nums[i];

		}

		System.out.println(Math.max(Arrays.stream(dpInc).max().getAsInt(), Arrays.stream(dpDec).max().getAsInt()));
	}
}