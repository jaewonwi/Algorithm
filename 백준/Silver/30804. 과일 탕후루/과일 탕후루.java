import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        if (N <= 2) {    // 예외 처리: N이 1 또는 2일 경우
            System.out.println(N);
            return;
        }

        Map<Integer, Integer> countMap = new HashMap<>();  // 현재 윈도우 내 숫자 개수 카운트
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < N; right++) {
            countMap.put(input[right], countMap.getOrDefault(input[right], 0) + 1);

            // 윈도우에 포함된 숫자가 2개 초과일 경우 왼쪽 포인터 이동
            while (countMap.size() > 2) {
                countMap.put(input[left], countMap.get(input[left]) - 1);
                if (countMap.get(input[left]) == 0) {
                    countMap.remove(input[left]);
                }
                left++;
            }

            // 현재 윈도우 길이 갱신
            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println(maxLen);
    }
}
