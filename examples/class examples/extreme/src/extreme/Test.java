package extreme;

public class Test {

	public static void main(String[] args) throws Exception{
		Class.forName(args[0]).newInstance();
		
	}

}
