package com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena;


/**
 * Enum made for indicating whether is the arena on or off.
 * 
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 2 Feb 2015 (15:51:45)
 */
public enum ArenaMode {
	ENABLED ( 1 , true ), DISABLED ( 0 , false );
	private final int id;
	private final boolean playable;

	private ArenaMode( final int id, final boolean playable ) {
		this.id = id;
		this.playable = playable;
	}

	public int getId ( ) {
		return id;
	}

	public boolean isPlayable ( ) {
		return playable;
	}
}
