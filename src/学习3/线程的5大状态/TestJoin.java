package 学习3.线程的5大状态;


//测试join VIP线程
public class TestJoin implements Runnable{

	public static void main(String[] args) throws InterruptedException {
		//启动线程
		TestJoin tj=new TestJoin();
		Thread thread=new Thread(tj,"老王");
		thread.start();
		
		//主线程
		for(int i=0;i<500;i++){
			
			if(i==200) {//200之前是CPU调度执行，会穿插执行
				thread.sleep(5000);
				thread.join();//线程插队
			}
			System.out.println("main线程执行中。。。"+i);
		}
		
	}

	@Override
	public void run() {
		for(int i=0;i<100;i++) {
		System.out.println(Thread.currentThread().getName()+"->线程正在执行"+i);
		}
	}
}