package 学习3.线程的5大状态;

//测试礼让线程，礼让不一定成功，看CPU心情
public class Testyield {
	public static void main(String[] args) {
		threadYield ty=new threadYield();
		new Thread(ty,"隔壁").start();
		new Thread(ty,"老王").start();
	}
}

class threadYield implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"->线程开始执行");
		Thread.yield();
		System.out.println(Thread.currentThread().getName()+"->线程停止执行");
	}
}
