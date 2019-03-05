package extreme;

public class Example {

	static{
		System.out.println("Loaded...");
	}
	
	
	
	
	private int x;
	
	
	public Example() {
		System.out.println("Created..");
	}


	@Override
	protected void finalize() throws Throwable {
		System.out.println("gced...");
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Example other = (Example) obj;
		if (x != other.x)
			return false;
		return true;
	}
	
}
