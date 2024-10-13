class Solution {
    public int solution(int a, int b) {
        StringBuilder sb = new StringBuilder();
        String ab = String.valueOf(a).concat(String.valueOf(b));
        String ba = String.valueOf(b).concat(String.valueOf(a));
        int intAB = Integer.parseInt(ab);
        int intBA = Integer.parseInt(ba);
        return intAB < intBA ? intBA : intAB;
    }
}