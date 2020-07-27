package 学习5.死锁;

//测试死锁  死锁:多个线程拥有一部分资源，但是需要别的线程占有的资源，别的线程又需要这个线程的资源，互相僵持，这就是死锁
public class DeadLock {

	public static void main(String[] args) {
		Makeup mp=new Makeup(0, "阿三");
		Makeup mp2=new Makeup(1,"小邋遢");
		
		mp.start();
		mp2.start();
	}
}

//口红
class Lipstick{
	
}

//镜子
class Mirror{
	
}

//化妆
class Makeup extends Thread{
	
	//化妆需要的资源，都只有一份，用static保存
	static Lipstick lip=new Lipstick();
	static Mirror mirror=new Mirror();

	int choice;//选择
	String name;//使用化妆品的人
	
	public Makeup(int choice,String name) {
		this.choice=choice;
		this.name=name;
	}
	
	@Override
	public void run() {
		 makeup();
		
	}
	
	//化妆的方法，相互需要对方的资源
	private void makeup(){
		if(choice==0) {
			synchronized(lip) {//获得口红的锁
				System.out.println(this.name+"获得口红");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			synchronized(mirror) {//一秒钟后拿镜子
				System.out.println(this.name+"获得镜子");
			}
		}else {//第二个人上场
			synchronized(mirror) {//获得口红的锁
				System.out.println(this.name+"获得镜子");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			synchronized(lip) {//一秒钟后拿镜子
				System.out.println(this.name+"获得口红");
			}
		}
	}
}