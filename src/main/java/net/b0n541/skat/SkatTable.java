package net.b0n541.skat;

public class SkatTable {
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		for (int i = 0; i < 100; i++) {
			Thread thread = new Thread(new SkatSeries(i));
			thread.start();
		}
	}
}
