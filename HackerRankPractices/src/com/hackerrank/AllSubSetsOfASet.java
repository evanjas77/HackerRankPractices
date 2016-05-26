package com.hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AllSubSetsOfASet {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}

		System.out.println(getAllSubsets(a));
	}

	public static Set<Set<Integer>> getAllSubsets(int[] aSet) {

		int noOfSubsets = 1 << aSet.length;
		Set<Set<Integer>> superSet = new HashSet<Set<Integer>>();

		for (int i = 0; i < noOfSubsets; i++) {
			int mask = 1;
			Set<Integer> iSet = new HashSet<Integer>();

			for (int k = 0; k < aSet.length; k++) {
				if ((i & mask) != 0) {
					iSet.add(aSet[k]);
				}
				mask = mask << 1;
			}

			superSet.add(iSet);
		}

		return superSet;

	}

}
