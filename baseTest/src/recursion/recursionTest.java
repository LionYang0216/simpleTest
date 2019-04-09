package recursion;

//递归算法
public class recursionTest {
	
	public static void main(String[] args ) {
		int testNum=add(10);
		System.out.println(testNum);
	}
	
	//计算 0-N相加的总和
	public static int add(int num) {
		if(num==1) {
			return 1;
		}else {
			return num+add(num-1);
		}
		
	}

}
