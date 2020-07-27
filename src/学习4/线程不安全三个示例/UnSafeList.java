package 学习4.线程不安全三个示例;

import java.util.ArrayList;
import java.util.List;

//线程不安全的集合
public class UnSafeList {

	public static void main(String[] args) {

		List<String> list=new ArrayList<String>();
		for(int i=0;i<1000;i++) {
			new Thread(()->{
				list.add(Thread.currentThread().getName());
			}).start();
			System.out.println(list.size());//添加1000条数据，等于1000的话说明集合线程安全，否则不安全
		}
	}

}
