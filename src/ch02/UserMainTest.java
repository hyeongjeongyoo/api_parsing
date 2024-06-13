package ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class UserMainTest {
	
	
	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/users");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			
			int responseCode = conn.getResponseCode();
			System.out.println("responseCode : " + responseCode);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer buffer = new StringBuffer();
			while( (inputLine = in.readLine()) != null ) {
				buffer.append(inputLine);
			}
			in.close();
			//System.out.println(buffer.toString());
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			// Gson gson = new Gson();
			// User userDTO = gson.fromJson(buffer.toString(), User.class);
			
			Type userType = new TypeToken<List<User>>() {}.getType();
			List<User> userList = gson.fromJson(buffer.toString(), userType);
			//User[] userList = gson.fromJson(buffer.toString(), User[].class);
			
			System.out.println(userList.size());
			for(User u : userList) {
				System.out.println(u.toString());
			}
			
//			System.out.println(userDTO.getId());
//			System.out.println(userDTO.getName());
//			System.out.println(userDTO.getUsername());
//			System.out.println(userDTO.getEmail());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}// end of main
	
}// end of class
