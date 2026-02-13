import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
		int N = Integer.parseInt(br.readLine());
		int num = 666;
		int cnt = 1;
		while (cnt < N){
			num++;
			if (String.valueOf(num).contains("666")) {
				cnt++;
			}
		}
		System.out.println(num);
    }
}