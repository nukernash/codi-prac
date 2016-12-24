package com.nukernash.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ThreadPoolExecutor {
	

	public static void main(String[] args) {
		
		Executor executor = Executors.newFixedThreadPool(5, new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable r) {
				Thread t = new Thread(new WorkerThread("hi..!"));
				return t;
			}
		});
		
		for(int i=0; i<10; i++){
			System.out.println("in for loop");
			executor.execute(new WorkerThread("" + i));
		}
	}

}
