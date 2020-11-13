package hadoopWordcount;

public class KeyCount {
	private String name;
	private int count;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public KeyCount(String name, int count) {
		this.name = name;
		this.count = count;
	}
	public KeyCount()
	{
		this(null, -1);
	}
	@Override
	public String toString() {
		return "KeyCount [name=" + name + ", count=" + count + "]";
	}
}
