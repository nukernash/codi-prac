package interview.thread;

public class WorkerThread implements Runnable{
	
	private String msg = null;
	
	WorkerThread(String msg){
		this.msg = msg;
	}

	@Override
	public void run() {
		System.out.println(msg);
	}

}
