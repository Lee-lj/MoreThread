package 学习3.线程的5大状态;

import java.text.SimpleDateFormat;
import java.util.Date;

//模拟线程倒计时
public class TestThreadSleep2 {

	public void daojishi() throws InterruptedException {
		int num=10;
		while(true) {
			Thread.sleep(1000);
			System.out.println(num--);
			if(num<=0)break;
		}
	}
	
	public static void main(String[] args) {
		/*TestThreadSleep2 ts=new TestThreadSleep2();
		try {
			ts.daojishi();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*///倒计时实现
		
		//打印当前时间,间隔1秒
		Date nowTime=new Date(System.currentTimeMillis());
		while(true) {
			try {
				Thread.sleep(1000);
				//System.out.println(nowTime);不建议
				System.out.println(new SimpleDateFormat("HH:mm:ss").format(nowTime));
				nowTime=new Date(System.currentTimeMillis());//更新当前时间
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
