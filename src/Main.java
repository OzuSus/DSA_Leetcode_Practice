import javax.transaction.xa.XAResource;
import java.math.BigInteger;
import java.util.*;

public class Main {
    //==================Leet 1: Lấy ra vi tri các số trong mảng sao cho tổng = target=====================================
//    public static int[] twoSum(int[] nums, int target) {
//        for (int i=0; i<nums.length; i++){
//            for (int j=0; j<nums.length; j++){
//                if (nums[i] + nums[j] == target){
//                    System.out.println(Arrays.toString(new int[]{i,j}));
//                    return new int[]{i,j};
//                }
//            }
//        }
//        return new int[]{};
//
//    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                System.out.println(Arrays.toString(new int[]{map.get(complement), i}));
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    //==============Leet 2:Kiểm tra 1 số có đối xứng hay ko ==================================
    public static boolean isPalindrome(int x) {
        boolean result = false;
        StringBuilder stringOfX = new StringBuilder(Integer.toString(x));
        StringBuilder revertString = new StringBuilder(stringOfX);
        revertString.reverse();
//        System.out.println(revertString);
        if (stringOfX.toString().equals(revertString.toString())) {
            result = true;
        }
        return result;
    }

    //=========Leet 3: Tính tổng của các số la mã trong chuỗi ========================================
    public static int romanToInt(String s) {
        int finalNum = 0;
        Map<Character, Integer> mapOfRomani = new HashMap<>();
        mapOfRomani.put('I', 1);
        mapOfRomani.put('V', 5);
        mapOfRomani.put('X', 10);
        mapOfRomani.put('L', 50);
        mapOfRomani.put('C', 100);
        mapOfRomani.put('D', 500);
        mapOfRomani.put('M', 1000);
        for (int i = 0; i < s.length(); i++) {
//            char currentChar = s[i];
            if (i < s.length() - 1 && mapOfRomani.get(s.charAt(i)) < mapOfRomani.get(s.charAt(i + 1))) {
                finalNum -= mapOfRomani.get(s.charAt(i));
            } else {
                finalNum += mapOfRomani.get(s.charAt(i));
            }
        }
        System.out.println(finalNum);
        return finalNum;
    }

