public class Leetcode_35_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int result = 0;
        for (int i=0; i<nums.length; i++){
            if (target > nums[i]){
                result = i+1;
            }else if (target > nums[nums.length-1]){
                result = nums.length+1;
            }
        }
        return result;
    }
}
