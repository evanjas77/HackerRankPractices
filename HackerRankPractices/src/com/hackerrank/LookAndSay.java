package com.hackerrank;

import java.util.Scanner;

public class LookAndSay {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.next();
		
		System.out.println(lookAndSay(input));
	}

	private static String lookAndSay(String input) {

		StringBuilder sbForOutput = new StringBuilder("");
		if(input != null && input.length() > 0){
			String[] inputArr = input.split("");
			String currChar = inputArr[0];
			Integer currCharCounter = 0;
			for(int i=0; i<inputArr.length; i++){
				if(inputArr[i].equalsIgnoreCase(currChar)){
					currCharCounter++;
				} else{
					sbForOutput.append(currCharCounter + currChar);
					currChar = inputArr[i];
					currCharCounter = 1;
				}
			}
			//Append the last sequence
			sbForOutput.append(currCharCounter + currChar);
						
		}
		return sbForOutput.toString();
	}

}
