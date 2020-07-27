package 学习2.创建线程的三种方式;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

//练习Thread，实现多线程同步下载图片，使用到了commons-io依赖,同时下载三张图片,下载的顺序并不是按照start的上下顺序执行的
public class TestThread2 extends Thread{

	private String url;//图片地址
	private String name;//保存的文件名
	
	public TestThread2(String url,String name) {
		this.url=url;
		this.name=name;
	}
	
	//下载图片线程的执行体
	@Override
	public void run() {
		WebDownloader webdown=new WebDownloader();
		webdown.downLoader(url, name);
		System.out.println("下载了文件名为"+name);
	}
	
	public static void main(String[] args) {
		TestThread2 ts=new TestThread2("https://images.pexels.com/photos/1122409/pexels-photo-1122409.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","1.jpg");
		TestThread2 ts1=new TestThread2("https://images.pexels.com/photos/213780/pexels-photo-213780.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","2.jpg"); 
		TestThread2 ts2=new TestThread2("https://images.pexels.com/photos/4823233/pexels-photo-4823233.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","3.jpg"); 
		
		ts.start();//先下载ts
		ts1.start();//中间下载ts2
		ts2.start();//最后下载ts3
		
		/*new Thread(ts).start();
		new Thread(ts1).start(); 实现runnable接口的启动方式
		new Thread(ts2).start();*/
		
	}
	
}

//下载器
class WebDownloader{
	//下载方法
	public void downLoader(String url,String name) {
		//下载工具
		try {
			FileUtils.copyURLToFile(new URL(url), new File(name));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("io异常，downloader方法出现问题");
		}
	}
}

