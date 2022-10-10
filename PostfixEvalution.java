import java.util.Stack;

public class PostfixEvalution {
//    static int postfixExp(String s[]) {
//    	Stack<Integer> stack = new Stack<>();
//    	for(String t: s) {
//    		if(t.equals("+")) {
//    			int op1 = stack.pop();
//    			int op2 = stack.pop();
//    			int result = op2+op1;
//    			stack.push(result);
//    		}
//    		else if(t.equals("-")) {
//    			int op1 = stack.pop();
//    			int op2 = stack.pop();
//    			int result = op2-op1;
//    			stack.push(result);
//    		}
//    		else if(t.equals("*")) {
//    			int op1 = stack.pop();
//    			int op2 = stack.pop();
//    			int result = op2*op1;
//    			stack.push(result);
//    		}else if(t.equals("/")) {
//    			int op1 = stack.pop();
//    			int op2 = stack.pop();
//    			int result = op2/op1;
//    			stack.push(result);
//    		}
//    		else {
//    			stack.push(Integer.parseInt(t));
//    		}
//    	}
//    	return stack.pop();
//    }
	static int postfix(String s) {
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i<s.length();i++) {
			if(s.charAt(i) == '+') {
				int op2 = stack.pop();
				int op1 = stack.pop();
				int res = op1+op2;
				stack.push(res);
			}
			else if(s.charAt(i) == '-') {
				int op2 = stack.pop();
				int op1 = stack.pop();
				int res = op1-op2;
				stack.push(res);
			}
			else if(s.charAt(i) == '*') {
				int op2 = stack.pop();
				int op1 = stack.pop();
				int res = op1*op2;
				stack.push(res);
			}
			else if(s.charAt(i) == '/') {
				int op2 = stack.pop();
				int op1 = stack.pop();
				int res = op1/op2;
				stack.push(res);
			}else {
				stack.push(s.charAt(i)-'0');
			}
		}
		
		return stack.pop();
	}
	public static void main(String[] args) {
		String s = "123*+5-"; //{"1","2","3","*","+","5","-"};
		System.out.println(postfix(s));
		
		
	}

}
