package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base;

import org.bukkit.event.Cancellable;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 30 Jan 2015 (17:43:31)
 */
public class CancellableArenaEvent extends ArenaEvent implements Cancellable {
	private boolean cancelled;

	/**
	 * Constructor of {@link CancellableArenaEvent cancellable arena
	 * event}. Uses main constructor (
	 * {@link #CancellableArenaEvent(DTMPlayer, Arena, boolean) this}
	 * ) and sets cancelled to false.
	 * 
	 * @param <b>({@link DMTPlayer DMT}) player</b> invoked in this
	 *        event.
	 * @param <b>{@link Arena}</b> on which it happened.
	 */
	public CancellableArenaEvent( final Arena arena ) {
		this( arena, false );
	}

	/**
	 * Main constructor of {@link CancellableArenaEvent cancellable
	 * arena event}
	 * 
	 * @param <b>({@link DMTPlayer DMT}) player</b> invoked in this
	 *        event.
	 * @param <b>{@link Arena}</b> on which it happened.
	 * @param <b>cancelled</b> whether the event is cancelled or not
	 */
	public CancellableArenaEvent( final Arena arena, final boolean cancelled ) {
		super( arena );

		this.cancelled = cancelled;
	}

	@Override
	public boolean isCancelled ( ) {
		return cancelled;
	}

	@Override
	public void setCancelled ( final boolean cancelled ) {
		this.cancelled = cancelled;
	}
}
