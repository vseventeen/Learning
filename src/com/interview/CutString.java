package com.interview;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * ��Ŀ�������ֽڽ�ȡ�ַ���
 * ˼·����Ϊ�ַ������ܰ������ģ��ʲ���ʹ��ֱ��substring����ȡ
 *       ��Ȼʹ��substring�����������ֽڶ�Ӧ���ַ�������
 *       �ж��ֽ����Ƿ����0����������ζ�Ų������ģ��ַ�����һ
 *       С������ζ�Ÿ��ַ�Ϊ���ģ�ռ�����ֽڣ����������������������ż�һ
 *       �������ֽ�û�м�����������Ӧ�������ֽ��м�ʱ��
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
		System.out.println(Arrays.toString("��".getBytes("GBK"))); // -54, -57
		System.out.println(Arrays.toString("��".getBytes("GB2312")));
		System.out.println(Arrays.toString("��".getBytes("GB18030")));
		System.out.println("----------");
		System.out.println(Arrays.toString("��".getBytes("BIG5"))); // -84, 79
		System.out.println(Arrays.toString("��".getBytes("UTF-8"))); // -26, -104, -81
		System.out.println(Arrays.toString("��".getBytes("ISO-8859-1"))); // 63
		System.out.println(Arrays.toString("��".getBytes("ascii"))); // 63
*/	
		String str = "AһBCD����EFG��";
		System.out.println(cutString(str, 4)); //AһB
		System.out.println(cutString(str, 7)); //AһBCD
		System.out.println(cutString(str, 8)); //AһBCD��
		
	}
	
	public static String cutString(String str, int bytes) {
		
		byte[] buffer = str.getBytes();
		int count = 0;
		for (int i = 0; i < bytes; i++) {
			// �ж��Ƿ�Ϊ���ģ���������ֽڸ����Ƿ����ġ��ضϡ�
			if (buffer[i] < 0 && i + 1 < bytes) {
				count++;
				i++; // ��ʱΪ���ģ����������ĵĵڶ����ֽ�
			} else if (buffer[i] > 0) {
				count++;
			}
		}
		return str.substring(0, count);
	}

}
