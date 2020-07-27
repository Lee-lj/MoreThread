package 学习3.线程的5大状态;

import 学习2.创建线程的三种方式.TestThread4;

//模拟网络延时：放大问题的发生性
/*佳佳-->拿到了第7张票
狒狒-->拿到了第7张票
嗷嗷-->拿到了第7张票
狒狒-->拿到了第6张票  证明线程时不安全的
嗷嗷-->拿到了第4张票*/
public class TestThreadSleep implements Runnable{

		//票数
		private int ticketNum=10;
		
		@Override
		public void run() {
			while(true) {
				
				if(ticketNum<=0) {
					break;
				}
				try { //让线程休眠200ms，模拟延时
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(Thread.currentThread().getName()+"-->拿到了第"+ticketNum--+"张票");
				//Thread.currentThread().getName()通过这个方法，知道哪个线程拿到了票
			}
			
		}
		public static void main(String[] args) {
			TestThreadSleep ts=new TestThreadSleep();
			
			new Thread(ts,"嗷嗷").start();
			new Thread(ts,"狒狒").start();
			new Thread(ts,"佳佳").start();
		}
}
