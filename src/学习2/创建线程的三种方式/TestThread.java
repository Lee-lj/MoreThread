package 学习2.创建线程的三种方式;

//简单尝试多线程第一种创建方式
//第一种方式:1.继承Thread类,2.重写run()方法，编写线程执行体,3.创建线程对象，调用start()方法启动线程

//CPU不会同时执行这两个线程，而是会交替执行，执行顺序由CPU调度执行
public class TestThread extends Thread{
	
	

	@Override
	public void run() {
		//run方法线程体
		for(int i=0;i<50;i++) {
			System.out.println("offer++"+i);
		}
	}

	public static void main(String[] args) {
		//主方法,main线程
		
		//创建一个子线程对象，使用start方法开启线程。如果调用run方法，程序从上往下执行就会执行完子线程再执行main，
		//如果调用Start方法，会交替执行main和子线程。main先执行，中间参杂子线程
		TestThread t=new TestThread();
		t.start();
		
		for (int i = 0; i < 500; i++) {
			System.out.println("您已通过面试"+i);
		}

	}

}
