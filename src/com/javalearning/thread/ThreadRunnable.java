package com.javalearning.thread;

/*
 * 线程02
 * 同时继承Thread类和实现Runnable接口
 */
public class ThreadRunnable extends Thread implements Runnable {
	
	public static void main(String[] args) {
		// 虽然没有重写run()方法，但是该类继承了Thread类中的run()方法，
		// 可以作为Runnable接口中的run()方法
		new Thread(new ThreadRunnable()).start();
		
	}
}
