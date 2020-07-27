package 学习2.创建线程的三种方式;


//使用第二种方法:实现Runnable接口创建线程:
//1.定义类实现Runnable接口，2.实现run()方法，编写线程执行体，3.创建线程对象，执行线程需要丢入runnable接口实现类，然后调用Start来启动线程
public class TestRunnable implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			System.out.println("offer++"+i);
		}
		
	}
	
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 1000; i++) {
			System.out.println("您已通过面试"+i);
		}
		
		TestRunnable tr=new TestRunnable();
		//创建线程对象，通过线程对象开启线程，代理的方式
		Thread t=new Thread(tr);
		t.start();
		
		//还可以直接写为:new Thread(tr).start();

	}

	

}
