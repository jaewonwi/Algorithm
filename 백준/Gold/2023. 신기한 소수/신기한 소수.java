import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());

        dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);

		System.out.println(sb.toString());
    }

	static void dfs(int number, int jarisu){
        if (jarisu == N){
			if (isPrime(number)) {
				sb.append(number).append("\n");
			}
			return;
		}

		for (int i = 1; i <= 9; i += 2){
			if (isPrime(number * 10 + i))
				dfs(number * 10 + i, jarisu + 1);
		}
	}

	static boolean isPrime(int n){
		for (int i = 2; i <= Math.sqrt(n); i++){
			if (n % i == 0) return false;
		}
		return true;
	}
}