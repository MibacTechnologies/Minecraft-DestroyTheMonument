package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Block;

import org.bukkit.Location;
import org.bukkit.event.Cancellable;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 30 Jan 2015 (17:43:31)
 */
public class CancellableArenaBlockEvent extends ArenaBlockEvent implements
		Cancellable {
	private boolean cancelled;

	/**
	 * Constructor of {@link CancellableArenaBlockEvent cancellable
	 * arena location event}. Uses main constructor (
	 * {@link #CancellableArenaEvent(DTMPlayer, Arena, boolean) this}
	 * ) and sets cancelled to false.
	 * 
	 * @param <b>({@link DMTPlayer DMT}) player</b> invoked in this
	 *        event.
	 * @param <b>{@link Arena}</b> on which it happened.
	 */
	public CancellableArenaBlockEvent( final DTMPlayer player,
			final Location location ) {
		this( player, location, false );
	}

	/**
	 * Main constructor of {@link CancellableArenaBlockEvent
	 * cancellable arena location event}
	 * 
	 * @param <b>({@link DMTPlayer DMT}) player</b> invoked in this
	 *        event.
	 * @param <b>{@link Arena}</b> on which it happened.
	 * @param <b>cancelled</b> whether the event is cancelled or not
	 */
	public CancellableArenaBlockEvent( final DTMPlayer player,
			final Location location, final boolean cancelled ) {
		super( player, location );
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
