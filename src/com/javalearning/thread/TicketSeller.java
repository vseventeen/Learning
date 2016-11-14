package com.javalearning.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * �߳�04 �̰߳�ȫ 1. ͬ������� 2. ͬ������ 3. ͬ����Lock
 */

public class TicketSeller {
	public static void main(String[] args) {
		WindowLock window = new WindowLock();
		new Thread(window, "1�Ŵ���").start();
		new Thread(window, "2�Ŵ���").start();
		new Thread(window, "3�Ŵ���").start();
	}
}

// ͬ������飬��������Ϊ�����̹߳���Ķ���
class WindowBlock implements Runnable {
	private int num = 100;

	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			synchronized (this) { // this����Window���󣬸ö��󱻶��̹߳���
				try {
					if (num > 0) {
						System.out.println(Thread.currentThread().getName()
								+ "������" + num + "��Ʊ.");
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

// ͬ��������
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
						+ "������" + num + "��Ʊ.");
				Thread.sleep(10);
				num--;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

// ͬ����
class WindowLock implements Runnable {
	private final Lock lock = new ReentrantLock();
	private int num = 100;

	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			lock.lock(); // ��ȡ��
			if (num > 0) {
				try {
					System.out.println(Thread.currentThread().getName()
							+ "������" + num + "��Ʊ.");
					Thread.sleep(10);
					num--;
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock(); // �ͷ���
				}
			}
		}
	}
}
