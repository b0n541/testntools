package net.b0n541.skat;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SkatGameTest {
	@Test
	public void completeRun() throws InterruptedException {
		SkatGame game = new SkatGame(1, 1);

		game.run();

		assertEquals(30, game.gameMoves.size());
		assertEquals(29, game.currentMoveIndex);
		assertEquals(100, game.data.playerPoints.get(Player.FORE_HAND)
				.intValue());
		assertEquals(100, game.data.playerPoints.get(Player.MIDDLE_HAND)
				.intValue());
		assertEquals(100, game.data.playerPoints.get(Player.REAR_HAND)
				.intValue());
	}

	@Test
	public void moveBackward() throws InterruptedException {
		SkatGame game = new SkatGame(1, 1);

		game.run();

		game.moveBackward(3);

		assertEquals(30, game.gameMoves.size());
		assertEquals(26, game.currentMoveIndex);
		assertEquals(90, game.data.playerPoints.get(Player.FORE_HAND)
				.intValue());
		assertEquals(90, game.data.playerPoints.get(Player.MIDDLE_HAND)
				.intValue());
		assertEquals(90, game.data.playerPoints.get(Player.REAR_HAND)
				.intValue());
	}

	@Test
	public void moveBackwardComplete() throws InterruptedException {
		SkatGame game = new SkatGame(1, 1);

		game.run();

		game.moveBackward(1000000);

		assertEquals(30, game.gameMoves.size());
		assertEquals(-1, game.currentMoveIndex);
		assertEquals(0, game.data.playerPoints.get(Player.FORE_HAND).intValue());
		assertEquals(0, game.data.playerPoints.get(Player.MIDDLE_HAND)
				.intValue());
		assertEquals(0, game.data.playerPoints.get(Player.REAR_HAND).intValue());
	}

	@Test
	public void moveForward() throws InterruptedException {
		SkatGame game = new SkatGame(1, 1);

		game.run();

		game.moveBackward(1000000);
		game.moveForward(3);

		assertEquals(30, game.gameMoves.size());
		assertEquals(2, game.currentMoveIndex);
		assertEquals(10, game.data.playerPoints.get(Player.FORE_HAND)
				.intValue());
		assertEquals(10, game.data.playerPoints.get(Player.MIDDLE_HAND)
				.intValue());
		assertEquals(10, game.data.playerPoints.get(Player.REAR_HAND)
				.intValue());
	}

	@Test
	public void moveForwardComplete() throws InterruptedException {
		SkatGame game = new SkatGame(1, 1);

		game.run();

		game.moveBackward(3);
		game.moveForward(1000000);

		assertEquals(30, game.gameMoves.size());
		assertEquals(29, game.currentMoveIndex);
		assertEquals(100, game.data.playerPoints.get(Player.FORE_HAND)
				.intValue());
		assertEquals(100, game.data.playerPoints.get(Player.MIDDLE_HAND)
				.intValue());
		assertEquals(100, game.data.playerPoints.get(Player.REAR_HAND)
				.intValue());
	}
}
