import java.util.HashMap;
import java.util.Map;

public class Leetcode_13_RomanToInteger {
    public int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> mapOfRoman = new HashMap<>();
        mapOfRoman.put('I',1);
        mapOfRoman.put('V',5);
        mapOfRoman.put('X',10);
        mapOfRoman.put('L',50);
        mapOfRoman.put('C',100);
        mapOfRoman.put('D',500);
        mapOfRoman.put('M',1000);
        for (int i=0; i<s.length(); i++){
            if (i<s.length()-1 && mapOfRoman.get(s.charAt(i)) < mapOfRoman.get(s.charAt(i+1))){
                result -= mapOfRoman.get(s.charAt(i));
            }else {
                result += mapOfRoman.get(s.charAt(i));
            }
        }
        return result;

    }
}
