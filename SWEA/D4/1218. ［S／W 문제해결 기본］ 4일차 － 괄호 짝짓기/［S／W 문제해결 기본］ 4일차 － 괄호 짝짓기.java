import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

	// '()', '[]', '{}', '<>'
	static char[] front = {'(','[','{','<'}, end = {')',']','}','>'};
    public static void main(String[] args) throws Exception{
		Stack<Character> stack = new Stack<>();
		for (int tc = 1; tc <= 10; tc++){
			sb.append("#").append(tc).append(" ");
			int len = Integer.parseInt(br.readLine());
			String str = br.readLine();

			if (len % 2 != 0) {
				sb.append("0").append("\n");
				continue;
			}

			stack.clear();
			int ans = 1;
			for (int i = 0; i < len; i++){
				char c = str.charAt(i);
				if (isFront(c))
					stack.push(c);
				else {
					char out = stack.peek();
					if (!check(out, c)){	// 짝이 맞지않을 경우 - 유요하지 X
						ans = 0;
						break;
					} else {	// 짝이 맞을 경우 - 계속 탐색
						stack.pop();
					}
				}
			}

			if (!stack.isEmpty()){
				ans = 0;
			}
			sb.append(ans).append("\n");
		}

		System.out.println(sb);
    }

	static boolean isFront(char c){
		for (int i = 0; i < 4; i++){
			if (c == front[i]) return true;
		}
		return false;
	}

	static boolean check(char out, char c){
		for (int i = 0; i < 4; i++){
			if (out == front[i] && c == end[i]){
				return true;
			}
		}
		return false;
	}
}