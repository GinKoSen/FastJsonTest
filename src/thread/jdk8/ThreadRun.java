package thread.jdk8;

/**
 *
 * @author ginko.wang
 * @date 2016年6月19日 下午4:22:35
 */
public class ThreadRun {
	public static void main(String[] args) {
		WorkThread thread1 = new WorkThread("Thread:1");
		WorkThread thread2 = new WorkThread("Thread:2");
		WorkThread thread3 = new WorkThread("Thread:3");
		thread1.proccess((item1) -> {
			System.err.println(item1.getName() + ",proccess");
		}).complete((item1) -> {
			System.err.println(item1.getName() + ",complete");
			thread2.proccess((item2) -> {
				System.err.println(item2.getName() + ",proccess");
			}).complete((item2) -> {
				System.err.println(item2.getName() + ",complete");
				thread3.proccess((item3) -> {
					System.err.println(item3.getName() + ",proccess");
				}).complete((item3) -> {
					System.err.println(item3.getName() + ",complete");
				}).run();
			}).run();
		}).run();
	}
}
