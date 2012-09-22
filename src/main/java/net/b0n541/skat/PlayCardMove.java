package net.b0n541.skat;

public class PlayCardMove extends AbstractGameMove {

	public PlayCardMove(Player player) {
		super(player);
	}

	public void moveForward(SkatGameData data) {
		data.addPlayerPoints(player, 10);
	}

	public void moveBackward(SkatGameData data) {
		data.subPlayerPoints(player, 10);
	}
}
