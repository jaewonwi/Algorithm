import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        String s = br.readLine();
        Integer[] chars = new Integer[s.length()];
        for (int i = 0; i < s.length(); i++){
            chars[i] = s.charAt(i) - '0';
        }
        Arrays.sort(chars, Collections.reverseOrder()); // 내림차순 정렬
        for (int i = 0; i < chars.length; i++){
            sb.append(chars[i]);
        }
        System.out.println(sb.toString());
    }
}