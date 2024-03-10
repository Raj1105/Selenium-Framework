package javaPractise;

public class primeNumber {

	public static void main(String[] args) {
		int n = 20;
		int i=0;
		while (i <n) {
			if(checkPrime(i)) {
				System.out.print(i + " ");
			}
			i++;
		}

	}
	
	public static boolean checkPrime(int n) {
		int temp = 0;
		
		if(n == 0) {
			return false;
		}
		for (int i=2; i<n-1; i++) {
			if (n%i ==0) {
			temp += 1;
			}
			
		}
		if(temp > 0) {
			return false;
		}
		else {
			return true;
		}
		
	}

}
