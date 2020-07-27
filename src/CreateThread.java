import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//此类总结了多线程的学习
public class CreateThread {
	public static void main(String[] args) {
		new Mythread1().start();//继承Thread的启动方式
		
		new Thread(new Mythread2()).start();//实现Runnable接口的启动方式
		
		FutureTask<Integer> future=new FutureTask<Integer>(new Mythread3());//Integer是泛型约束
		new Thread(future).start();//3.实现callable接口的启动方式
		
		Integer result;
		try {
			result = future.get();
			System.out.println(result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

//创建方式1.继承Thread
class Mythread1 extends Thread{
	@Override
	public void run() {
		System.out.println("创建方式1.继承Thread");
	}
}

//创建方式2.实现Runnable接口
class Mythread2 implements Runnable{
	@Override
	public void run() {
		System.out.println("创建方式2.实现Runnable接口");
	}
}

//创建方式3.实现callable接口
class Mythread3 implements Callable{
	@Override
	public Object call() throws Exception {
		System.out.println("创建方式3.实现callable接口");
		return 1010;
	}
}