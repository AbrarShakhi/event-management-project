package com.event.management;

public class CheckChar {
	public static boolean isDigit(char ch) {
		return ch >= '0' && ch <= '9';
	}

	public static boolean isUpperCase(char ch) {
		return ch >= 'A' && ch <= 'Z';
	}

	public static boolean isLowerCase(char ch) {
		return ch >= 'a' && ch <= 'z';
	}

	public static boolean isSpecial(char ch) {
		return ch == '!' || ch == '@' || ch == '#' || ch == '$' || ch == '%' || ch == '^' || ch == '&' || ch == '*';
	}
}
