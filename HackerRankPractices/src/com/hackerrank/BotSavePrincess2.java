package com.hackerrank;
import java.util.Scanner;

public class BotSavePrincess2 {

	public static void main(String[] args) {

		/**
		 * 5 2 3 ----- ----- p--m- ----- -----
		 * 
		 * LEFT
		 */

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int pX = 0;
		int pY = 0;
		int mX = in.nextInt();
		int mY = in.nextInt();
		for (int i = 0; i < n; i++) {
			String matrixRow = in.next();
			if (matrixRow.indexOf("p") > -1) {
				pX = i;
				pY = matrixRow.indexOf("p");
			}
			// if (matrixRow.indexOf("m") > -1) {
			// mX = i;
			// mY = matrixRow.indexOf("m");
			// }
		}
		System.out.println(firstStepDirection(pX, pY, mX, mY));
	}

	private static String firstStepDirection(int pX, int pY, int mX, int mY) {

		int x = pX - mX;
		int y = pY - mY;
		if (x > 0)
			return "DOWN";
		else if (x < 0)
			return "UP";

		if (y > 0)
			return "RIGHT";
		else if (y < 0)
			return "LEFT";
		return "";
	}

}
