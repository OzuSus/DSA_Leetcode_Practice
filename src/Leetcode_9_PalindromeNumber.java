public class Leetcode_9_PalindromeNumber {
    public static boolean isPalindrome(int x) {
        boolean result = false;
        StringBuilder strBuilder = new StringBuilder(new String(String.valueOf(x)));
        if (strBuilder.reverse().toString().equals(String.valueOf(x))) result = true;
        return result;
    }


}
