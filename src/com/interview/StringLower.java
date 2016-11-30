package com.interview;

import java.util.Scanner;

/**
 * 题目：输入大写字母，输出其后5位对应的小写字母
 *       规定z的下一位为a。
 *       如输入A，输出应为f；输入W，输出b。
 */

// 预备知识：a~z的ASCII为97~122，A~Z为65~90
// 最简单的可以使用正则表达式

public class StringLower {
	public static void main(String[] args) {
		// 从键盘获取数据
		Scanner s = new Scanner(System.in);
		// 将输入的字母转为ASCII码
		byte ascii = (byte)((s.next()).charAt(0));
		// 可使用正则表达式：s.next().match("^[AU]{1}$")
		if(ascii <= 85 && ascii > 64) { // A~U
			// 大小写相差32，再加5位位移
			System.out.println((char)(ascii + 37));
		} else if (ascii > 85 && ascii < 91) { // V~Z
			// V到A位移-21，加32转化为小写
			System.out.println((char)(ascii + 11));
		} else {
			System.out.println("Input Error.");
		}
		s.close();
	}

}
