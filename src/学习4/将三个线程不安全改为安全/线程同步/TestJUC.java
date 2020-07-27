package 学习4.将三个线程不安全改为安全.线程同步;

import java.util.concurrent.CopyOnWriteArrayList;

//测试JUC安全类型的集合,,CopyOnWriteArrayList和callable一样，都是并发编程的类
public class TestJUC {

	public static void main(String[] args) {
		CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<>();
		for(int i=0;i<1000;i++) {
			new Thread(()->{
				list.add(Thread.currentThread().getName());
			}).start();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(list.size());
	}

}
