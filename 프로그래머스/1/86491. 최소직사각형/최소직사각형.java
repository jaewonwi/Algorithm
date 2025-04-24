class Solution {
    public int solution(int[][] sizes) {
        int maxH = 0;
        int maxW = 0;
        for (int i = 0; i < sizes.length; i++){
            int longer = sizes[i][0] > sizes[i][1] ? sizes[i][0] : sizes[i][1];
            int shorter = sizes[i][0] > sizes[i][1] ? sizes[i][1] : sizes[i][0];
            maxH = Math.max(maxH, longer);
            maxW = Math.max(maxW, shorter);
        }
        int answer = maxH * maxW;
        return answer;
    }
}