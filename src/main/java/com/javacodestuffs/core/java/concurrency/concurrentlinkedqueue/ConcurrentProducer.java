package com.javacodestuffs.core.java.concurrency.concurrentlinkedqueue;

import java.util.Queue;

public class ConcurrentProducer implements Runnable {
	Queue<Integer> conQueue;

	ConcurrentProducer(Queue<Integer> conQueue) {
		this.conQueue = conQueue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 6; i++) {
			System.out.println("Adding element to the queue : " + i);
			conQueue.add(i);
		}
	}
}