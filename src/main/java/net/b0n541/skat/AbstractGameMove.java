package net.b0n541.skat;

public abstract class AbstractGameMove implements GameMove {

	protected final Player player;

	public AbstractGameMove(Player player) {
		this.player = player;
	}
}
