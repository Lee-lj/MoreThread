package 线程协作.生产者消费者;


//测试生产者消费者，利用缓冲区解决:管程法
public class TestPC {

	public static void main(String[] args) {
		SynContainer container=new SynContainer();
		new Productor(container).start();
		new Consumer(container).start();
	}

}

//生产者
class Productor extends Thread{
	SynContainer container;
	
	public Productor(SynContainer container) {
		this.container=container;
	}

	//生产
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			container.push(new Wood(i));
			System.out.println("生产了第"+i+"件资源");
		}
	}
	
	
}

//消费者
class Consumer extends Thread{
    SynContainer container;
	
	public Consumer(SynContainer container) {
		this.container=container;
	}
	
	//消费
		@Override
		public void run() {
			for(int i=0;i<100;i++) {
				System.out.println("消费了第"+container.pop().id+"件资源");
			}
		}
}

//产品
class Wood{
	
	int id;//产品编号
	
	public Wood(int id) {
		this.id=id;
	}
}

//缓冲区
class SynContainer{
	
	//容器大小
	Wood[] woods=new Wood[10];
	
	int count=0;//容器中的货物的计数器
	
	//生产者放入产品
	public synchronized void push(Wood wood) {
		//容器如果满了，让消费者消费
		if(count==10) {
			 //通知消费者消费，生产者等待
			try {
				this.wait();
				} catch (InterruptedException e) {
				e.printStackTrace();
				}
		}
		
		//没满，消费者就生产产品
		woods[count] =wood;
		count++;
		
		//通知消费者消费
		this.notifyAll();
	}
	
	//消费者消费产品
	public synchronized Wood pop() {
		//判断能否消费
		if(count==0) {
			//等待生产者生产，消费等待
			try {
				this.wait();
				} catch (InterruptedException e) {
				e.printStackTrace();
				}
		}
		
		//可以消费的话，就消费
		count--;
		Wood wood=woods[count];
		
		//通知生产者生产
		this.notifyAll();
		
		
		return wood;
	}
}