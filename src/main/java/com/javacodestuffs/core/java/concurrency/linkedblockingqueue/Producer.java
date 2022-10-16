package com.javacodestuffs.core.java.concurrency.linkedblockingqueue;

import java.util.concurrent.*;
import java.util.*;

class Producer implements Runnable {

	private BlockingQueue<Integer> queue;

	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public void run() {

		try {

			for (int i = 0; i < 10; i++) {

				Integer number = produce();

				queue.put(number);

				System.out.println("Producer: created " + number);

			}

			queue.put(-1); // indicates end of producing

			System.out.println("Producer : STOPPED.");

		} catch (InterruptedException ie) {

			ie.printStackTrace();

		}
	}

	private Integer produce() {
		Random random = new Random();

		Integer number = random.nextInt(100);
		try {
			Thread.sleep(random.nextInt(1000));
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

		return number;
	}
}