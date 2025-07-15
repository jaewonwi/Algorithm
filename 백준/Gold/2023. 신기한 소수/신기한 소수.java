import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
	static int N;
	static boolean[] nums;
    public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		backtrack(0,0);

		System.out.println(sb);
    }

	static void backtrack(int n, int cnt){
		if (cnt == N){
			sb.append(n).append("\n");
			return;
		}

		for (int i = 0; i <= 9; i++){
			int nn = n * 10 + i;
			if (isPrime(nn))
				backtrack(nn, cnt+1);
		}
	}

	static boolean isPrime(int n){
		if (n == 1 || n == 0) return false;
		for (int i = 2; i <= Math.sqrt(n); i++){
			if (n % i == 0) return false;
		}

		return true;
	}
}