package com.interview;

import java.util.Scanner;

/**
 * ��Ŀ�������ַ������ж��ַ����Ƿ�����ĸ��д����Сд �Ƿ���ture�����򷵻�false
 */

// Ԥ��֪ʶ��a~z��ASCIIΪ97~122��A~ZΪ65~90

public class CheckTitleCase {
	private static Scanner s;

	public static void main(String[] args) {
		boolean flag = false;
		s = new Scanner(System.in);
		// ��ȡ�ַ���
		String str = s.next();
		// ������ĸ��д��������ж�
		if (str.charAt(0) > 64 && str.charAt(0) < 91) {
			for (int i = 1; i < str.length(); i++) {
				// �ж�ʣ���Ƿ�ΪСд��ĸ
				if (str.charAt(i) < 97 || str.charAt(i) > 122) {
					flag = false;
					break;
				} else flag = true;
			}
			// ѭ����ϣ���������
			if (flag) {
				System.out.println(true);
			}
		} else {
			System.out.println(false);
		}
		
	}

}
