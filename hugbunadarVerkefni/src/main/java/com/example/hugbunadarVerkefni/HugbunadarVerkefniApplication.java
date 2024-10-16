package com.example.hugbunadarVerkefni;

import com.example.hugbunadarVerkefni.service.Login;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HugbunadarVerkefniApplication {

	public static void main(String[] args) {

		Login loginSystem = new Login();
		Users usersSystem = new Users();

		String testUser = "Admin";
		String testPassword ="Admin123";

		String testFailUser = "Admin";
		String testFailPassword ="dmin123";

		if (loginSystem.validateLogin(testUser, testPassword)) {
			System.out.println("Login successful! Welcome, " + testUser);
		} else {
			System.out.println("Login failed. Invalid username or password.");
		}

		if (loginSystem.validateLogin(testFailUser, testFailPassword)) {
			System.out.println("Fail Login successful! Welcome, " + testFailUser);
		} else {
			System.out.println("Fail Login failed. Invalid username or password.");
		}
		if (usersSystem.getUser(testUser) == testUser) {
			System.out.println("virkar");
		} else {
			System.out.println("virkar ekki");
		}

		if (usersSystem.getUser(testFailUser) == testUser) {
			System.out.println("virkar ekki");
		} else {
			System.out.println("virkar");
		}




		SpringApplication.run(HugbunadarVerkefniApplication.class, args);
	}

}
