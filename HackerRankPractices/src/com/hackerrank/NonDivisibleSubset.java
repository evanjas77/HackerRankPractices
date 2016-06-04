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

		int maxSubsetSize = findLargestNonDivisibleSubset(a, k);

		System.out.println(maxSubsetSize);
	}

	private static int findLargestNonDivisibleSubset(int[] aSet, int k) {

		int maxSubsetSize = 0;
		int noOfSubsets = 1 << aSet.length;

		for (int i = noOfSubsets - 1; i >= 0; i--)

		{
			int mask = 1;
			Set<Integer> iSet = new HashSet<Integer>();

			for (int m = 0; m < aSet.length; m++) {
				if ((i & mask) != 0) {
					iSet.add(aSet[m]);
				}
				mask = mask << 1;
			}

			int subsetSize = iSet.size();
			if (subsetSize > maxSubsetSize) {
				if (isNonDivisibleSubSet(k, iSet)) {
					maxSubsetSize = subsetSize;
					break;
				}
			}
		}

		return maxSubsetSize;
	}

	private static boolean isNonDivisibleSubSet(int k, Set<Integer> iSet) {
		boolean nonDivisibleSubset = true;
		Integer[] subSetArr = iSet.toArray(new Integer[iSet.size()]);
		for (int idx = 0; idx < subSetArr.length; idx++) {
			for (int j = idx + 1; j < subSetArr.length; j++) {
				if ((subSetArr[idx] + subSetArr[j]) % k == 0) {
					nonDivisibleSubset = false;
					break;
				}
			}
			if (!nonDivisibleSubset) {
				break;
			}
		}
		return nonDivisibleSubset;
	}

}
