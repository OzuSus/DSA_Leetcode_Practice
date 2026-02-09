public class Leetcode_26_RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int result = 1;
        for (int i=0; i< nums.length-1; i++){
            if (nums[i]!=nums[i+1]){
                result +=1;
            }
        }
        if (nums.length ==0){
            return 0;
        }else {
            return result;
        }
    }
}
