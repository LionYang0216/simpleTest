package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class callableTest {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		Task task = new Task();
		Future<Integer> future = executor.submit(task);
		executor.shutdown();
		
		//System.out.println(future.get(10000));

		/**
		 * 接下来就可以通过future来获取一些关于Task的运行信息了： 比如：future.get();来获取最后执行结果
		 * future.isDown();来判断是否完成 等等...
		 **/

	}

}

class Task implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		int sum = 0;
		// do something;
		return sum;
	}
}
