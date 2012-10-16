package net.b0n541.skat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SkatGame {

	private final Random rand = new Random();

	private final int gameNo;
	private final int tableNo;
	final SkatGameData data;

	final List<GameMove> gameMoves;
	int currentMoveIndex;

	public SkatGame(int tableNo, int gameNo) {
		this.tableNo = tableNo;
		this.gameNo = gameNo;
		data = new SkatGameData();
		gameMoves = new ArrayList<GameMove>();
		currentMoveIndex = -1;
	}

	public void run() throws InterruptedException {
		dealCards();
		Thread.sleep(1);
		playTricks();
		Thread.sleep(1);
		calcResult();
		Thread.sleep(1);
	}

	private void calcResult() {
		System.out.println("Table " + tableNo + " Game " + gameNo
				+ ": Calculating result.");
		doRandomTask();
	}

	private void doRandomTask() {
		BigDecimal result = new BigDecimal(0);
		int max = rand.nextInt(100);
		for (int i = 0; i < max; i++) {
			result = result.add(new BigDecimal(i));
		}
	}

	private void playTricks() {
		System.out.println("Table " + tableNo + " Game " + gameNo
				+ ": Playing tricks.");
		for (int i = 0; i < 10; i++) {
			playTrickForeHandCard();
			playTrickMiddleHandCard();
			playTrickRearHandCard();
		}
	}

	private void playTrickForeHandCard() {
		doRandomTask();
		playTrickCard(Player.FORE_HAND);
	}

	private void playTrickCard(Player player) {
		PlayCardMove move = new PlayCardMove(player);
		move.moveForward(data);
		gameMoves.add(move);
		currentMoveIndex = gameMoves.size() - 1;
	}

	private void playTrickMiddleHandCard() {
		doRandomTask();
		playTrickCard(Player.MIDDLE_HAND);
	}

	private void playTrickRearHandCard() {
		doRandomTask();
		playTrickCard(Player.REAR_HAND);
	}

	private void dealCards() {
		System.out.println("Table " + tableNo + " Game " + gameNo
				+ ": Dealing cards.");
		doRandomTask();
	}

	public void moveForward(int noOfMoves) {
		for (int i = 0; i < noOfMoves
				&& currentMoveIndex < gameMoves.size() - 1; i++) {
			currentMoveIndex++;
			gameMoves.get(currentMoveIndex).moveForward(data);
		}
	}

	public void moveBackward(int noOfMoves) {
		for (int i = 0; i < noOfMoves && currentMoveIndex > -1; i++) {
			gameMoves.get(currentMoveIndex).moveBackward(data);
			currentMoveIndex--;
		}
	}

	public boolean indexAtEndOfMoves() {
		return currentMoveIndex == gameMoves.size() - 1;
	}
}
