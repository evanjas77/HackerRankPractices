package com.hackerrank;

import java.util.Arrays;
import java.util.Stack;

public class MatchingBraces {

	public static void main(String[] args) {
		String[] input = { "{}{}()", "({[()]}", "{(]){}","}][{" };
		System.out.println(Arrays.toString(Braces(input)));
	}

	static String[] Braces(String[] values) {
		String[] result = new String[values.length];
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < values.length; i++) {

			String contents = values[i];
			try {
				for (int iChar = 0; iChar < contents.length(); iChar++) {
					char brace = contents.charAt(iChar);
					if (brace == '{' || brace == '[' || brace == '(') {
						stack.push(brace);
					} else if (brace == '}' || brace == ']' || brace == ')') {
						char poppedVal = stack.pop();
						if (!((poppedVal == '{' && brace == '}') || (poppedVal == '(' && brace == ')')
								|| (poppedVal == '[' && brace == ']'))) {
							throw new Exception("Mismatch!");
						}
					}
				}
				if (stack.isEmpty()) {
					result[i] = "YES";
				} else {
					result[i] = "NO";
				}

			} catch (Exception e) {
				result[i] = "NO";
			}
		}
		return result;

	}
}