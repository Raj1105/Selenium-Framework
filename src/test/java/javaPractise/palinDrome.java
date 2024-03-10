package javaPractise;

public class palinDrome {

	public static void main(String[] args) {
		int x = 153;
		
		int temp = x;
		int rev= 0, rem;
		
		while (temp != 0) {
			rem = temp%10;
			rev = rev * 10 + rem;
			temp = temp/10;
			
		}
		
		if(x == rev) {
			System.out.println("no is palindrome");
		}
		else {
			System.out.println("is not palindrome");
		}

	}

}
