package Final;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Web {
		private String url;
		private String title;
		private int count;
		private Counter c = new Counter();
	
		
		public Web(String title,String u){
			this.title = title;
			this.url = u;
			this.count = 0;
			
		}
		
		//for parent web
		public Document setRootCount(){
			
			this.count = c.count(url);
			Document doc = c.getData();
			return doc;
		}
		
		//for child web
		public void setCount(){
			
			this.count = c.count(url);
			Document doc = c.getData();
			
			Elements stitle = doc.select("title");
			if(!stitle.isEmpty()){
				String subtitle = stitle.get(0).toString();
				int ste = subtitle.indexOf(">");
				title = subtitle.substring(ste+1, subtitle.length()-8);
			}
			
		}
		
		public void setCount(int total){
			
			this.count+=total;
		}
	

		
		public String getTitle(){
			
			return title;
		}
		
		public String getUrl(){
			return url;
		}
		
		public int getCount(){
			return count;
		}
		
		public String toString(){
			return "Title : "+title+"\r\n"+"Url   : "+url+"\r\n"+"Count : "+count+"\r\n";
		}
		
		public String print(){
			return "\tTitle : "+title+"\r\n"+"\tUrl   : "+url+"\r\n"+"\tCount : "+count+"\r\n";
		}
		
	
}
