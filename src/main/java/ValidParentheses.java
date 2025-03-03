import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {

        // initialize stack for checking valid parentheses
        Stack<Character> stack = new Stack<>();

        // if string length is odd, immediately return false because impossible to have valid parentheses
        if (s.length() % 2 == 0) {
            // iterate through all chars in string
            for (char c : s.toCharArray()) {
                // if opening bracket is encountered, push corresponding closing bracket to stack
                if (c == '(') {
                    stack.push(')');
                } else if (c == '{') {
                    stack.push('}');
                } else if (c == '[') {
                    stack.push(']');
                // if closing bracket is encountered:
                // 1. stack is empty -> there is a closing bracket without an opening bracket, return false
                // 2. stack pop does not match -> incorrect closing bracket, return false
                } else if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        } else {
            return false;
        }
        // empty stack means all brackets are properly closed, return true
        // non-empty stack means
        return stack.isEmpty();
    }
}