    //========Leet 4: Lấy ra tiền tố chung dài nhất trong mãng câc chuỗi========================================
    public static String longestCommonPrefix(String[] strs) {
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(result)) {
                result = result.substring(0, result.length() - 1);
                if (result.length() == 0) return "";
            }
        }
        return result;
    }

    //========Leet 5: Kiểm tra valid dấu đóng mở===========================================
    public static boolean isValid(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) return false;
                char currentOpen = (char) stack.peek();
                if ((currentOpen == '(' && s.charAt(i) == ')') || (currentOpen == '{' && s.charAt(i) == '}') || (currentOpen == '[' && s.charAt(i) == ']')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    //=========Leet 6: lấy ra số lượng phần tử duy nhất trong mảng(loaij bor phaanf tuwr trungf lawpj trong )===============================
    public static int removeDuplicates(int[] nums) {
        int result = 1;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] != nums[i + 1]) {
                result += 1;
            }
        }
        if (nums.length == 0){
            return 0;
        }else {
            return result;
        }
    }

    //=======Leet 7: Tìm vị trí từ cần tìm dầu tiên trong chuỗi=======================
    public static int strStr(String haystack, String needle) {
        if (!haystack.contains(needle)) return -1;
        int result = 0;
        for (int i=0; i<haystack.length(); i++){
            if(haystack.substring(i).startsWith(needle)){
               result = i;
               break;
            }
        }
        return result;
    }
    //======Leet 8: Độ dài của từ cuối cùng trong 1 chuỗi==================================
    public static int lengthOfLastWord(String s) {
        int result = 0;
        String[] worlds = s.split(" ");
        String lastWorld = worlds[worlds.length-1];
        result = lastWorld.length();
        return result;
    }

    //=====Leet 9: Tìm vị trí số cần chèn theo thứ tự tăng dần================================
    public static int searchInsert(int[] nums, int target) {
        int result = 0;
        for (int i=0; i<nums.length; i++){
            if(nums[i]<target){
                result = i+1;
            } else if (target > nums[nums.length-1]) {
                result = nums.length+1;
            }
        }
        return result;
    }

    //=====Leet 10: + 1 vào chuỗi chữ số trong mảng===================================
    public static int[] plusOne(int[] digits) {
        BigInteger digitNumber = new BigInteger(Integer.toString(digits[0])) ;
        for (int i=1; i<digits.length; i++){
            digitNumber = digitNumber.multiply(BigInteger.TEN).add(BigInteger.valueOf(digits[i]));
        }
        BigInteger finalTotalNumber = digitNumber.add(BigInteger.ONE);
        String finalDigitString = finalTotalNumber.toString();
        int[] result = new int[finalDigitString.length()];
        for (int i=0; i<finalDigitString.length(); i++){
            result[i] = Integer.parseInt(finalDigitString.charAt(i)+ "") ;
        }
        return result;
    }

    //======Leet 11:Cộng số nhị phân====================================================
    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            result.insert(0, sum % 2);
            carry = sum / 2;
        }

        return result.toString();
    }
    public static void decToBin(int number) {
        if(number == 0)
            return ;
        decToBin(number / 2);
        System.out.print(number % 2);
    }

    //======Leet 12: căn bật 2 làm tròn===========================================
    public static int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

    //=========Leet 13: giải thuật leo cầu thang=================================
    public static int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int firstStep = 1;
        int secondStep = 2;
        int currentStep = 0;
        for(int i=3; i<=n; i++){
            currentStep = firstStep + secondStep;
            firstStep = secondStep;
            secondStep = currentStep;
        }
        return secondStep;
    }

    //=====Leet 14: nối kết hợp 2 mảng===============================================
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        for (int i=0; i<m; i++){
            result[i] = nums1[i];
        }
        for (int i=0; i<n; i++){
            result[m + i] = nums2[i];
        }
        for (int i = 0; i < result.length - 1; i++) {
            for (int j = 0; j < result.length - 1 - i; j++) {
                if (result[j] > result[j + 1]) {
                    int temp = result[j];
                    result[j] = result[j + 1];
                    result[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(result));
        for(int i=0; i<result.length; i++){
            nums1[i] = result[i];
        }
        System.out.println(Arrays.toString(nums1));
        return nums1;
    }

    //====Leet 15: Tam giác Pascal=====================================
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(1)));
        for (int i=2; i<=numRows; i++){
            List<Integer> preRow = result.get(i-2);
            List<Integer> childList = new ArrayList<>();
            childList.add(1);
            for (int j=1; j<=preRow.size()-1; j++){
                childList.add(preRow.get(j-1) + preRow.get(j));
            }
            childList.add(1);
            result.add(childList);
        }
        return result;
    }

    //======Leet 16: Tam giác Pascal 2 (lần này chỉ lấy mnagr của số dòng nhận vào ko lấy all)=================
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        pascalTriangle.add(Arrays.asList(1));
        for (int i=1; i<=rowIndex; i++){
            List<Integer> preChildList = pascalTriangle.get(i-1);
            List<Integer> currentChildList = new ArrayList<>();
            currentChildList.add(1);
            for (int j=1; j<preChildList.size(); j++){
                currentChildList.add(preChildList.get(j-1) + preChildList.get(j));
            }
            currentChildList.add(1);
            pascalTriangle.add(currentChildList);
        }
        result = pascalTriangle.get(rowIndex);
        return result;
    }

    //======Leet 17: Tính thời gian tốt nhất để mua và bán Stock và trả về doanh thu ======================
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i=0; i<prices.length; i++){
           if (prices[i] < minPrice){
               minPrice = prices[i];
           } else if (prices[i] - minPrice > maxProfit) {
               maxProfit = prices[i] - minPrice;
           }
        }
        return maxProfit;
    }

    //=======Leet 18: Kiểm tra đối xứng của chuỗi====================================
    public static boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[\\W_]+", "").toLowerCase();

        if (cleaned.length() <= 1) return true;

        int len = cleaned.length();
        String firstHalf = cleaned.substring(0, len / 2);
        String secondHalf = cleaned.substring((len + 1) / 2);

        String reversedSecond = new StringBuilder(secondHalf).reverse().toString();

        return firstHalf.equals(reversedSecond);
    }

    //=====Leet 19: Tìm ra số chỉ xuất hiện 1 lần trong mảng========================
    public static int singleNumber(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++){
            if (!set.add(nums[i])){
                set.remove(nums[i]);
            }
        }
        for (int num : set) {
            result = num;
        }
        return result;
    }

    //=====Leet 20: Đổi  chuỗi chữ cột ễcl sang số tương ứng (A->Z = 1->26, AA=27,....)==========
    public static String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            char letter = (char) ('A' + (columnNumber % 26));
            result.insert(0, letter);
            columnNumber /= 26;
        }
        return result.toString();
    }

    //=====Leet 21: Đảo ngược lêt 20 từ chuỗi ra số===========
    public static int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            int value = c - 'A' + 1;
            result = result * 26 + value;
        }
        return result;
    }

    //======Leet 22: Đảo ngược số hệ 16 sang nhị phân và đổi lại hệ 16===========
    public static int reverseBits(int n) {
        int result = 0;
        for (int i=0; i<32; i++){
            int lastBit = n & 1;
            result <<= 1;
            result |= lastBit;
            n >>= 1;
        }
        return result;
    }

    //====Leet 23: Đếm số lượng bit 1 của số nhị phân=============================
    public static int hammingWeight(int n) {
        int result = 0;
        for (int i=0; i<32; i++){
            int lastBit = n & 1;
            if (lastBit == 1) result += 1;
            n >>= 1;
        }
        return result;
    }

    //======Leet 24: Kiểm tra xem 1 số có phải là số happy ko( bình phương tổng các chữ số trong số =1)=====================
    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            int total = 0;
            while (n > 0) {
                int digit = n % 10;
                total += digit * digit;
                n /= 10;
            }
            n = total;
        }
        return n == 1;
    }

    //====Leet 25: Kiểm tra chuỗi ánh xa===============================
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap();
        Map<Character, Character> revertMap = new HashMap();
        for (int i=0; i<s.length(); i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (!map.containsKey(cs) && !revertMap.containsKey(ct)){
                map.put(cs, ct);
                revertMap.put(ct,cs);
            }else{
                if (!map.containsKey(cs) || map.get(cs) != ct) return false;
                if (!revertMap.containsKey(ct) || revertMap.get(ct) != cs) return false;
            }
        }
        return true;
    }

    //====Leet 26: Kiểm tra mảng có trùng lặp dữ liệu======================
    public static boolean containsDuplicate(int[] nums) {
        boolean result = false;
        Arrays.sort(nums);
        for (int i=0; i<nums.length-1; i++){
            if (nums[i] == nums [i+1]) return true;
        }
        return result;
    }

    //====Leet 27: Kiểm tra trùng lặp data trong mảng kèm ĐK abs(2 vị trí) <= target===========
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean result = false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            if (map.containsKey(nums[i])){
                int preIndex = map.get(nums[i]);
                if (Math.abs(i-preIndex) <= k) return true;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    //====Leet 28: Taoj ra danh sách range liên tục của 1 mảng=================
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i=0; i<nums.length; i++){
            String child = "";
            int nextNum = nums[i+1];
            result.add(child);
        }
        return result;
    }
    public boolean isPowerOfTwo(int n) {
        if (Math.log(n) % Math.log(2) == 0) return true;
        return false;
    }
    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;
