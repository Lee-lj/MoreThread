package 线程协作.生产者消费者;

//线程通信-信号灯法，设置标志位
public class TestPClight {
	public static void main(String[] args) {
		TV tv=new TV();
		new Player(tv).start();
		new Watcher(tv).start();
	}
}

//生产者-演员
class Player extends Thread{
	TV tv;
	public Player(TV tv) {
		this.tv=tv;
	}
	
	@Override
	public void run() {
		for(int i=1;i<21;i++) {
			if(i%2==0) {
				this.tv.play("三毛流浪记");
			}else {
				this.tv.play("广告时间");
			}
		}
	}
}
//消费者-观众
class Watcher extends Thread{
	TV tv;
	public Watcher(TV tv) {
		this.tv=tv;
	}
	
	@Override
	public void run() {
		for(int i=1;i<21;i++) {
			this.tv.watch();
		}
	}
}

//通过电视表演电影,产品就是电影
class TV{
	//演员生产电影，观众等待 flag=true
	//观众消费电影，演员等待flag=false
	
	String name;//表演的节目
	
	boolean flag=true;//标志位
	
	//演员生产电影
	public synchronized void play(String name){
		if(!flag) {//如果flag为false，演员等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("演员拍了"+name);
		
		//通知观众观看
		this.notifyAll();
		
		this.name=name;
		this.flag=!this.flag;//取反为false
	}
	
	//观众看电影
	public synchronized void watch() {
		if(flag) {//flag为true，观众停止看电影，等待演员拍电影
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("观众看了"+name);
		//通知演员继续拍电影
		this.notifyAll();
		this.flag=!this.flag;//取反为true
	}
	
}