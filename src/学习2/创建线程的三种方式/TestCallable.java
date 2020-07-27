package 学习2.创建线程的三种方式;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.io.FileUtils;

//创建线程的方式三:实现Callable接口
/*
 * 
 */
public class TestCallable implements Callable<Boolean>{

	private String url;//图片地址
	private String name;//保存的文件名
	
	public TestCallable(String url,String name) {
		this.url=url;
		this.name=name;
	}
	
	//下载图片线程的执行体
	@Override
	public Boolean call() {
		WebDownloader webdown=new WebDownloader();
		webdown.downLoader(url, name);
		System.out.println("下载了文件名为"+name);
		return true; 
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		TestCallable ts1=new TestCallable("https://images.pexels.com/photos/1122409/pexels-photo-1122409.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","1.jpg");
		TestCallable ts2=new TestCallable("https://images.pexels.com/photos/213780/pexels-photo-213780.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","2.jpg"); 
		TestCallable ts3=new TestCallable("https://images.pexels.com/photos/4823233/pexels-photo-4823233.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500","3.jpg"); 
		
		//创建执行服务,一个容量为3的线程池
		ExecutorService ser=Executors.newFixedThreadPool(3);
		
		//提交执行
		Future<Boolean> flag1 = ser.submit(ts1);
		Future<Boolean> flag2 = ser.submit(ts2);
		Future<Boolean> flag3 = ser.submit(ts3);
		
		//获取结果
		boolean result1=flag1.get();
		boolean result2=flag2.get();
		boolean result3=flag3.get();
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		
		//关闭服务
		ser.shutdownNow();
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
}