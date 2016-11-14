package com.javalearning.thread;

public class test {
	public static void main(String[] args) {
		C c = new C();
		new A(c).start();
		new B(c).start();
	}

}

class A extends Thread {
	private C c;

	public A(C c) {
		this.c = c;
	}

	@Override
	public void run() {
		synchronized (c) {
			for (int i = 1; i < 27; i++) {
				while (c.getState() == 1) {
					try {
						c.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				c.num(i);
				c.setState();
				c.notifyAll();
				System.out.println(c.getString());
			}
		}

	}
}

class B extends Thread {
	private C c;

	public B(C c) {
		this.c = c;
	}

	@Override
	public void run() {
		synchronized (c) {
			for (int i = 65; i < 91; i++) {
				while (c.getState() != 1) {
					try {
						c.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				c.alphabet(i);
				c.setState();
				c.notify();
			}
		}
	}

}

class C {
	private StringBuilder sb = new StringBuilder();
	private int state = 1;

	public void num(int i) {
		sb.append(i);
	}

	public void alphabet(int i) {
		sb.append((char) i);
	}

	public StringBuilder getString() {
		return sb;
	}

	public void setState() {
		state = (state == 1) ? 2 : 1;
	}

	public int getState() {
		return state;
	}

}