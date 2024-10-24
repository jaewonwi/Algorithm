class Solution {
    public int solution(int hp) {
        // 장군 5, 병정 3, 일 1
        int first = hp / 5;
        int sec = (hp - 5 * first) / 3;
        int third = hp - 5 * first - 3 * sec;
        
        int answer = first + sec +third;
        return answer;
    }
}