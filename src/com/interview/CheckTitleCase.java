package com.interview;

import java.util.Scanner;

/**
 * 题目：输入字符串，判断字符串是否首字母大写其余小写 是返回ture，否则返回false
 */

// 预备知识：a~z的ASCII为97~122，A~Z为65~90

public class CheckTitleCase {
	private static Scanner s;

	public static void main(String[] args) {
		boolean flag = false;
		s = new Scanner(System.in);
		// 获取字符串
		String str = s.next();
		// 若首字母大写，则继续判断
		if (str.charAt(0) > 64 && str.charAt(0) < 91) {
			for (int i = 1; i < str.length(); i++) {
				// 判断剩余是否不为小写字母
				if (str.charAt(i) < 97 || str.charAt(i) > 122) {
					flag = false;
					break;
				} else flag = true;
			}
			// 循环完毕，符合条件
			if (flag) {
				System.out.println(true);
			}
		} else {
			System.out.println(false);
		}
		
	}

}
