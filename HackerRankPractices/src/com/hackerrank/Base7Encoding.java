package com.hackerrank;

import java.util.Scanner;

/*Complete the function that takes an integer as its argument and returns the encoded string in base 7 using the following encoding rule:
base 10 0 1 2 3 4 5 6
base 7 0 a t l s i N*/

public class Base7Encoding {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		String inputInBase7 = Integer.toString(input, 7);

		String[] base7Encode = { "0", "a", "t", "l", "s", "i", "N" };
		String[] inputInbase7Arr = inputInBase7.split("");

		StringBuilder sbOutput = new StringBuilder();
		for (int i = 0; i < inputInbase7Arr.length; i++) {
			sbOutput.append(base7Encode[Integer.parseInt(inputInbase7Arr[i])]);
		}

		System.out.println(sbOutput.toString());
	}

}
