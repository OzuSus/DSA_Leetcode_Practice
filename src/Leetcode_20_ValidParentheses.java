import java.util.Stack;

public class Leetcode_20_ValidParentheses {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)== '(' || s.charAt(i)== '{' || s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else {
                if (stack.empty()) return false;
                char currenOpen = (char)stack.peek();
                if ((currenOpen=='(' && s.charAt(i)==')') ||
                    (currenOpen=='{' && s.charAt(i)=='}') ||
                    (currenOpen=='[' && s.charAt(i)==']'))
                {
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        if (stack.empty()){
            return true;
        }else {
            return false;
        }
    }
}
