package com.interview;

import java.util.Scanner;

/**
 * ��Ŀ�������д��ĸ��������5λ��Ӧ��Сд��ĸ
 *       �涨z����һλΪa��
 *       ������A�����ӦΪf������W�����b��
 */

// Ԥ��֪ʶ��a~z��ASCIIΪ97~122��A~ZΪ65~90
// ��򵥵Ŀ���ʹ��������ʽ

public class StringLower {
	public static void main(String[] args) {
		// �Ӽ��̻�ȡ����
		Scanner s = new Scanner(System.in);
		// ���������ĸתΪASCII��
		byte ascii = (byte)((s.next()).charAt(0));
		// ��ʹ��������ʽ��s.next().match("^[AU]{1}$")
		if(ascii <= 85 && ascii > 64) { // A~U
			// ��Сд���32���ټ�5λλ��
			System.out.println((char)(ascii + 37));
		} else if (ascii > 85 && ascii < 91) { // V~Z
			// V��Aλ��-21����32ת��ΪСд
			System.out.println((char)(ascii + 11));
		} else {
			System.out.println("Input Error.");
		}
		s.close();
	}

}
