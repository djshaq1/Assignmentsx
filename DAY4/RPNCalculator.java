package ssa;

import java.util.Stack;

public class RPNCalculator {
	public static void main(String[] args) {
		Stack<Integer> results = new Stack<Integer>(); // creation of stack. named it results
		char[] problem = new char[] { '8', '2', '/', '9', '*','1','-','7','/' };
		for (int i = 0; i < problem.length; i++) {
			char ch = problem[i];

			int val = Character.getNumericValue(ch);

			if (val != -1) {
				results.push(val);
			} else {
				int p2 = (int)results.pop();
				int p1 = (int)results.pop();
				switch (ch) {
				case '+':
					results.push(p1 + p2);
					break;
				case '-':
					results.push(p1 - p2);
					break;
				case '*':
					results.push(p1 * p2);
					break;
				case '/':
					results.push(p1 / p2);
					break;
				}
			}

		}
		System.out.println(results.pop());
	}
}