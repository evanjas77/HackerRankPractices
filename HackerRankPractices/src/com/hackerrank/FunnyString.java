package com.hackerrank;
import java.util.Scanner;

public class FunnyString {

	public static void main(String[] args) {
		/*********************
		 * Test Case 0: S="acxz"S="acxz" |c−a|=2=|x−z||c−a|=2=|x−z|
		 * |x−c|=21=|c−x||x−c|=21=|c−x| |z−x|=2=|a−c||z−x|=2=|a−c| As each
		 * comparison is equal, we print FunnyFunny.
		 * 
		 * Test Case 1: S="bcxz"S="bcxz" |c−b|=1|c−b|=1, but |x−z|=2|x−z|=2 At
		 * this point, we stop evaluating SS (as |c−b|≠|x−z||c−b|≠|x−z|) and
		 * print Not FunnyNot Funny.
		 **********************************/
		Scanner in = new Scanner(System.in);
		int numberOfIp = in.nextInt();

		while (numberOfIp != 0) {
			String s = in.next();
			String r = new StringBuilder(s).reverse().toString();
			boolean funny = true;
			for (int i = 1; i < s.length(); i++) {
				int schar = Math.abs(s.charAt(i) - s.charAt(i - 1));
				int rchar = Math.abs(r.charAt(i) - r.charAt(i - 1));
				if (schar != rchar) {
					funny = false;
					break;
				}
			}
			if (!funny) {
				System.out.println("Not Funny");
			} else {
				System.out.println("Funny");
			}
			numberOfIp--;
		}

	}

}
