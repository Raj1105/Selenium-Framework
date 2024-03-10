package javaPractise;

public class countOccurenString {
		public static void main(String[] args) {

		//fibonacci series	
			//0 ,1, 1, 2, 3, 5, 8, 13, 21, 
			//logic a =0, b = 1, c = a+b, a = b , b = c
			int n = 10;
			int a = 0;
			int b = 1;
		
			for (int i =0 ; i< n; i++) {
				
				System.out.print(a + " ");
				int c = a+b;
				a = b;
				b = c;
				
			}
			
			String str = "aabbcceeddyyyiii";
			
			

}
	
	
}
