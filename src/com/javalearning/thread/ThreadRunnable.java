package com.javalearning.thread;

/*
 * �߳�02
 * ͬʱ�̳�Thread���ʵ��Runnable�ӿ�
 */
public class ThreadRunnable extends Thread implements Runnable {
	
	public static void main(String[] args) {
		// ��Ȼû����дrun()���������Ǹ���̳���Thread���е�run()������
		// ������ΪRunnable�ӿ��е�run()����
		new Thread(new ThreadRunnable()).start();
		
	}
}
