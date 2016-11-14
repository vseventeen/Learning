package com.javalearning.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 线程05 生产者消费者实例
 * 连续生产，连续消费
 *
 */

public class ProducerConsumer {

	public static void main(String[] args) {
		Warehouse warehouse = new Warehouse();
		new Thread(new Producer(warehouse)).start();
		new Thread(new Consumer(warehouse)).start();
	}

}

class Producer implements Runnable {

	private Warehouse warehouse = null;

	public Producer(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	@Override
	public void run() {
		warehouse.produce();
	}

}

class Consumer implements Runnable {

	private Warehouse warehouse = null;

	public Consumer(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	@Override
	public void run() {
		warehouse.consume();
	}

}

class Warehouse {
	// 声明并新建一个空数组
	private List<Integer> sharedList = Collections.synchronizedList(new ArrayList<>());
	// 数组长度
	private int size = 20;

	public Warehouse() {
	}

	public Warehouse(int size) {
		this.size = size;
	}

	synchronized void produce() {
		while (true) {
			// while (!sharedList.isEmpty()) {  // 当队列不空时，等待（交替）
			
			while (sharedList.size() == size) { // 等到队列满时，等待
				System.out.println("生产完毕，等待消费");
				try {
					this.wait(); // 等待（全部生产完）
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Random random = new Random();
			int i = random.nextInt(100);
			System.out.println("生产了：" + i);
			sharedList.add(i);
			this.notifyAll(); // 唤醒
		}
	}

	synchronized void consume() {
		while (true) {
			if (sharedList.isEmpty()) {
				System.out.println("消费完毕，等待生产");
				try {
					this.wait(); // 等待 （全部消费完）
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				// 先生产先消费（模拟队列，先进先出）
				System.out.println("消费了：" + sharedList.remove(0));
				this.notifyAll();
			}
		}
	}

}
