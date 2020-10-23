package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
//import org.junit.jupiter.api.Test;
import org.testng.annotations.Test;

import com.example.demo.entity.User;

class WebTest {
	FirefoxDriver driver;
	User user = new User();
	@BeforeTest
	void initialize() {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		File file = new File("testcase.txt");
		try {
			Scanner reader = new Scanner(file);
			user.setUserId(0);
			user.setEmail(reader.nextLine());
			user.setUsername(reader.nextLine());
			user.setPassword(reader.nextLine());
			reader.close();
		} catch (FileNotFoundException e) {
			Assert.fail("File Doesn't Exist");
		}
	}
	
	@Test
	void login() {
		driver.get("http://localhost:4200/");
		
		driver.close();
	}
	
	@Test(dependsOnMethods="login")
	void register() {
		driver.get("http://localhost:4200/");
		
		driver.close();
	}
}
