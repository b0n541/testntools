package net.b0n541.skat;

public class SkatTable {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Thread thread = new Thread(new SkatSeries(1));
		Thread thread2 = new Thread(new SkatSeries(2));
		Thread thread3 = new Thread(new SkatSeries(3));
		thread.start();
		thread2.start();
		thread3.start();
	}
}
