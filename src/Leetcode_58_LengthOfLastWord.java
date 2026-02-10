public class Leetcode_58_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int result = 0;
        String[] splitArr = s.split(" ");
        String lastWord = splitArr[splitArr.length - 1 ];
        result = lastWord.length();
        return result;
    }
}

