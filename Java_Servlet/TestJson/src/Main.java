import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
	public static void main(String[] args) {
		String strUrl = "http://localhost:8080/Section_08_MVC/product"; 
		 
		HttpURLConnection connection = null; 
		InputStream in = null; 
		InputStreamReader inReader = null; 
		BufferedReader br = null; 
		 
		try { 
		 URL url = new URL(strUrl); 
		
		 // Connection を取得
		 connection = (HttpURLConnection) url.openConnection();  
		 connection.setRequestMethod("GET");  
		 connection.connect(); 
		 
		
		 int iStatus = connection.getResponseCode(); 
		 if (iStatus == HttpURLConnection.HTTP_OK) {   
			 in = connection.getInputStream(); 
		 
		  inReader = new InputStreamReader(in); 
		  br = new BufferedReader(inReader); 
		 
		  
		  String strLine; 
		  StringBuilder sbSentence = new StringBuilder();   // 1 行ずつテキストを読み込む 
		  while ((strLine = br.readLine()) != null) { 
		    sbSentence.append(strLine); 
		  } 
		 
		  // JSON オブジェクトのインスタンス作成   
		  JSONArray jsonArray = new JSONArray(sbSentence.toString()); 
		  for(int i = 0 ; i < jsonArray.length();i++) {
			  JSONObject item = jsonArray.getJSONObject(i);
			  System.out.println(item.get("productname"));
		  }
		
		 } 
		 
		} catch (IOException e) { 
		 e.printStackTrace(); 
		} finally { 
		 try { 
		  if (br != null) { 
		   br.close(); 
		  } 
		  if (inReader != null) { 
		   inReader.close(); 
		  } 
		  if (in != null) { 
		   in.close(); 
		  } 
		  if (connection != null) { 
		   connection.disconnect(); 
		  } 
		 } catch (IOException e) { 
		  e.printStackTrace(); 
		 } 
		} 

	}
}
