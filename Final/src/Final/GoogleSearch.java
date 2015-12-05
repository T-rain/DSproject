package Final;




import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import com.google.gson.Gson;

public class GoogleSearch {
	
	int dataCount = 0;
	DataList datalist;
	String query = "test";
	StringBuilder sb;

	public GoogleSearch(){
		
		this.datalist = new DataList();
	}
	
	public void setQuery(String q){
			
			String s = "樂團";
			this.query = q+" "+s;
	}
	
	
	public void callGoogle()throws Exception{
		
			this.dataCount = 20;
		
			String address = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
			
			String charset = "UTF-8";
			
			int rsz = 5;
			
			
			for (int i = 0; i < dataCount; i = i + 5) {
				
				int start = i;
			    	
			
			    URL url = new URL(address + URLEncoder.encode(query, charset)+"&start="+start+"&rsz="+rsz);
			    Reader reader = new InputStreamReader(url.openStream(), charset);
			    GoogleResults results = new Gson().fromJson(reader, GoogleResults.class);
			    
			    
			
			    //System.out.println("");
			    //System.out.println("搜尋次數");
			    //System.out.println(results);
			    	
			     // Show title and URL of each results
			    int total= results.getResponseData().getResults().size();

			     
				 //System.out.println("total: "+total);
				 for(int j=0; j<=total-1; j++){
					
					String title = results.getResponseData().getResults().get(j).getTitle();
					String urlResult = results.getResponseData().getResults().get(j).getUrl();
					
					
					//將title的<b></b>消除
					StringBuilder sb = new StringBuilder(title);
					int tagBegin = -1;
					while(true){
					tagBegin = sb.indexOf("<b>");
						if(tagBegin == -1){
							//print(tagBegin);//<b>
							break;
						}			
					sb.replace(tagBegin,tagBegin+3,"");
					tagBegin = sb.indexOf("</b>");
					sb.replace(tagBegin,tagBegin+4,"");				
					}
					title = sb.toString();
					
					Web w = new Web(title, urlResult);
					datalist.add(w);
					
					
					//System.out.println("Title: " + datalist.get(j).getTitle());
					//System.out.println("URL: " + datalist.get(j).getUrl() + "\n");
				 }
				 
			}
	}
	
	
	//取得資料
	public DataList getData(){
		return datalist;
	}
	
 //   private <T> void print(T s){
 //   	System.out.println(s);
 //   }
    
}
 
 
class GoogleResults{
 
    private ResponseData responseData;
    
    public ResponseData getResponseData() { 
    	return responseData; 
    }
    
    public void setResponseData(ResponseData responseData) { 
    	this.responseData = responseData; 
    }
    
    public String toString() { 
    	return "ResponseData[" + responseData + "]"; 
    }
 
    
    
    static class ResponseData {
        private ArrayList<Result> results;
        public ArrayList<Result> getResults() {
  
        		return results; 
        }
        public void setResults(ArrayList<Result> results) { 
        	this.results = results; 
        }
        public String toString() { 
        	return "Results[" + results + "]"; 
        }
    }
 
    
    static class Result {
        private String url;
        private String title;
        
        public String getUrl() {
        	return url; 
        }
        public String getTitle() { 
        	return title; 
        }
        public void setUrl(String url) {
        	this.url = url; 
        }
        public void setTitle(String title) { 
        	this.title = title; 
        }
        public String toString() { 
        	return "Result[url:" + url +",title:" + title + "]"; 
        }
    }
    
    

}


