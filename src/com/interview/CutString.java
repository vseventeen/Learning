package com.interview;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 题目：按照字节截取字符串
 * 思路：因为字符串可能包含中文，故不能使用直接substring来截取
 *       依然使用substring方法，计算字节对应的字符个数：
 *       判断字节码是否大于0，大于则意味着不是中文，字符数加一
 *       小于则意味着该字符为中文，占两个字节，需连续两个都符合条件才加一
 *       （输入字节没有夹在中文锁对应的两个字节中间时）
 *       
 * 
 */
public class CutString {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		/*System.out.println(Arrays.toString("a".getBytes("ascii"))); // 97
		System.out.println(Arrays.toString("a".getBytes("GBK")));
		System.out.println(Arrays.toString("a".getBytes("GB2312")));
		System.out.println(Arrays.toString("a".getBytes("GB18030")));
		System.out.println(Arrays.toString("a".getBytes("ISO-8859-1")));
		System.out.println(Arrays.toString("a".getBytes("UTF-8")));
		System.out.println("==========");
		System.out.println(Arrays.toString("是".getBytes("GBK"))); // -54, -57
		System.out.println(Arrays.toString("是".getBytes("GB2312")));
		System.out.println(Arrays.toString("是".getBytes("GB18030")));
		System.out.println("----------");
		System.out.println(Arrays.toString("是".getBytes("BIG5"))); // -84, 79
		System.out.println(Arrays.toString("是".getBytes("UTF-8"))); // -26, -104, -81
		System.out.println(Arrays.toString("是".getBytes("ISO-8859-1"))); // 63
		System.out.println(Arrays.toString("是".getBytes("ascii"))); // 63
*/	
		String str = "A一BCD二三EFG四";
		System.out.println(cutString(str, 4)); //A一B
		System.out.println(cutString(str, 7)); //A一BCD
		System.out.println(cutString(str, 8)); //A一BCD二
		
	}
	
	public static String cutString(String str, int bytes) {
		
		byte[] buffer = str.getBytes();
		int count = 0;
		for (int i = 0; i < bytes; i++) {
			// 判断是否为中文，且输入的字节个数是否将中文”截断“
			if (buffer[i] < 0 && i + 1 < bytes) {
				count++;
				i++; // 此时为中文，跳过该中文的第二个字节
			} else if (buffer[i] > 0) {
				count++;
			}
		}
		return str.substring(0, count);
	}

}
