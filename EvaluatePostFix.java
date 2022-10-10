package Stack;

import java.util.Stack;

public class EvaluatePostFix {

	public static void main(String[] args) {
		String s[] = {"1","2","3","*","+","5","-"};
		System.out.println(expressionEvaluation(s));
        
	}
	public static int expressionEvaluation(String [] tokens) {
    Stack<Integer> stack = new Stack<>();	
    for(String token : tokens) {
    	if(token.equals("+")) {
    		int op2 = stack.pop();
    		int op1 = stack.pop();
    		int result = op1+op2;
    		stack.push(result);
    	}
    	else if(token.equals("-")) {
    		int op2 = stack.pop();
    		int op1 = stack.pop();
    		int result = op1-op2;
    		stack.push(result);
    	}
    	else if(token.equals("*")) {
    		int op2 = stack.pop();
    		int op1 = stack.pop();
    		int result = op1*op2;
    		stack.push(result);
    	}
    	else if(token.equals("/")) {
    		int op2 = stack.pop();
    		int op1 = stack.pop();
    		int result = op1/op2;
    		stack.push(result);
    	}
    	else {
    		stack.push(Integer.parseInt(token));
    	}
    	
    }
    return stack.pop();
	}

}
