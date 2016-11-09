package threadtest;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* 
 * 线程01
 * Java线程实现方式
 * 实现1：继承Thread类，重写run()方法 （无返回）
 * 实现2：实现Runnable接口，重写run()方法 （无返回）
 * 实现3：实现Callable接口，重写call()方法  （有返回）
 */
public class myThread {

	public static void main(String[] args) throws Exception {
		for (int i = 0; i <= 100; i++) {
			System.out.println("Main: " + i);
			if (i == 20) { // 方式1
				Thread1 thread1 = new Thread1();
				thread1.start();
				// new Thread2().start();
				
			} else if (i == 40) { // 方式2
				Runnable runnable = new Thread2();
				Thread t = new Thread(runnable);
				// Thread t = new Thread(new Thread3());
				t.start();
				
			} else if (i == 80) {
				Callable<Object> callable = new Thread3();
				FutureTask<Object> future = new FutureTask<Object>(callable);
				Thread thread = new Thread(future);
				thread.start();
				System.out.println(future.get());
			}
			
		}
	}
}


// 通过继承Thread类
class Thread1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i <= 50; i++) {
			System.out.println("Thread: " + i);
		}
	}
}

// 通过实现Runnable接口
class Thread2 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i <= 50; i++) {
			System.out.println("Runnable: " + i);
		}
	}
}

// 通过实现Callable接口
class Thread3 implements Callable<Object> {

	@Override
	public Object call() throws Exception {
		for (int i = 0; i < 50; i++) {
			System.out.println("Callabe: " + i);
		}
		return "===========callable thread===========";
	}
}
