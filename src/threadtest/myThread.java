package threadtest;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* 
 * �߳�01
 * Java�߳�ʵ�ַ�ʽ
 * ʵ��1���̳�Thread�࣬��дrun()���� ���޷��أ�
 * ʵ��2��ʵ��Runnable�ӿڣ���дrun()���� ���޷��أ�
 * ʵ��3��ʵ��Callable�ӿڣ���дcall()����  ���з��أ�
 */
public class myThread {

	public static void main(String[] args) throws Exception {
		for (int i = 0; i <= 100; i++) {
			System.out.println("Main: " + i);
			if (i == 20) { // ��ʽ1
				Thread1 thread1 = new Thread1();
				thread1.start();
				// new Thread2().start();
				
			} else if (i == 40) { // ��ʽ2
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


// ͨ���̳�Thread��
class Thread1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i <= 50; i++) {
			System.out.println("Thread: " + i);
		}
	}
}

// ͨ��ʵ��Runnable�ӿ�
class Thread2 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i <= 50; i++) {
			System.out.println("Runnable: " + i);
		}
	}
}

// ͨ��ʵ��Callable�ӿ�
class Thread3 implements Callable<Object> {

	@Override
	public Object call() throws Exception {
		for (int i = 0; i < 50; i++) {
			System.out.println("Callabe: " + i);
		}
		return "===========callable thread===========";
	}
}
