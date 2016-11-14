package com.javalearning.byval;

/**
 * 值传递：对于基本类型变量，传递值的副本
 *         副本的变化不会导致自身变化 
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
