package 学习3.Lamda表达式;

public class TestLamda2 {
	
	public static void main(String[] args) {
		
		
		//1.lamda表达式
		ccc h=(int a)-> {
				for(int i=0;i<a;i++) {
					System.out.println("offer+"+i);
				}
			};
		h.go(10);
		
		//2.继续简化lamda表达式,省略了传入的参数的类型
		ccc h1=(a)->{
			for(int i=0;i<a;i++) {
				System.out.println("入职+"+i);
			}
		};
		h1.go(10);
		
		//3.继续简化，省略括号
		ccc h2=a->{
			for(int i=0;i<a;i++) {
				System.out.println("入职成功+"+i);
			}
		};
		h2.go(10);
		
		//4.简化花括号(只有一行代码的情况才能省略花括号，有多行代码就是用代码块(花括号))
		ccc h3=a-> System.out.println("入职成功了+"+a);
		h3.go(1);
	}
}
	/*//静态内部类
	static class offer implements ccc{
		@Override
		public void go(int a) {
			for(int i=0;i<a;i++) {
				System.out.println("offer+"+i);
			}
		}*/

interface ccc{
	void go(int a);
}

