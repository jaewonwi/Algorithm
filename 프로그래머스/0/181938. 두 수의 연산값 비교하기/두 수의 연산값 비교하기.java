class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int sum = Integer.parseInt(a+""+b);
        int mult = 2*a*b;
        return Math.max(sum, mult);
    }
}