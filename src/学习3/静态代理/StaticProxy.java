package 学习3.静态代理;


public class StaticProxy {

	public static void main(String[] args) {
		WeddingCompany wc=new WeddingCompany(new You());
		wc.HappyMarry();
		//上面两行代码可以简写为        新建一个代理对象，放入真实对象，然后执行，就相当于Thread(Thread内部已经实现了Runnable接口)，
		//然后放入真实的线程，然后start，实现了静态代理
		new Thread(()->System.out.println("开心")).start();
		new WeddingCompany(new You()).HappyMarry();
		
		
		/*不使用代理的对象结婚,但是只能实现结婚这一个事件
		You you = new You();
		you.HappyMarry();*/
	}

}

//结婚的接口
interface Marry{
	void HappyMarry();
}

//真实角色，你自己去结婚
class You implements Marry{
	@Override
	public void HappyMarry() {
		System.out.println("With you");
	}
}

//婚庆公司是代理角色
class WeddingCompany implements Marry{

	//目标对象(真实的结婚对象)
	private Marry target;

	//构造器传参
	public WeddingCompany(Marry target) {
		this.target = target;
	}
 

	@Override
	public void HappyMarry() {
		before();
		this.target.HappyMarry();
		after();
		
	}


	private void after() {
		System.out.println("打钱！！");
	}


	private void before() {
		System.out.println("布置现场");
	}
	
}
