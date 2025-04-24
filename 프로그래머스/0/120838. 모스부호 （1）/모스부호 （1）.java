import java.util.*;

class Solution {
    public String solution(String letter) {
        StringBuilder sb = new StringBuilder();
        String[] morse = new String[]{ 
            ".-", "-...", "-.-.", "-..", ".", "..-.",
            "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.."
        };
        
        Map<String, Character> morseMap = new HashMap<>();
        for (int i = 0; i < 26; i++){
            Character c = (char) ('a' + i);
            morseMap.put(morse[i], c);
        }
        
        String[] tokens = letter.split(" ");
        for (int i = 0; i < tokens.length; i++){
            sb.append(morseMap.get(tokens[i]));
        }
        
        String answer = sb.toString();
        return answer;
    }
}