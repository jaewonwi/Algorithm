// BOJ 12891. DNA 비밀번호

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부분 문자열로 비밀번호를 만든다. 등장하는 문자 개수가 특정 개수 이상이어야 비밀번호로 사용 가능
// 입력: 임의의 문자열, 부분문자열 길이, ACGT가 각 몇 번 이상 등장해야하는지
// 출력: 만들 수 있는 비밀번호의 종류 수
// 조건: 위치가 다르면 부분문자열이 같더라도 다른 문자열로 취급
public class Main {
    static int S, P, result;
    static char[] dna;
    static int[] acgt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        dna = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine().trim());
        acgt = new int[4];
        for (int i = 0; i < 4; i++){
            acgt[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = P - 1;
        result = 0;
        // 처음 0 ~ P 체크해서 문자열이 되는지 체크
        for (int i = 0; i < P; i++){
            int idx = getChar(dna[i]);
            if (idx >= 0) acgt[idx]--;
        }
        if (isPossible()) result++;

        while (end < S-1){
            int idx = getChar(dna[start]);
            if (idx >= 0) acgt[idx]++;
            start++;

            end++;
            idx = getChar(dna[end]);
            if (idx >= 0) acgt[idx]--;

            if (isPossible()) result++;
        }

        System.out.println(result);
    }

    static int getChar(char c){
        switch (c){
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
        }
        return -1;
    }

    static boolean isPossible(){
        boolean flag = true;
        for (int i = 0; i < 4; i++){
            if (acgt[i] > 0) flag = false;
        }

        return flag;
    }
}
