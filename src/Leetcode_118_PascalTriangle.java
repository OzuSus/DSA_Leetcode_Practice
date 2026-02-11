import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_118_PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result= new ArrayList<>();
        result.add(Arrays.asList(1));
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
}
