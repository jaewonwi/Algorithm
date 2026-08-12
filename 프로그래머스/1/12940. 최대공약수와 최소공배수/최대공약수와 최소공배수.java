class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int maxDiv = 1;
        int minMult = 1;
        
        if (n < m) {
            int temp = n;
            n = m;
            m = temp;
        }
        
        answer[0] = gcd(n, m);
        answer[1] = lcm(n, m);
        
        return answer;
    }
    
    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // 최소공배수
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}