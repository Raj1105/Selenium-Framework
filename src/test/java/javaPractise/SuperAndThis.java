package javaPractise;

class n{
	public n(){
		
		System.out.println("Parent class");
	}
	public n(int a) {
	
		System.out.println("Parent class with parameter");
	}
	}

class b extends n{
	public b(int c, int d){
		this(d);
		System.out.println("Child class*******");
	}
	public b(int a){
		
		System.out.println("Child class with parameter");
	}
}



public class SuperAndThis {
	
	
	
	public static void main(String[] args) {
		b oj = new b(6, 7);

	}

}
