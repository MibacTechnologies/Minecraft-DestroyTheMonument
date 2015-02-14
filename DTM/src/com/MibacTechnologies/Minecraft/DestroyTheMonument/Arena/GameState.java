package com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (18:08:34)
 */
public enum GameState {
	/**
	 * Arena in lobby, not starting (countdown not running)
	 */
	WAITING ( 1 ),
	/**
	 * Arena is in countdown mode - starting
	 */
	STARTING ( 2 ),
	/**
	 * Arena is in game (name says it all)
	 */
	INGAME ( 3 ),
	/**
	 * It is used when arena isn't {@link ArenaMode#ENABLED}.
	 */
	OTHER ( -1 );

	private int id;

	private GameState( final int id ) {
		this.id = id;
	}

	/**
	 * @return state's id
	 */
	public int getId ( ) {
		return id;
	}
}
