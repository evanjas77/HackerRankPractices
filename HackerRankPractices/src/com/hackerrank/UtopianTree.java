package com.hackerrank;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class UtopianTree {

	public static void main(String[] args) {

		int tc;
		List<Integer> op = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		tc = in.nextInt();

		while (tc != 0) {
			int N = in.nextInt();
			int n = 1;
			for (int i = 1; i <= N; i++) {
				n = uTreeHeight(n, i);
			}
			op.add(n);
			tc--;
		}
		for (int j = 0; j < op.size(); j++) {
			System.out.println(op.get(j));
		}
	}

	private static int uTreeHeight(int n, int N) {
		int height = n;
		if (N <= 0) {
			height = n;
		} else if (N % 2 == 1) {
			height = n + n;
		} else if (N % 2 == 0) {
			height = n + 1;
		}
		return height;
	}

}
