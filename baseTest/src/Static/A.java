package Static;

public class A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Swap(1,2);
	}
	
	
	public static void printA() {
		System.out.println("this is class A");
	}
	
	 public static void Swap(int a,int b){

	      int c=a;

	      a=b;

	      b=c;

	      System.out.println("a: "+a);

	      System.out.println("b: "+b);

	   }

}
