package com.javalearning.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程04 线程安全 1. 同步代码块 2. 同步方法 3. 同步锁Lock
 */

public class TicketSeller {
	public static void main(String[] args) {
		WindowLock window = new WindowLock();
		new Thread(window, "1号窗口").start();
		new Thread(window, "2号窗口").start();
		new Thread(window, "3号窗口").start();
	}
}

// 同步代码块，监听对象为被多线程共享的对象
class WindowBlock implements Runnable {
	private int num = 100;

	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			synchronized (this) { // this代表Window对象，该对象被多线程共享
				try {
					if (num > 0) {
						System.out.println(Thread.currentThread().getName()
								+ "卖出了" + num + "号票.");
						Thread.sleep(10);
						num--;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}

// 同步方法，
class WindowMethod implements Runnable {
	private int num = 100;

	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			sell();
		}
	}

	synchronized private void sell() {
		if (num > 0) {
			try {
				System.out.println(Thread.currentThread().getName()
						+ "卖出了" + num + "号票.");
				Thread.sleep(10);
				num--;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

// 同步锁
class WindowLock implements Runnable {
	private final Lock lock = new ReentrantLock();
	private int num = 100;

	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			lock.lock(); // 获取锁
			if (num > 0) {
				try {
					System.out.println(Thread.currentThread().getName()
							+ "卖出了" + num + "号票.");
					Thread.sleep(10);
					num--;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock(); // 释放锁
				}
			}
		}
	}
}
