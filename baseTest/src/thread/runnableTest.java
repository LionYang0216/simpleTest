package thread;

public class runnableTest {

	
	//https://blog.csdn.net/liangrui1988/article/details/52490464
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("start-----");
		new Thread(new Runnable() {
			public void run() {
				System.out.println(Test("第一次调用", 10000));// 10秒
			}
		}).start();
		
		System.out.println("----");
		new Thread(new Runnable() {
			public void run() {
				System.out.println(Test("第二次调用", 1000));// 1秒
			}
		}).start();
		System.out.println("end-----");

	}
	
	// 全局数字，非线程安全
	static int Global = 100;
 
	// 加或不加的区别 synchronized
	//加了synchronized后，每二个线程一直等待，第一个线程执行过完后才开始工作
	// 不加 会出现
	public static synchronized String Test(String a, int b) {
		int s = 100;
		s++;
		Global++;
		try {
			System.out.println("等待:" + b);
			Thread.sleep(b);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
 
		return a + ">>方法里s:" + s + "全局Global：" + Global;
 
	}

}
