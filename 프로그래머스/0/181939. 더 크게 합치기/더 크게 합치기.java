class Solution {
    public int solution(int a, int b) {
        StringBuilder sb = new StringBuilder();
        String strAB = String.valueOf(a).concat(String.valueOf(b));
        String strBA = String.valueOf(b).concat(String.valueOf(a));
        int intAB = Integer.parseInt(strAB);
        int intBA = Integer.parseInt(strBA);
        return intAB < intBA ? intBA : intAB;
    }
}