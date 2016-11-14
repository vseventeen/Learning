package com.javalearning.thread;

public class AlphabetNumber {

	public static void main(String[] args) {
		Combianation c = new Combianation();
		new AlphabetThread(c).start();
		new NumberThread(c).start();
	}

}

class AlphabetThread extends Thread {
	private Combianation c = null;
	
	public AlphabetThread(Combianation c) {
		this.c = c;
	}
	
	@Override
	public void run() {
		for (int i = 65; i < 91; i++) {
			c.addLetter(i);
		}
	}
}

class NumberThread extends Thread {
	private Combianation c = null;
	
	public NumberThread(Combianation c) {
		this.c = c; 
	}
	
	@Override
	public void run() {
		for (int i = 1; i < 27; i++) {
			c.addNumber(i);
		}
	}
}

class Combianation {
	private StringBuilder sb = new StringBuilder();
	private boolean flag = true;
	
	synchronized public void addNumber(int i) {
		try {
			while (!flag) {
				this.wait();
			}
			sb.append(i);
			System.out.println(sb);
			flag = false;
			this.notifyAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	synchronized public void addLetter(int i) {
		try {
			while (flag) {
				this.wait();
			}
			sb.append((char)i);
			System.out.println(sb);
			flag = true;
			this.notifyAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}