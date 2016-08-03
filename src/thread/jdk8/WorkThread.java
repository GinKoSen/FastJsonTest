package thread.jdk8;

import java.util.function.Consumer;

/**
 *
 * @author ginko.wang
 * @date 2016年6月19日 下午4:23:18
 */
public class WorkThread {

	private long id;
	private String name;
	private WorkThread instance;
	private Consumer<WorkThread> proccess;
	private Consumer<WorkThread> error;
	private Consumer<WorkThread> complete;

	public WorkThread() {
		this.instance = this;
		this.id = System.currentTimeMillis() + Math.round(Math.random() * 10000000);
		this.name = String.format("Thread:%d", id);
	}

	public WorkThread(String name) {
		super();
		this.instance = this;
		this.id = System.currentTimeMillis() + Math.round(Math.random() * 10000000);
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public WorkThread proccess(Consumer<WorkThread> proccess) {
		this.proccess = proccess;
		return this;
	}

	public WorkThread error(Consumer<WorkThread> error) {
		this.error = error;
		return this;
	}

	public WorkThread complete(Consumer<WorkThread> complete) {
		this.complete = complete;
		return this;
	}

	public void run() {
		if (instance.proccess == null) {
			throw new IllegalArgumentException("proccess callback can't be null");
		}
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					instance.proccess.accept(instance);
				} catch (Exception e) {
					if (instance.error != null) {
						instance.error.accept(instance);
					}
				} finally {
					if (instance.complete != null) {
						instance.complete.accept(instance);
					}
				}
			}
		}).start();
	}
}
