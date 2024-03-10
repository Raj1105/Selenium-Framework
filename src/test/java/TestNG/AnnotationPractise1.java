package TestNG;

import org.testng.annotations.Test;

public class AnnotationPractise1 {
	
	@Test
	public void maruti() {
		System.out.println("Maruti Suzuki franchise");
	}
	
	@Test
	public void ferrari() {
		System.out.println("Ferrari franchise");
	}
	
	@Test(groups= {"smoke"})
	public void jaguar() {
		System.out.println("Ratan Tata franchise");
	}

}
