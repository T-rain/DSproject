package Final;

public class test {
	public static void main(String[] args) {
		
		DataList dataList = new DataList();
		Web w = new Web("test", " http://www.niusnews.com/%3DP022g234");
		dataList.add(w);
		Webtree wbt = new Webtree(dataList);
		wbt.set();
		wbt.getResult();

	}
}
