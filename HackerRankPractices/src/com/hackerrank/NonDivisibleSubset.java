package com.hackerrank;

/*
 Given a set, , of  integers, print the size of a maximal subset, , of  where the sum of any  numbers in are not evenly divisible by .

Input Format

The first line contains  space-separated integers,  and , respectively. 
The second line contains  space-separated integers (we'll refer to the  value as ) describing the unique values of the set.

Constraints

All of the given numbers are distinct.
Output Format

Print the size of the largest possible subset ().

Sample Input

4 3
1 7 2 4
Sample Output

3
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class NonDivisibleSubset {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}

		int maxSubsetSize = findLargestNonDivisibleSubset(k, a);

		System.out.println(maxSubsetSize);
	}

	private static int findLargestNonDivisibleSubset(int k, int[] a) {
		Set<Set<Integer>> subSets = getAllSubsets(a);

		int maxSubsetSize = 0;
		Iterator<Set<Integer>> subSetsItr = subSets.iterator();
		while (subSetsItr.hasNext()) {
			Set<Integer> subSet = subSetsItr.next();
			if ((subSet.size() > 2) && (subSet.size() > maxSubsetSize)) {
				boolean nonDivisibleSubset = true;
				Integer[] subSetArr = subSet.toArray(new Integer[subSet.size()]);
				for (int i = 0; i < subSetArr.length; i++) {
					for (int j = i + 1; j < subSetArr.length; j++) {
						if ((subSetArr[i] + subSetArr[j]) % k == 0) {
							nonDivisibleSubset = false;
						}
					}
				}

				if (nonDivisibleSubset) {
					maxSubsetSize = subSet.size();
				}
			}
		}
		return maxSubsetSize;
	}

	private static Set<Set<Integer>> getAllSubsets(int[] aSet) {

		int noOfSubsets = 1 << aSet.length;
		Set<Set<Integer>> superSet = new HashSet<Set<Integer>>();

		for (int i = 0; i < noOfSubsets; i++)

		{
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
