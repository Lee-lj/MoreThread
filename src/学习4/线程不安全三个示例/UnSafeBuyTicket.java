package 学习4.线程不安全三个示例;

//线程不安全的买票方法 刘波拿到第19张票   李四拿到第19张票 ，这就是线程不安全
public class UnSafeBuyTicket {
	
	public static void main(String[] args) {
		BuyTickets bt=new BuyTickets();
		
		new Thread(bt,"张三").start();
		new Thread(bt,"李四").start();
		new Thread(bt,"王麻子").start();
		new Thread(bt,"刘波").start();
		new Thread(bt,"坦克").start();
		
	}

}

class BuyTickets implements Runnable{

	private int ticketNum=20;//票数
	boolean flag=true;//线程停止标志
	
	@Override
	public void run() {
		//买票
		while(flag) {
			buy();
		}
	}
	
	private void buy() {
		//判断是否有票
		if(ticketNum<=0) {
			flag=false;
			return;
		}
		//买票
		System.out.println(Thread.currentThread().getName()+"拿到第"+ticketNum--+"张票");
	}
	
}