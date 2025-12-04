class Solution {
    public int solution(int[] box, int n) {
        int x = box[0];
        int y = box[1];
        int z = box[2];
        
        int xx = x / n;
        int yy = y / n;
        int zz = z / n;
        
        return xx*yy*zz;
    }
}