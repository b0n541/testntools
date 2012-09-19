package net.b0n541.skat;

import java.math.BigDecimal;
import java.util.Random;


public class SkatGame {

	private int gameNo;
	private int tableNo;
	
	private Random rand = new Random();

	public SkatGame(int tableNo, int gameNo) {
		this.tableNo = tableNo;
		this.gameNo = gameNo;
	}
	
	public void run() throws InterruptedException {
		dealCards();
		playTricks();
		calcResult();
	}

	private void calcResult() {
		System.out.println("Table " + tableNo + " Game " + gameNo + ": Calculating result.");
		doRandomTask();
	}

	private void doRandomTask() {
		BigDecimal result = new BigDecimal(0);
		int max = rand.nextInt(100);
		for (int i = 0; i < max; i++) {
			result = result.add(new BigDecimal(i));
		}
		System.out.println(result);
	}

	private void playTricks() {
		System.out.println("Table " + tableNo + " Game " + gameNo + ": Playing tricks.");
		doRandomTask();
	}

	private void dealCards() {
		System.out.println("Table " + tableNo + " Game " + gameNo + ": Dealing cards.");
		doRandomTask();
	}
}