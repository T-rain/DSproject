package Final;



import java.io.IOException;

import java.net.URL;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class Counter {
			private ArrayList<Keyword> klist;
			private Document doc;
			
			public Counter(){
				
				klist = new ArrayList<Keyword>();
				addKeyword();
			}
			
			private void addKeyword(){
				
				 String name1[]=new String[]{("柳葉魚"),("滅火器"),("雀斑"),("白蘿蔔"),("大象體操"),("台灣"),("搖滾"),("獨立"),("樂團")};
				 for(String n : name1 ){
					 Keyword k = new Keyword(n,1);
					 klist.add(k);
				 }
				 
				 String name2[]=new String[]{("後搖"),("龐克"),("民謠"),("金屬"),("融合爵士"),("污漬搖滾"),("貝斯手"),("鼓手"),("樂團")};
				 for(String n : name2 ){
					 Keyword k = new Keyword(n,2);
					 klist.add(k);
				 }
				 
				 String name3[]=new String[]{("見證大團"),("樂人"),("大港開唱"),("音樂節"),("街聲")};
				 for(String n : name3 ){
					 Keyword k = new Keyword(n,3);
					 klist.add(k);
				 }
				 
				 String name4[]=new String[]{("河岸留言"),("海邊的卡夫"),("女巫店"),("這牆")};
				 for(String n : name4 ){
					 Keyword k = new Keyword(n,4);
					 klist.add(k);
				 }       
				 
		
				 	
			}
			
			public int count(String u){
				
				
				int score = 0;
				
				//int endCount = 0;
	
				try {
					//if(endCount<2){
					URL url = new URL(u); 
					
					doc =  Jsoup.parse(url,3000);
					
					String content = doc.text();						
					for(Keyword k : klist ){
						
						score += getCount(content,k);
					}
					
					//endCount++;
					//}		
				} catch (IOException e) {
					//System.out.println("無此頁面");
					doc = Document.createShell(u);
					//e.printStackTrace();
				}
			
				return score;
			}
			
			public Document getData(){
				return doc;
			}
			
			/*private String getData(String u)throws IOException{
				
				
				
				String article = "";
				String line = "";
				URL url;
				URLConnection urlConnection;
				InputStream in;
				InputStreamReader ir;
				BufferedReader br;
				
				url = new URL(u);
				urlConnection = url.openConnection();
				in = urlConnection.getInputStream();
				ir = new InputStreamReader(in);
				br = new BufferedReader(ir);
				
				while ((line=br.readLine())!= null) {
					article += line;
				}
				
				File file = new File("test.txt"); 
				FileWriter fw = new FileWriter(file);
				fw.write(article);
				fw.close();
				
				return article;
			}*/
			
			
				
			public int getCount(String content,Keyword k){
				int count = 0;
				int index = -1;
				int keywordNumber = 0;
				
				content = content.toUpperCase();
				String keyword = k.getName().toUpperCase();
				
		
				while(index != 0){
					
					index = content.indexOf(keyword,index);
					
					index++;
			
					keywordNumber++;
				}
				
				count = (keywordNumber-1)*k.getCount();
				
				
				return count;
				
			}
			
			/*private <T> void print(T s){
				System.out.println(s);
			}*/

		
}
