package 学习3.守护线程;


//测试守护线程     上帝守护你
public class TestDaemon {

	public static void main(String[] args) {
		God g=new God();
		Person p=new Person();
		
		Thread thread=new Thread(g);
		thread.setDaemon(true);
		//将此线程设置为守护线程，setDaemon()默认为false，不是守护线程，设置为true，该线程就变味了守护线程，正常的线程都是用户线程
		
		thread.start();//虚拟机不用等待守护线程执行完毕，只要用户线程执行完毕，就不再输出守护线程的内容
		
		new Thread(p).start();
	}
}
//上帝  守护线程
class God implements Runnable{

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("我一直在你身边");
		}
		
	}
	
}

//你     用户线程
class Person implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<36500;i++) {
			 System.out.println("你已经活了"+i+"天");
		}
		System.out.println("goodbye! beautiful world!");
	}
	
}
