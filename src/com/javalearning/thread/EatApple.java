package com.javalearning.thread;

/**
 * �߳�03
 * ͨ���ӿ�ʵ����Դ����  
 * 	1. �̳�Thread�ࣺÿ���˶�����50��ƻ��
 * 	2. ʵ��Runnable�ӿڣ�50��ƻ���������˷ֳ�
 * -----------------------------------------------
 * �̰߳�ȫ����: ƻ��˳����ң����ظ����ж�ȱ���и���...
 */

public class EatApple {
	public static void main(String[] args) {
		if (!true) {
			// ʹ�ü̳з�ʽ
			new EaterClass("A").start();
			new EaterClass("B").start();
			new EaterClass("C").start();
		} else {
			// ʹ�ýӿڷ�ʽ
			EaterInterface e = new EaterInterface();
			new Thread(e, "X").start();
			new Thread(e, "Y").start();
			new Thread(e, "Z").start();
		}
	}
}

class EaterClass extends Thread {
	private int num = 50;

	public EaterClass(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i <= 50; i++) {
			if (num > 0) {
				System.out.println(super.getName() + "����" + num-- + "��ƻ��.");
			}
		}
	}
}

class EaterInterface implements Runnable {

	private int num = 50;

	@Override
	public void run() {

		try {
			for (int i = 0; i < 50; i++) {
				if (num > 0) {
					// ˯�߲��ǵ����̳߳������ԭ����ʹ�̰߳�ȫ���������
					// ͨ��ʹ��sleep()��ģ�������ӳ�
					Thread.sleep(100);
					System.out.println(Thread.currentThread().getName() 
							+ "����" + num + "��ƻ��.");
					num--;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}