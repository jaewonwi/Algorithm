import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
	static int sum;
	static int[] input, select;
	public static void main(String[] args) throws Exception{
    	// 0 < x1,x2,...,x9 < 100 -> 합 = 100
		input = new int[9];
		select = new int[7];
		sum = 0;
		for (int i = 0; i < 9; i++){
			input[i] = Integer.parseInt(br.readLine());
			sum += input[i];
		}

		subset(0,0,0);
    }

	public static void subset(int idx, int cnt, int sum){
		if (cnt == 7){
			if (sum == 100){
				for (int i = 0; i < 7; i++){
					System.out.println(select[i]);
				}
			}
			return;
		}

		if (idx == 9) return;

		select[cnt] = input[idx];
		subset(idx+1, cnt+1, sum+input[idx]);
		subset(idx+1, cnt, sum);
	}
}