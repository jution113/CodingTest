import java.util.*;
import java.io.*;

class Solution {
    private static final int T = 10;
	public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
        for(int t = 1; t <= T; t++) {
            int expressionLen = Integer.parseInt(br.readLine());
            String infixExpression = br.readLine();
            String postfixExpression = makePostfixExpression(infixExpression, expressionLen);
            int answer = calculatePostfixExpression(postfixExpression);
            
			sb.append("#" + t + " " + answer + "\n");
		}
        
        System.out.println(sb.toString());
	}
    
    private static String makePostfixExpression(String infixExpression, int expressionLen) {
        ArrayDeque<Character> operators = new ArrayDeque<> ();
        StringBuilder postfixExpression = new StringBuilder();
        
        for (char c : infixExpression.toCharArray()) {
            switch (c) {
                case '(':
                    operators.push(c);
                    break;
                case ')':
                    while (operators.peek() != '(') {
                        postfixExpression.append(operators.pop() + " ");
                    }
                    operators.pop();
                    break;
                case '*':
                    while (!operators.isEmpty() && operators.peek() == c) {
                        	postfixExpression.append(operators.pop() + " ");
                    }
                    operators.push(c);
                    break;
                case '+':
                    while (!operators.isEmpty() && (operators.peek() != '(')) {
	                    postfixExpression.append(operators.pop() + " ");
                    }
                    operators.push(c);
                    break;
                default:
                    postfixExpression.append(c + " ");
            }
        }

        while (!operators.isEmpty()) {
            postfixExpression.append(operators.pop() + " ");
        }
        
        return postfixExpression.toString();
    }
    
    private static int calculatePostfixExpression(String postfixExpression) {
        ArrayDeque<Integer> result = new ArrayDeque<> ();
        
        for (String str : postfixExpression.split(" ")) {
            switch (str) {
                case "+":
                    result.push(result.pop() + result.pop());
                    break;
                case "*":
                    result.push(result.pop() * result.pop());
                    break;
                default:
                    result.push(Integer.parseInt(str));
            }
        }
        
        return result.pop();
    }
}