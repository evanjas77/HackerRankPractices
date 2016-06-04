package com.hackerrank;

public class IPAddressValidation {

	public static void main(String[] args) {
		String pattern = "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
		System.out.println("0.123.123.222".matches(pattern));
	}
}