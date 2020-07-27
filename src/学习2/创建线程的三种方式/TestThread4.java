package 学习2.创建线程的三种方式;


//测试多个线程同时操作同一个对象
//买火车票的例子  并发的问题

//佳佳-->拿到了第9张票
//狒狒-->拿到了第9张票     多个线程操作同一个资源的情况下，线程不安全，一个数据可能被多个线程调用，数据紊乱
public class TestThread4 implements Runnable{

	
	//票数
	private int ticketNum=10;
	
	@Override
	public void run() {
		while(true) {
			
			if(ticketNum<=0) {
				break;
			}
			/*try { 让一个线程休眠200ms，模拟延时
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			System.out.println(Thread.currentThread().getName()+"-->拿到了第"+ticketNum--+"张票");
			//Thread.currentThread().getName()通过这个方法，知道哪个线程拿到了票
		}
		
	}
	public static void main(String[] args) {
		TestThread4 ts=new TestThread4();
		
		new Thread(ts,"嗷嗷").start();
		new Thread(ts,"狒狒").start();
		new Thread(ts,"佳佳").start();
	}

	

}
