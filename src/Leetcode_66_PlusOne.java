import java.math.BigInteger;
import java.util.Arrays;

public class Leetcode_66_PlusOne {
    public static int[] plusOne(int[] digits) {
        BigInteger digiNumber = new BigInteger(Integer.toString(digits[0]));
        for (int i=1; i< digits.length; i++){
            digiNumber = digiNumber.multiply(BigInteger.TEN).add(BigInteger.valueOf(digits[i]));
        }
        System.out.println(digiNumber);
        BigInteger finalNum = digiNumber.add(BigInteger.ONE);
        String digitString = finalNum.toString();
        int[] result = new int[digitString.length()];
        for (int i=0; i<digitString.length(); i++){
            result[i] = Integer.parseInt(digitString.charAt(i)+"");
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3};
        plusOne(nums);
    }
}
