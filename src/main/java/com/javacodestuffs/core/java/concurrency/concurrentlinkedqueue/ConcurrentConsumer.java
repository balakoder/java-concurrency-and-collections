package com.javacodestuffs.core.java.concurrency.concurrentlinkedqueue;

import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class ConcurrentConsumer implements Runnable {
	Queue<Integer> conQueue;

	ConcurrentConsumer(Queue<Integer> conQueue) {
		this.conQueue = conQueue;
	}

	@Override
	public void run() {

		for (int i = 0; i < 3; i++) {
			try {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println("Thread Name -" + Thread.currentThread().getName() + " Consumer retrieved element : "
						+ conQueue.poll());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}