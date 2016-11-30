package com.interview;

import java.util.Stack;

/**
 * 题目：反转字符串
 */

public class StringReverse {
	public static void main(String[] args) {
		System.out.println(reverse5("abcd ef g"));
	}
	
	public static String reverse1(String string) {
		// 新建一个长度为string.length()的StringBuffer对象
		StringBuffer sb = new StringBuffer(string.length());
		// char[] c = new char[string.length()];
		// 遍历整个字符串，反向添加到StringBuffer对象中
		for (int i = 0; i < string.length(); i++) {
			sb.append(string.charAt(string.length() - 1 - i));
			// c[i] = string.charAt(string.length() - 1 - i);
		}
		return sb.toString();
		//return new String(c);
	}
	
	public static String reverse2(String string) {
		// 将String对象转化为char[]对象
		char[] tmp  = string.toCharArray();
		// 首尾交换
		for (int i = 0; i < tmp.length / 2; i++) {
			char t = tmp[i];
			tmp[i] = tmp[tmp.length-1-i];
			tmp[tmp.length-1-i] = t;
		}
		return new String(tmp);
	}
	
	public static String reverse3(String string) {
		char[] tmp  = string.toCharArray();
		// 使用异或进行交换
		int len = tmp.length - 1;
		for (int i = 0; i < len; i++, len--) {
			tmp[i] ^= tmp[len];
			tmp[len] ^= tmp[i];
			tmp[i] ^= tmp[len];
		}
		return new String(tmp);
	}
	
	public static String reverse4(String string) {
		// 使用集合框架的堆栈类
		Stack<Character> stack = new Stack<>();
		// 压栈
		for (int i = 0; i < string.length(); i++) {
			stack.push(string.charAt(i));
		}
		// 新建char[]数组，用于接受stack的出栈元素
		char[] tmp = new char[string.length()];
		// 出栈
		for (int i = 0; i < string.length(); i++) {
			tmp[i] = stack.pop();
		}
		return new String(tmp);
	}
	
	public static String reverse5(String string) {
		// 分治，并归
		if (string.length() == 1) {
			return string;
		}
		
		String left = string.substring(0, string.length() / 2);
		String right = string.substring(string.length() / 2, string.length());
		
		return reverse5(right) + reverse1(left);
	}
	
	
}


