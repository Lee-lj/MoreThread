package 学习4.线程不安全三个示例;


//不安全的取钱方式  ，两个人同时取钱，余额可能变为负数,设置一个睡眠时间，保证同时执行这两个线程，放大了问题
//AL;还剩-200
//gf手里有300
//AL;还剩-200
//me手里有200
public class UnSafeGetMoney {

	public static void main(String[] args) {
		Account ac=new Account(300, "AL");
		bank b=new bank(ac, 200, "me");
		bank c=new bank(ac, 300, "gf");
		
		b.start();
		c.start();
	}

}

//账户
class Account{
	int account;
	String name;//卡名
	public Account(int account, String name) {
		this.account = account;
		this.name = name;
	}
}

//银行，模拟取款
class bank extends Thread{
	Account ac;//账户
	//取了多少钱
	int getMoney;
	//手中取出的钱
	int total;
	
	public bank(Account ac,int getMoney,String name) {
		super(name);
		this.ac=ac;
		this.getMoney=getMoney;
		
	}
	
	//取钱
	@Override
	public void run() {
		//判断能取出足够的钱吗,不够就直接退出
		if(ac.account<getMoney) {
			System.out.println(Thread.currentThread().getName()+"->账户余额不足");
			return;
	}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ac.account=ac.account-getMoney;//卡里的钱
		
		total=total+getMoney;
		System.out.println(ac.name+";还剩"+ac.account);
		//System.out.println(this.getName)等价于System.out.println(Thread.currentThread().getName());因为继承了thread类，thread中含有getname方法
	    System.out.println(this.getName()+"手里有"+total);
	
	
}
}