//        twoSum(nums, target);

//        isPalindrome(121);

//        romanToInt("MCMXCIV");

//        String[] strs ={"flower","flow","flight"};
//        System.out.println(longestCommonPrefix(strs));

//        System.out.println(isValid("(]"));

//        int[] nums ={1,1,2};
//        System.out.println(removeDuplicates(nums));

//        System.out.println(strStr("leetcode", "leeto"));
//        System.out.println(lengthOfLastWord("Hello World   "));

//        int[] nums ={1,3,5,6};
//        System.out.println(searchInsert(nums, 7));

//        int[] digits = {9,8,7,6,5,4,3,2,1,0};
//        System.out.println(Arrays.toString(plusOne(digits)));

//        System.out.println(addBinary("1010", "1011"));

//        System.out.println(mySqrt(8));

//        System.out.println(climbStairs(3));

//        int[] num1 = {1,2,3,0,0,0};
//        int[] num2 = {2,5,6};
//        merge(num1, 3, num2, 3);

//        System.out.println(generate(5));

//        System.out.println(getRow(3));

//        int[] prices = {2,4,1};
//        System.out.println(maxProfit(prices));

//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

//        int[] nums = {2,2,1};
//        System.out.println(singleNumber(nums));

//        System.out.println(convertToTitle(28));

//        System.out.println(titleToNumber("ZY"));

//        System.out.println(reverseBits(43261596));

//        System.out.println(hammingWeight(11));

//        System.out.println(isHappy(19));

//        System.out.println(isIsomorphic("egg","add"));

//        int[] nums ={1,2,3,1};
//        System.out.println(containsDuplicate(nums));

        int[] nums = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(nums, 2));
    }

}