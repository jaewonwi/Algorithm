import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
	static int[] nums = new int[6];
    public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++){
			nums[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = -999; i <= 999; i++){
			for (int j = -999; j <= 999; j++){
				if (cal(i, j)){
					System.out.println(i+" "+j);
					break;
				}
			}
		}
		return;
	}

	static boolean cal(int x, int y){
		if ((nums[0] * x + nums[1] * y) == nums[2]){
			if ((nums[3] * x + nums[4] * y) == nums[5])
				return true;
		}
		return false;
	}
}