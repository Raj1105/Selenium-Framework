package TestNG;

import org.testng.annotations.Test;

public class AnnotationPractise {

	@Test(enabled=false)
	public void login() {
		System.out.println("Login to gmail");
		 
	}
	
	@Test
	public void homePage() {
		System.out.println("gmail page");
		
	}
	
	@Test()
	public void composeGmail() {
		System.out.println("Write a email ");
	}
	@Test
	public void composeGmail1() {
		System.out.println("Test compose 1..... ");
	}
	@Test
	public void composeGmail2() {
		System.out.println("Test compose 2..... ");
	}
	@Test
	public void composeGmail3() {
		System.out.println("Test compose 3.....  ");
	}
	@Test
	public void composeGmail4() {
		System.out.println("Test compose 4.....  ");
	}
}
