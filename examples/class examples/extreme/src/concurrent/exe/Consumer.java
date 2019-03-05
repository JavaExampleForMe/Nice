package concurrent.exe;

import java.util.concurrent.Callable;

public class Consumer<T> implements Callable<Integer> 
{
	String consumerId;
	Stack s;

	public Consumer(String consumerId, Stack s){
		this.consumerId = consumerId;
		this.s = s;
	}

	public Integer call() throws Exception {
		int totalPoped=0;
		for(int i = 0; i <20; i++){
			long sleepTime=(long)(Math.random()*1500+500);
			try {
				Thread.sleep(sleepTime);
		}catch(Exception ex){ex.printStackTrace(); return 1;}
			
			int num=s.pop();
			totalPoped+=num;
		}
		if (totalPoped % 2 == 0)
			return totalPoped;
		throw new Exception("totalPoped%2!=0 ["+totalPoped+"]");
	}
}
