package ch02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * {
  "id": 7,
  "name": "Kurtis Weissnat",
  "username": "Elwyn.Skiles",
  "email": "Telly.Hoeger@billy.biz",
  "address": {
    "street": "Rex Trail",
    "suite": "Suite 280",
    "city": "Howemouth",
    "zipcode": "58804-1099",
    "geo": {
      "lat": "24.8918",
      "lng": "21.8984"
    }
  },
  "phone": "210.067.6132",
  "website": "elvis.io",
  "company": {
    "name": "Johns Group",
    "catchPhrase": "Configurable multimedia task-force",
    "bs": "generate enterprise e-tailers"
  }
}
 * */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
	
	private int id;
	private String name;
	private String username;
	private String email;
	private String phone;
	private String website;
	private Address address;
	private Company company;
	


}// end of class



/*
 * address": {
    "street": "Rex Trail",
    "suite": "Suite 280",
    "city": "Howemouth",
    "zipcode": "58804-1099",
    "geo": {
      "lat": "24.8918",
      "lng": "21.8984"
    }
  }
 * */
@Getter
@ToString
class Address{
	
	private String street;
	private String suite;
	private String city;
	private String zipcode;
	private Ged geo;
	
	@Getter
	@ToString
	class Ged{
		
		private String lat;
		private String lng;
		
	}
}

/*
 * "company": {
    "name": "Johns Group",
    "catchPhrase": "Configurable multimedia task-force",
    "bs": "generate enterprise e-tailers"
  }*/
@ToString
class Company{
	
	private String name;
	private String catchPhrase;
	private String bs;
	
}










