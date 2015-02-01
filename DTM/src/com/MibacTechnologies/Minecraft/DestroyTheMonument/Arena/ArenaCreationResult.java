package com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (11:18:03)
 */
public class ArenaCreationResult {
	private final Arena arena;
	private final int id;
	private final boolean successful;

	public ArenaCreationResult( final Arena arena, final int id,
			final boolean successful ) {
		this.arena = arena;
		this.id = id;
		this.successful = successful;
	}

	/**
	 * @return arena if successful, otherwise <b>null</b>
	 */
	public Arena getArena ( ) {
		return arena;
	}

	/**
	 * @return id of new arena if successful, otherwise <b>-1</b>
	 */
	public int getId ( ) {
		return id;
	}

	/**
	 * @return true if successful, otherwise false
	 */
	public boolean wasSuccessful ( ) {
		return successful;
	}
}
