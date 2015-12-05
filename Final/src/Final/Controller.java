package Final;


import java.util.Scanner;

public class Controller {

	public static void main(String[] args) {
		
		try {
	
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("請輸入關鍵字：");
		String key = sc.next();
		
		System.out.println("");
		
		
		GoogleSearch gs = new GoogleSearch();
		gs.setQuery(key);
		
		gs.callGoogle();
		
		DataList dataList = gs.getData();
		
		
		Webtree wbt = new Webtree(dataList);
		wbt.set();
		
		System.out.println("");
		System.out.println("最佳搜尋結果前五個:");
		wbt.getResult();
		
		
		sc.close();
		
		} catch (Exception e) {

			System.out.println("not found data");
		}

	}

}
