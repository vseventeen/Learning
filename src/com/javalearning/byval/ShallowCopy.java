package com.javalearning.byval;

/**
 * Cloneable�ӿ�ʵ��ǳ����
 *  
 * ǳ���������ڻ����������Ϳ���һ����������������ĸı䲻����������ı仯
 *         ���������������ͣ��������Ƕ�����ڴ��ַ�����ı仯�ᵼ��ԭ����ı仯
 */

public class ShallowCopy {
	public static void main(String[] args) {
		TestShallow sc1 = new TestShallow();
		System.out.println("�޸�ǰ: " + sc1.getInt()+ ", " + sc1.getString());
		TestShallow sc2 = (TestShallow) sc1.clone();
		sc2.setInt(1);
		sc2.setString(new StringBuffer("World"));
		System.out.println("�޸ĺ�1: " + sc1.getInt()+ ", " + sc1.getString());
		System.out.println("�޸ĺ�2: " + sc2.getInt()+ ", " + sc2.getString());
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