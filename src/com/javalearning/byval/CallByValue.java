package com.javalearning.byval;

/**
 * ֵ���ݣ����ڻ������ͱ���������ֵ�ĸ���
 *         �����ı仯���ᵼ������仯 
 *
 */
public class CallByValue {

	public static void main(String[] args) {
		int i = 5;
		System.out.println("before Change: " + i);
		changeValue(i);
		System.out.println("After Change: " + i);
		

	}
	
	static void changeValue(int i) {
		i = 666;
		System.out.println("In Processing: " + i);
	}

}
