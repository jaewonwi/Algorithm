class Solution {
    public int solution(String name) {
        int n = name.length();
        int total = 0;

        // 1. 알파벳 바꾸는 ▲▼ 최소 조작 횟수 합산
        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);
            total += Math.min(c - 'A', 'Z' - c + 1);
        }

        // 2. 커서 이동 최소 조작 횟수 계산
        int minMove = n - 1;  // 오른쪽으로 쭉 가는 기본값

        for (int i = 0; i < n; i++) {
            int next = i + 1;

            // 다음 글자부터 연속된 'A'가 몇 개인지 확인
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }

            // i: 현재 위치까지 이동한 후 ← 왼쪽으로 돌아가서 끝까지 가는 경우 비교
            int move = i + n - next + Math.min(i, n - next);
            minMove = Math.min(minMove, move);
        }

        return total + minMove;
    }
}
