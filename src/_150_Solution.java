import java.util.Stack;

/**
 * Created by chenjunxing ON 2020-07-14 15:15.
 */
public class _150_Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                int b = Integer.valueOf(stack.pop());
                int a = Integer.valueOf(stack.pop());

                stack.push(a - b);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int b = Integer.valueOf(stack.pop());
                int a = Integer.valueOf(stack.pop());

                stack.push(a / b);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }
}
