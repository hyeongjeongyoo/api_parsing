package ch01;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonExample {

	public static void main(String[] args) {
		
		Student student1 = new Student("고길동", 40, "애완학과");
		Student student2 = new Student("둘리", 5, "문제학과");
		
		Student[] studentArr = {student1, student2};
		
		// -> 특정 형식 (구조화) 되어 있는 문자열로 변환하고 싶다 -> JSON 형태
		// Gson gson = new Gson();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		// 객체를 -> json 형식의 문자열로 변환 시켜! -> 메서드 toJSon();
		String student1Str = gson.toJson(student1);
		System.out.println(student1Str);
		
		// setPrettyPrinting -> 예쁘게 출력하라 옵션
		Gson gson2 = new Gson();
		String student2Str = gson.toJson(student2);
		System.out.println(student2Str);
		
		// 객체에서 -> 문자열 형태로 가능 그럼 반대로는 어떻게 하지?
		// 문자열에서 -> 클래스 형태로 어떻게 변경할까?
		Student studentObject = gson.fromJson(student1Str, Student.class);
		System.out.println(studentObject.getName());
		
	}//end of main
	
}// end of class
