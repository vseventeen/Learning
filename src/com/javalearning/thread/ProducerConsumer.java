package com.javalearning.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * �߳�05 ������������ʵ��
 * ������������������
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
	// �������½�һ��������
	private List<Integer> sharedList = Collections.synchronizedList(new ArrayList<>());
	// ���鳤��
	private int size = 20;

	public Warehouse() {
	}

	public Warehouse(int size) {
		this.size = size;
	}

	synchronized void produce() {
		while (true) {
			// while (!sharedList.isEmpty()) {  // �����в���ʱ���ȴ������棩
			
			while (sharedList.size() == size) { // �ȵ�������ʱ���ȴ�
				System.out.println("������ϣ��ȴ�����");
				try {
					this.wait(); // �ȴ���ȫ�������꣩
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Random random = new Random();
			int i = random.nextInt(100);
			System.out.println("�����ˣ�" + i);
			sharedList.add(i);
			this.notifyAll(); // ����
		}
	}

	synchronized void consume() {
		while (true) {
			if (sharedList.isEmpty()) {
				System.out.println("������ϣ��ȴ�����");
				try {
					this.wait(); // �ȴ� ��ȫ�������꣩
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				// �����������ѣ�ģ����У��Ƚ��ȳ���
				System.out.println("�����ˣ�" + sharedList.remove(0));
				this.notifyAll();
			}
		}
	}

}
