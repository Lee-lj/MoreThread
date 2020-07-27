package 学习4.将三个线程不安全改为安全.线程同步;

import java.util.ArrayList;
import java.util.List;

//线程安全的集合synchronized(list) {//对集合进行锁，保证排队，不会多个操作覆盖一个空间
public class SafeList {

	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		
		synchronized(list) {//对集合进行锁，保证排队，不会多个操作覆盖一个空间
		for(int i=0;i<1000;i++) {
			new Thread(()->{
				list.add(Thread.currentThread().getName());
			}).start();
			System.out.println(list.size());//添加1000条数据，等于1000的话说明集合线程安全，否则不安全
		   }
		}
	}

}
