package ssa;

import java.util.Stack;

public class RPNCalculator {
	public static void main(String[] args) {
		Stack<Integer> results = new Stack<Integer>();
		char[] problem = new char[] { '1', '2', '+', '6', '+' };
		for (int i = 0; i < problem.length; i++) {
			char ch = problem[i];

			int val = Character.getNumericValue(ch);

			if (val != -1) {
				results.push(val);
			} else {
				switch (ch) {
				case '+':
					results.push(results.pop() + results.pop());
					break;
				case '-':
					results.push(results.pop() - results.pop());
					break;
				case '*':
					results.push(results.pop() * results.pop());
					break;
				case '/':
					results.push(results.pop() / results.pop());
					break;
				}
			}

		}
		System.out.println(results.pop());
	}
}