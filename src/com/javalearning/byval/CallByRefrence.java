package com.javalearning.byval;
/**
 * 引用传递：传递的是引用的副本，指向该引用的内存地址。
 *          任一指向该引用的对象发生变化都会导致该对象的变化。
 *          
 * String： 被final修饰，为不可变类。
 *         改变其内容实际上是将当前对象指向其他地址
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
