package Final;


import java.util.ArrayList;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;



public class Webtree {
	
	
			private int total = 0;
			private ArrayList<Web> dataGoogleList;
			private Document xmlDoc;
			

		
			
			public Webtree(DataList dl){
				dataGoogleList = dl.getDataList();

			}
			
			public void set(){
				System.out.println("所有搜尋結果:");
				
				for (Web w : dataGoogleList) {
					
					System.out.println("");

					xmlDoc = w.setRootCount();
					System.out.println(w.toString());
					
					setTree();
					w.setCount(total);
				}	
			}
			
		
			private void setTree(){
				
				
				Elements alinks = xmlDoc.select("a[href]"); 
				String href = "";
				int tmp = 1;
				boolean set = true;
				
				//DataList dList = new DataList();
				System.out.println("\t子網頁:");
				System.out.println("");
				for(int i = 0 ; i < 5 ;i++){
					
					if(alinks.size()-1>i){
						href = alinks.get(i).attr("href").toString();
						if(href.startsWith("javascript:"))
						{
							//this is not a url but a javascript 
							continue;
						}
						if(!href.startsWith("http"))
						{
							//skip hyper link using relative path
							continue;
						}
						
						//System.out.println(stitle.get(i).toString());
						//預設為child+第幾個
						Web w = new Web("child"+tmp, href);
								
						tmp++;
						
						w.setCount();
						
						System.out.println(w.print());
						
						total += w.getCount();
						
						//dList.add(w);
						set = false;
					}
					
				}
				
				if(set){
					System.out.println("\t無");
				}
					
				
			}
			
			
			public void getResult(){
				
				sort(dataGoogleList);
				
				//for(Web w: dataGoogleList){
				//	System.out.println(w.toString());
				//}
				
				//System.out.println("------------------");
				
				for(int i=0;i<5;i++){
					System.out.println(dataGoogleList.get(i).toString());
				}
			}
			
			
			private void sort(ArrayList<Web> list){

				sort(list, 0, list.size()-1);
			}
		
			private void sort(ArrayList<Web> k,int left,int right){

		        if(left < right) { 
		            int q = partition(k, left, right); 
		            sort(k, left, q-1); 
		            sort(k, q+1, right); 
		        } 

		    }

		    private int partition(ArrayList<Web> k, int left, int right) {  
		        int i = left - 1; 
		        for(int j = left; j < right; j++) { 
		            if(k.get(j).getCount() >= k.get(right).getCount()) { 
		                i++; 
		                swap(k, i, j); 
		            } 
		        } 
		        swap(k, i+1, right); 
		        return i+1; 
		    }

		    private void swap(ArrayList<Web> klist, int i, int j) {
		        Web tmpi = klist.get(i); 
		        Web tmpj = klist.get(j); 
		        klist.add(i, tmpj);
		        klist.remove(i+1);
		        klist.add(j, tmpi);
		        klist.remove(j+1);
		    }
}
