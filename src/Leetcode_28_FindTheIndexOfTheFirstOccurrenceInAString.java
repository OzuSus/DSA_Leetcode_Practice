public class Leetcode_28_FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        int result = 0;
        if (!haystack.contains(needle)) return -1;
        for (int i=0; i<haystack.length(); i++){
            if (haystack.substring(i, haystack.length()).startsWith(needle)){
                result = i;
                break;
            }
        }

        return result;
    }
}
