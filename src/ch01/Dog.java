package ch01;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dog{
	
	private String name;
	private String color;
	private int age;
	
	public static void main(String[] args) {
		Dog dog1 = new Dog("비숑", "흰색", 2);
		Dog dog2 = new Dog("푸들", "갈색", 3);
		
		Dog[] dogArr = {dog1, dog2};
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String dog1Str = gson.toJson(dog1);
		System.out.println(dog1Str);
		

	
		
	}// end of main

}// end of class
