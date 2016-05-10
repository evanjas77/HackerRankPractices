package com.hackerrank;
import java.util.Scanner;

public class BotSavePrincess {

	public static void main(String[] args) {

		/**
		 * INPUT 3 --- -m- p--
		 * 
		 * OUTPUT DOWN LEFT
		 */

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int pX = 0;
		int pY = 0;
		int mX = 0;
		int mY = 0;
		for (int i = 0; i < n; i++) {
			String matrixRow = in.next();
			if (matrixRow.indexOf("p") > -1) {
				pX = i;
				pY = matrixRow.indexOf("p");
			}
			if (matrixRow.indexOf("m") > -1) {
				mX = i;
				mY = matrixRow.indexOf("m");
			}
		}
		System.out.println(direction(pX, pY, mX, mY));
	}

	private static String direction(int pX, int pY, int mX, int mY) {

		int x = pX - mX;
		int y = pY - mY;
		StringBuilder direction = new StringBuilder();
		while (x < pX) {
			if (x > 0)
				direction.append("DOWN\n");
			else if (x < 0)
				direction.append("UP\n");
			x++;
		}

		while (y < pY) {
			if (y > 0)
				direction.append("RIGHT\n");
			else if (y < 0)
				direction.append("LEFT\n");
			y++;
		}

		return direction.toString();

	}

}
