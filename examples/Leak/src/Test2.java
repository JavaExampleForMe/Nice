
public class Test2 {
	public static void main(String[] args) {
		Runnable r=()->System.out.println(Math.random());
		
		
		(new Thread(r)).start();
		
		(new Thread(()->{
			int x=100;
			int y=30;
			System.out.println(x+y);
		})).start();
		
		(new Thread(Test2::doIt)).start();
		Test2 t=new Test2();
		(new Thread(t::doIt2)).start();
		
	}
	
	public static void doIt(){
		System.out.println("Doing it..");
	}
	
	public void doIt2(){
		System.out.println("Doing it two too..");
	}
}
