package com.interview;

public class CheckPalindrome {
	public static void main(String[] args) {
		String str1 = "level";
		System.out.println(isPalindrome(str1));
	}
	
	public static boolean isPalindrome(String string) {
		// �����ַ�������β�Ƚ�
		for (int i = 0; i < string.length() / 2; i++) {
			if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}
