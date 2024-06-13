package ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
 * 배열 사용*/
public class MyHttpPhotoClient {

	
	public static void main(String[] args) {
		
		// 순수 자바 코드에서 HTTP 통신
		// 1. 서버 주소 경로
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/photos");
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			
			// 응답 코드 확인
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);
			
			// HTTP 응답 메세지에 데이터를 추출 -> stream
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer buffer = new StringBuffer();
			while( (inputLine = in.readLine()) != null ) {
				buffer.append(inputLine);
			}
			in.close();
			System.out.println(buffer.toString());
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			photo[] photoDTO = gson.fromJson(buffer.toString(), photo[].class);
			
			for(photo photo1 : photoDTO) {
				System.out.println(photo1.toString());
			}
			
			System.out.println(photoDTO.toString());
			
//			System.out.println(photoDTO.getAlbumId());
//			System.out.println(photoDTO.getId());
//			System.out.println(photoDTO.getTitle());
//			System.out.println(photoDTO.getUrl());
//			System.out.println(photoDTO.getThumbnailUrl());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 2. URL 클래스
		// 3. url.openConnection() <- 스트림 I/O
		
		
	}// end of main
	
}// end of class
