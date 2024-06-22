class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        
        String ageStr = Integer.toString(age);
        if (ageStr.length() >= 4){
            sb.append((char) ((age / 1000) + 'a'));
            age %= 1000;
        }
        if (ageStr.length() >= 3){
            sb.append((char) ((age / 100) + 'a'));
            age %= 100;
        }
        if (ageStr.length() >= 2){
            sb.append((char) ((age / 10) + 'a'));
            age %= 10;
        }
        sb.append((char) (age + 'a'));
        
        return sb.toString();
    }
    
}