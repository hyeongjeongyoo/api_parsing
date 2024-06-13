package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Todos {
	
	public static void main(String[] args) throws IOException {
		
		// 서버 통신하기 위해 서버 주소(경로 준비)
		String urlString = "https://jsonplaceholder.typicode.com/todos";
		
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpsURLConnection)url.openConnection();
			
			conn.setRequestMethod("GET");
			
			int responseCode = conn.getResponseCode();
			System.out.println("HTTP CODE : " + responseCode);
			// 코드 응답 완료
			
			BufferedReader rd;
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			
			StringBuilder sb = new StringBuilder();
			String line;
			while( (line = rd.readLine()) != null ) {
				sb.append(line);
			}
//			System.out.println(sb.toString());
//			System.out.println("-----------------");
			
//			User user = gson.fromJson(sb.toString(), User.class);
//			System.out.println(user.toString());
			
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			User[] userArr = gson.fromJson(sb.toString(), User[].class);
			// User[] userArr = gson.fromJson(gson.toJson(userArr), User[].class);
			for(int i = 0; i < userArr.length; i++) {
				userArr[i].showInfo();
			}
			rd.close();
			conn.disconnect();
		
	}// end of main



	class User {
		int userId;
		int id;
		String title;
		boolean completed;
		
		@Override
		public String toString() {
			return "=========\n User [나는 ~ userId=" + userId + ", id=" + id + ", title=" + title + ", completed=" + completed + "]";
		}
		
		public void showInfo() {
			System.out.println("===================");
			System.out.println("userId : " + userId);
			System.out.println("id : " + id);
			System.out.println("title : " + title);
			System.out.println("completed : " + completed);
		}
		
	}
	
}// end of class
