package TestNG;

import org.testng.annotations.Test;

public class AnnotationPractise2 {
	@Test(groups= {"smoke"})
	public void bseStockMarket() {
		System.out.println("Indian stock Market");
	}
	
	@Test
	public void dowJon() {
		System.out.println("USA stock Market");
	}
	
	@Test
	public void KseStockMarket() {
		System.out.println("Pakistan Stock Market");
	}

}
