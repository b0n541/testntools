package net.b0n541.skat;

public class SkatSeries extends Thread {

	final static int MAX_NO_OF_GAMES = 1000;
	private final int tableNo;

	public SkatSeries(int tableNo) {
		this.tableNo = tableNo;
	}

	@Override
	public void run() {
		for (int i = 0; i < MAX_NO_OF_GAMES && !isInterrupted(); i++) {
			System.out.println("Table " + tableNo + " Running game no. "
					+ (i + 1));
			SkatGame skatGame = new SkatGame(tableNo, i + 1);
			try {
				skatGame.run();
			} catch (InterruptedException e) {
				this.interrupt();
			}
		}
		System.out.println("Table " + tableNo + " Skat series FINISHED");
	}

	public void stopThread(Thread thread) {
		thread.interrupt();
	}
}
