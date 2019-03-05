package concurrent.exe;

import java.util.*;
import java.util.concurrent.*;


public class Factory 
{
	public static void main(String[] args) 
	{
		final Stack myStack = new Stack();
		ExecutorService executor=Executors.newCachedThreadPool();
//		ExecutorService executor=Executors.newFixedThreadPool(3);
        Callable<Integer> producer1=new Producer<Integer>("Producer1",myStack);
        Callable<Integer> producer2=new Producer<Integer>("Producer2",myStack);
        Callable<Integer> consumer1=new Consumer<Integer>("Consumer1",myStack);
        Callable<Integer> consumer2=new Consumer<Integer>("Consumer2",myStack);
        
        Collection<Callable<Integer>> col=new HashSet<Callable<Integer>>();        
        
        col.add(consumer1);
        col.add(consumer2);
        col.add(producer1);
        col.add(producer2);
        List<Future<Integer>> results=null;
        try {
        	results=executor.invokeAll(col);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        for(Future<Integer> f:results){
        	try{
        		System.out.println("Completed with: "+f.get());
        	}catch (Exception e) {
				System.out.println(e.getCause().getMessage());
			}
        }
        	
		executor.shutdown();
	}
}
