package com.royall.sms;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 
 * Example: java LoadTest 500 500000 https://rms.royall.com
 * 
 */

public class LoadTest {

	/**
	 * args [0] = poolSize
	 * args [1] = testSize
	 * args [2] = URL
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int poolSize = 1;
		int testSize = 1;
		String URL = "http://api.royall.dev/twilio/v1/setstatus/?from=%2B18044090944&to=%2B18048737818&smsstatus=QUEUED";
		
		if (args[0] != null) {
			poolSize = Integer.parseInt(args[0]);
		}
		if (args[1] != null) {
			testSize = Integer.parseInt(args[1]);
		}
		if (args[2] != null) {
			URL = args[2];
		}
		
		
		System.out.println(String.format("Initializing thread pool with %s executors", poolSize));
		System.out.println(String.format("Initializing URL with %s", URL));

		ExecutorService threadPool = Executors.newFixedThreadPool(poolSize);

		final long startTime = System.currentTimeMillis();
		System.out.println(String.format("Started executing %s status updates at %s", testSize, new Date()));

		for (int a = 0; a < testSize; a++) {
			final String URLfinal = URL;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						URLConnection conn = new URL(
								URLfinal)
										.openConnection();
						System.out.println(conn.getHeaderFields());
						InputStream response = conn.getInputStream();
						try (Scanner scanner = new Scanner(response)) {
							String responseBody;
							while (scanner.hasNext()) {
								responseBody = scanner.next();
								System.out.println(responseBody);
							}
						}

						response.close();
					} catch (IOException e) {
						System.out.println(String.format("Caught exception at %s", Duration.ofMillis(System.currentTimeMillis() - startTime)));
//						e.printStackTrace();
					}
				}
			});
		}

		System.out.println(
				"Finished adding load to thread pool. Waiting for threadPool.awaitTermination()... (10 minute timeout)");

		try {
			threadPool.shutdown();
			threadPool.awaitTermination(10, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			System.out.println("threadPool.awaitTermination() was interrupted.");
			e.printStackTrace();
		}

		System.out.println(String.format("Thread pool shutdown complete after %s.", Duration.ofMillis(System.currentTimeMillis() - startTime)));
	}
}