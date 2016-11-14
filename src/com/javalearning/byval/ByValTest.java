package com.javalearning.byval;

public class ByValTest {
	public static void main(String[] args) {
		ByValTest t = new ByValTest();
		t.first();
	}
	
	public void first() {
		int i = 5;
		Value v = new Value();
		System.out.println("01.新建一个Value对象：v.i = " + v.i); // 15
		System.out.println("02.该Value对象hash值：" + v.hashCode());
		v.i = 25;
		System.out.println("03.将该Value的i改变为" + v.i); // 25
		System.out.println("04.改变后Value对象hash值:" + v.hashCode());
		second(v, i); // v.i = 25, i = 5
		System.out.println("10.引用结束后该Value对象的hash值：" + v.hashCode());
		System.out.println(v.i);
	
	}
	
	public void second(Value v, int i) {
		System.out.println("05.引用副本中Value对象hash值：" + v.hashCode());
		i = 0;
		v.i = 20;
		System.out.println("06.将引用副本中Value对象的i改变为" + v.i);
		System.out.println("07.改变后引用副本中Value对象hash值：" + v.hashCode());
		Value value = new Value();
		v = value; // 此时
		System.out.println("08.将引用副本指向一个新的Value对象的hash值" + v.hashCode());
		System.out.println("09.此时引用副本中i值：v.i = " + v.i);
		
	}

}

class Value {
	public int i = 15;
}
