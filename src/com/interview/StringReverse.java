package com.interview;

import java.util.Stack;

/**
 * ��Ŀ����ת�ַ���
 */

public class StringReverse {
	public static void main(String[] args) {
		System.out.println(reverse5("abcd ef g"));
	}
	
	public static String reverse1(String string) {
		// �½�һ������Ϊstring.length()��StringBuffer����
		StringBuffer sb = new StringBuffer(string.length());
		// char[] c = new char[string.length()];
		// ���������ַ�����������ӵ�StringBuffer������
		for (int i = 0; i < string.length(); i++) {
			sb.append(string.charAt(string.length() - 1 - i));
			// c[i] = string.charAt(string.length() - 1 - i);
		}
		return sb.toString();
		//return new String(c);
	}
	
	public static String reverse2(String string) {
		// ��String����ת��Ϊchar[]����
		char[] tmp  = string.toCharArray();
		// ��β����
		for (int i = 0; i < tmp.length / 2; i++) {
			char t = tmp[i];
			tmp[i] = tmp[tmp.length-1-i];
			tmp[tmp.length-1-i] = t;
		}
		return new String(tmp);
	}
	
	public static String reverse3(String string) {
		char[] tmp  = string.toCharArray();
		// ʹ�������н���
		int len = tmp.length - 1;
		for (int i = 0; i < len; i++, len--) {
			tmp[i] ^= tmp[len];
			tmp[len] ^= tmp[i];
			tmp[i] ^= tmp[len];
		}
		return new String(tmp);
	}
	
	public static String reverse4(String string) {
		// ʹ�ü��Ͽ�ܵĶ�ջ��
		Stack<Character> stack = new Stack<>();
		// ѹջ
		for (int i = 0; i < string.length(); i++) {
			stack.push(string.charAt(i));
		}
		// �½�char[]���飬���ڽ���stack�ĳ�ջԪ��
		char[] tmp = new char[string.length()];
		// ��ջ
		for (int i = 0; i < string.length(); i++) {
			tmp[i] = stack.pop();
		}
		return new String(tmp);
	}
	
	public static String reverse5(String string) {
		// ���Σ�����
		if (string.length() == 1) {
			return string;
		}
		
		String left = string.substring(0, string.length() / 2);
		String right = string.substring(string.length() / 2, string.length());
		
		return reverse5(right) + reverse1(left);
	}
	
	
}


