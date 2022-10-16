package com.javacodestuffs.core.java.concurrency.concurrentlinkedqueue;
import java.util.concurrent.*;
import java.util.*;
public class ConcurrentLinkedQueueExample {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(4);
		Queue <Integer>  conQueue = new ConcurrentLinkedQueue <Integer> ();

		// One Producer thread
		executor.execute(new ConcurrentProducer(conQueue));
		// Two Consumer thread
		System.out.println();
		executor.execute(new ConcurrentConsumer(conQueue));
		executor.execute(new ConcurrentConsumer(conQueue));
		System.out.println();
		executor.shutdown();
	}
}