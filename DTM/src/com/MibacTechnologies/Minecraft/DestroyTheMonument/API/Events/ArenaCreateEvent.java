package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Modification.CancellableArenaModificationEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * Cancellable
 * 
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (12:28:10)
 */
public class ArenaCreateEvent extends CancellableArenaModificationEvent {
	/**
	 * Constructor of {@link ArenaCreateEvent arena event}
	 * 
	 * @param arena
	 *            - not existing yet arena (easier way of giving
	 *            data).
	 */
	public ArenaCreateEvent( final Arena arena ) {
		this( arena, false );
	}

	/**
	 * Main constructor of {@link ArenaCreateEvent arena event}
	 * 
	 * @param arena
	 *            - not existing yet arena (easier way of giving
	 *            data).
	 */
	public ArenaCreateEvent( final Arena arena, final boolean cancelled ) {
		super( arena, cancelled );
	}
}
