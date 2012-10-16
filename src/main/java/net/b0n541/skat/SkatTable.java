package net.b0n541.skat;

import java.util.Random;

public class SkatTable {
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		SkatSeries lastSeries = null;
		for (int i = 0; i < 1; i++) {
			lastSeries = new SkatSeries(i);
			lastSeries.start();
		}

		Random random = new Random();
		Thread.sleep(random.nextInt(2000));
		lastSeries.interrupt();
	}
}
