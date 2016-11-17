package com.javalearning.byval;

/**
 * Cloneable接口实现浅拷贝
 *  
 * 浅拷贝：对于基本数据类型拷贝一个副本，拷贝对象的改变不会引起自身的变化
 *         对于引用数据类型，拷贝的是对象的内存地址，它的变化会导致原对象的变化
 */

public class ShallowCopy {
	public static void main(String[] args) {
		TestShallow sc1 = new TestShallow();
		System.out.println("修改前: " + sc1.getInt()+ ", " + sc1.getString());
		TestShallow sc2 = (TestShallow) sc1.clone();
		sc2.setInt(1);
		sc2.setString(new StringBuffer("World"));
		System.out.println("修改后1: " + sc1.getInt()+ ", " + sc1.getString());
		System.out.println("修改后2: " + sc2.getInt()+ ", " + sc2.getString());
	}

}

class TestShallow implements Cloneable {
	private int i = 0;
	private StringBuffer str = new StringBuffer("Hellow");
	
	@Override
	protected Object clone(){
		TestShallow sc = null;
		try {
			sc = (TestShallow) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sc;
	}
	
	public void setInt(int i) {
		this.i = i;
	}
	
	public int getInt() {
		return i;
	}
	
	public void setString(StringBuffer str) {
		this.str.append(str);
	}

	public StringBuffer getString() {
		return str;
	}
	
}