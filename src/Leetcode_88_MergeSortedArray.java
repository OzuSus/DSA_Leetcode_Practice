import java.util.Arrays;

public class Leetcode_88_MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m+n];
        for (int i=0; i<m; i++){
            result[i] = nums1[i];
        }
        for (int j=0; j<n; j++){
            result[m+j] = nums2[j];
        }
        Arrays.sort(result);
        System.out.println(Arrays.toString(result));

    }

    public static void main(String[] args) {
        int[] num1={1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        merge(num1, 3, num2,3);

    }
}
