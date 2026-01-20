import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int time = 0;
		for (int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if (c <= 'R') {
				time += (c - 'A') / 3 + 2 + 1;
			} else {
				int num = 0;
				if (c == 'S') time += 8;
				else if (c == 'T' || c == 'U' || c == 'V') time += 9;
				else time += 10;
			}
		}
		System.out.println(time);
	}
}