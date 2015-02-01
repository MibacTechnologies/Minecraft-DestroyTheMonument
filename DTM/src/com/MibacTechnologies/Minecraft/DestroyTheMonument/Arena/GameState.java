package com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (18:08:34)
 */
public enum GameState {
	WAITING ( 1 ), STARTING ( 2 ), INGAME ( 3 );

	private int id;

	private GameState( final int id ) {
		this.id = id;
	}

	public int getId ( ) {
		return id;
	}
}
