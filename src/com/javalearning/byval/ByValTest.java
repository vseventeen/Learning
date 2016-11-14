package com.javalearning.byval;

public class ByValTest {
	public static void main(String[] args) {
		ByValTest t = new ByValTest();
		t.first();
	}
	
	public void first() {
		int i = 5;
		Value v = new Value();
		System.out.println("01.�½�һ��Value����v.i = " + v.i); // 15
		System.out.println("02.��Value����hashֵ��" + v.hashCode());
		v.i = 25;
		System.out.println("03.����Value��i�ı�Ϊ" + v.i); // 25
		System.out.println("04.�ı��Value����hashֵ:" + v.hashCode());
		second(v, i); // v.i = 25, i = 5
		System.out.println("10.���ý������Value�����hashֵ��" + v.hashCode());
		System.out.println(v.i);
	
	}
	
	public void second(Value v, int i) {
		System.out.println("05.���ø�����Value����hashֵ��" + v.hashCode());
		i = 0;
		v.i = 20;
		System.out.println("06.�����ø�����Value�����i�ı�Ϊ" + v.i);
		System.out.println("07.�ı�����ø�����Value����hashֵ��" + v.hashCode());
		Value value = new Value();
		v = value; // ��ʱ
		System.out.println("08.�����ø���ָ��һ���µ�Value�����hashֵ" + v.hashCode());
		System.out.println("09.��ʱ���ø�����iֵ��v.i = " + v.i);
		
	}

}

class Value {
	public int i = 15;
}
