package 学习3.线程的优先级;


//测试设置线程优先级
public class TestThreadPriority {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
		//主线程改不了优先级。默认优先级
		
		threadPriority tp=new threadPriority();
		Thread t1 = new Thread(tp,"A");
		Thread t2 = new Thread(tp,"B");
		Thread t3 = new Thread(tp,"C");
		Thread t4 = new Thread(tp,"D");
		Thread t5 = new Thread(tp,"E");
		//先设置优先级，再启动线程
		t2.setPriority(6);
		t4.setPriority(8);
		t5.setPriority(10);
		t1.setPriority(2);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
	
	
	
	
}

class threadPriority implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
		
	}
	
}
