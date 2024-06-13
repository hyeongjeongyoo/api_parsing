package ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class MyHttpAlbumClient {
	
	public static void main(String[] args) {
		
		// 순수 자바 코드에서 HTTP 통신
		// 1. 서버 주소 경로
		// 2. URL 클래스
		// 3. url.openConnection() <- 스트림 I/O
		// 자원 요청 -> get
		
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/albums/1");
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			
			// 응답 코드 확인
			int responseCode = conn.getResponseCode();
			System.out.println("response code : " + responseCode); // 요청 완료 -> 응답 -> 200 이면 성공, 400 / 405 실패 , 500 서버 자체의 연산이 잘못된 것
			
			// HTTP 응답 메세지에 데이터를 추출[] -> Stream -> []
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer buffer = new StringBuffer(); // . 연산자를 사용하려면 객체 생성해야됨
			while( (inputLine = in.readLine()) != null) {
				buffer.append(inputLine);
			}
			in.close();
			System.out.println(buffer.toString());
			System.err.println("-----------------------------------------------------------------");
			// gson lib 활용
			// Gson gson = new Gson();
			Gson gson = new GsonBuilder().setPrettyPrinting().create(); // 예쁘게 출력
			Album albumDTO = gson.fromJson(buffer.toString(), Album.class);
			
			System.out.println(albumDTO.getId());
			System.out.println(albumDTO.getUseId());
			System.out.println(albumDTO.getTitle());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}// end of main

}// end of class
