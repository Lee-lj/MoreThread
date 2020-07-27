package 学习3.线程的5大状态;


/*测试stop停止线程
 * 1.最好让线程自己停止下来-->利用循环次数，不建议死循环
 * 2.建议使用一个标志位进行终止变量，当flag=false，终止线程运行
 * 3.不建议使用JDK提供的stop(),destory()方法(已废弃)	
 */

public class TestThreadStop implements Runnable{
	
	//2.设置一个标志位
	private boolean flag=true;

	@Override
	public void run() {
		int i=0;
		while(flag) {
			System.out.println("run.....thread"+i++);
		}
	}

	//2.设置一个公开的方法停止线程，转换标志位
	public void stopCurrentThread() {
		this.flag=false;
	}
	
	public static void main(String[] args) {
		TestThreadStop ts=new TestThreadStop();
		new Thread(ts).start();
		for(int i=0;i<1000;i++) {
			System.out.println("main"+i);
			if(i==900) {
				//调用方法停止线程(将flag转换为false)
				ts.stopCurrentThread();
				System.out.println("线程已停止");
			}
		}
	}

	

}
