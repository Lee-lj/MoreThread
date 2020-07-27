package 学习2.创建线程的三种方式;


//模拟龟兔赛跑
public class Race implements Runnable{

	//定义胜利者,不使用final，因为final修饰常量，必须要赋值
	private static String winner;
	
	@Override
	public void run() {
		for(int i=0;i<=100;i++) {
			boolean flag=gameOver(i);
			if(flag) break;//如果返回值为true，游戏结束，停止程序
			System.out.println(Thread.currentThread().getName()+"-->跑了"+i+"步");
		}
		
	}
	
	//判断是否完成比赛
	private boolean gameOver(int steps) {
		//判断是否有胜利者
		if(winner!=null) {
			//已经存在了胜利者
			return true;
		}{
			if(steps==100) {
				winner=Thread.currentThread().getName();
				System.out.println("胜利者是"+winner);
				return true;
			}
		}
		return false;
		
	}

	public static void main(String[] args) {
		Race a=new Race();
		new Thread(a,"兔子").start();
		new Thread(a,"乌龟").start();

	}

	
}
