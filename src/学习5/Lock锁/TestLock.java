package 学习5.Lock锁;

import java.util.concurrent.locks.ReentrantLock;

//测试ReentrantLock的lock锁
public class TestLock {

	public static void main(String[] args) {
		lock l=new lock();
		new Thread(l,"1").start();
		new Thread(l,"2").start();
		new Thread(l,"3").start();

	}

}

class lock implements Runnable{

	int ticketNum=10;
	
	//不加lock锁线程不安全，定义lock锁
	private final ReentrantLock locks=new ReentrantLock();
	
	
	@Override
	public void run() {
		while(true) {
			try {
			locks.lock();//加锁
			if(ticketNum>0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(ticketNum--);
			}else {
				break;
			}
		}finally {
			//解锁,加锁之后就相当于在排队
			locks.unlock();
		 }
	  }
   }
}