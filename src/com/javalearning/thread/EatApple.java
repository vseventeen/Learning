package com.javalearning.thread;

/**
 * 线程03
 * 通过接口实现资源共享  
 * 	1. 继承Thread类：每个人都吃了50个苹果
 * 	2. 实现Runnable接口：50个苹果被三个人分吃
 * -----------------------------------------------
 * 线程安全问题: 苹果顺序混乱；有重复；有短缺；有负数...
 */

public class EatApple {
	public static void main(String[] args) {
		if (!true) {
			// 使用继承方式
			new EaterClass("A").start();
			new EaterClass("B").start();
			new EaterClass("C").start();
		} else {
			// 使用接口方式
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
				System.out.println(super.getName() + "吃了" + num-- + "号苹果.");
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
					// 睡眠不是导致线程出问题的原因，它使线程安全问题更明显
					// 通常使用sleep()来模拟网络延迟
					Thread.sleep(100);
					System.out.println(Thread.currentThread().getName() 
							+ "吃了" + num + "号苹果.");
					num--;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}