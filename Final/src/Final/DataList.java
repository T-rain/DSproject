package Final;

import java.util.ArrayList;
//import java.util.HashMap;

public class DataList {

		private ArrayList<Web> list;
		//private HashMap<String, Web> wlist;

		public DataList() {
			this.list = new ArrayList<Web>();
			//this.wlist = new HashMap<String,Web>();
		}

		public void add(Web w) {
			list.add(w);
			// wlist.put(w.getTitle(), w);
		}
		
		public Web get(int i){
			return list.get(i);
		}
		
		public ArrayList<Web> getDataList(){
			return list;
		}
		
		/*public Web get(String name){
			return wlist.get(name);
		}*/
		
		public void getResult(){
			
			for(Web w: list){
				System.out.println(w.toString());
			}	
			
		}
		
		
}
