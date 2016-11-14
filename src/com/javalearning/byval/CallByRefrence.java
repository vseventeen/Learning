package com.javalearning.byval;
/**
 * ���ô��ݣ����ݵ������õĸ�����ָ������õ��ڴ��ַ��
 *          ��һָ������õĶ������仯���ᵼ�¸ö���ı仯��
 *          
 * String�� ��final���Σ�Ϊ���ɱ��ࡣ
 *         �ı�������ʵ�����ǽ���ǰ����ָ��������ַ
 *
 */
public class CallByRefrence {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Hello");
		System.out.println("Before Change: " + sb);
		changeString(sb);
		System.out.println("After Change: " + sb);
		
		System.out.println("=================");
		String str = "'String' is modified with 'final'.";
		System.out.println("Before Change: " + str);
		changeString(str);
		System.out.println("After Change: " + str);

	}
	
	static void changeString(StringBuffer sb) {
		sb.append(" World");
		System.out.println("In Processing: " + sb );
	}
	
	static void changeString(String str) {
		str = "string cannot be changed.";
		System.out.println("In Processing: " + str);
	}

}
