package 学习3.Lamda表达式;


/*
 * 推导lambda表达式
 * 1-5是一步步简化代码的过程
 */
public class TestLambda1 {
	
	//2.静态内部类
	static class me2 implements Ilike{
		@Override
		public void lambda() {
			System.out.println("冲冲冲奥里给");
		}
		
	}
	
	public static void main(String[] args) {
		Ilike me = new me();//接口new一个实现类
		me.lambda();
		
	    me2 me2 = new me2();
	    me2.lambda();
	    
	    //3.局部内部类
	    class me3 implements Ilike{
			@Override
			public void lambda() {
				System.out.println("冲冲冲奥里给加油");
			}
	    }
	    me=new me3();
	    me.lambda();
	    
	    //4.匿名内部类,没有类的名称，必须借助接口或者父类来实现
	    me =new Ilike() {
			@Override
			public void lambda() {
				System.out.println("冲冲冲奥里给加油Offer++");
			}
	    };
	    me.lambda();
	    
	    //5.lamda简化
	    me =()-> {
				System.out.println("冲冲冲奥里给加油Offer++我必行");
	    };
	    me.lambda();
	}
	
}

//定义一个函数式接口
interface Ilike{
	void lambda();
}

//1.接口实现类
class me implements Ilike{

	@Override
	public void lambda() {
		System.out.println("冲冲冲");
	}
	
}