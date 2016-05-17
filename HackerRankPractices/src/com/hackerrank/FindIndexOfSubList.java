package com.hackerrank;

import java.util.Scanner;

/*
Implement a method 'find' that will find the starting index (zero based) where the second list occurs as a sub-list in the first list. It should return -1 if the sub-list cannot be found. Arguments are always given, not empty.

Sample Input 1
list1 = (1, 2, 3)
list2 = (2, 3)

Sample Output 1
1

Explanation
As second list (2, 3) is sub-list in first list (1, 2, 3) at index 1

Sample Input 2
list1 = (1, 2, 3)
list2 = (3, 2)

Sample Output 2
-1   
 */
public class FindIndexOfSubList {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String input1 = in.nextLine();
		String input2 = in.nextLine();

		// Chop of the braces .. ()
		input1 = input1.substring(1, input1.length() - 1);
		input2 = input2.substring(1, input2.length() - 1);

		int index = input1.indexOf(input2);

		// Count the number of "," before index
		if (index > -1) {
			String commaStr = input1.substring(0, index);
			String[] commaStrArr = commaStr.split(",");
			for (int i = 0; i < commaStrArr.length; i++) {
				index = index - commaStrArr[i].length();
			}
		}

		System.out.println(index);

	}

}
