import java.util.ArrayList;
import java.util.List;


public class Test {
	
	

	public static void main(String[] args) {	
		List<List<Integer>> data=new ArrayList<>();
		int counter=0;
		while(true){
			counter++;
			List<Integer>in=new ArrayList<>();
			for(int i=0;i<1000;i++){
				in.add((int)(Math.random()*100));
			}
			if(counter%100==0){
				data.add(in);
			}
		}

	}
}



