package net.b0n541.skat;

public class SkatSeries implements Runnable {

	final static int MAX_NO_OF_GAMES = 3;
	private int tableNo;
	
	public SkatSeries(int tableNo) {
		this.tableNo = tableNo;
	}
	
	public void run() {
		for (int i = 0; i < MAX_NO_OF_GAMES; i++) {
			System.out.println("Table " + tableNo + " Running game no. " + (i+1));
			SkatGame skatGame = new SkatGame(tableNo, i+1);
			try {
				skatGame.run();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Table " + tableNo + " Skat series FINISHED");
	}
}
