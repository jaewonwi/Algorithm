import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();

		int TC = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= TC; tc++){
			String str = br.readLine();
			int flag = 0;
			int count = 0;
			for (int i = 0; i < str.length(); i++){
				if (str.charAt(i)-'0' != flag){
					flag = (flag+1) % 2;
					count++;
				}
			}
			sb.append("#"+tc+" "+count+"\n");
		}
		System.out.print(sb);
	}
}
