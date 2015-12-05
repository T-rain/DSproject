package Final;

public class Keyword {
	private String name;
	private int count;
	
	public Keyword(String n,int c){
		this.name= n;
		this.count = c;
	}
	
	public String getName(){
		return name;
	}

	
	public int getCount(){
		return count;
	}
	
	public String toString(){
		return "[key:"+name+","+count+"]";
		
	}
}
