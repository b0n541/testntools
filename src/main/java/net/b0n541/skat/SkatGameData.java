package net.b0n541.skat;

import java.util.HashMap;
import java.util.Map;

public class SkatGameData {
	final Map<Player, Integer> playerPoints;

	public SkatGameData() {
		playerPoints = new HashMap<Player, Integer>();
		for (Player player : Player.values()) {
			playerPoints.put(player, 0);
		}
	}

	public void setPlayerPoints(Player player, Integer newPoints) {
		playerPoints.put(player, newPoints);
	}

	public void addPlayerPoints(Player player, Integer pointsToAdd) {
		playerPoints.put(player, playerPoints.get(player) + pointsToAdd);
	}

	public void subPlayerPoints(Player player, Integer pointsToSub) {
		playerPoints.put(player, playerPoints.get(player) - pointsToSub);
	}
}
