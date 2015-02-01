package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Entity.Player;

import org.bukkit.event.Cancellable;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.CancellableArenaEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (12:44:19)
 */
public class CancellableArenaPlayerEvent extends ArenaPlayerEvent implements
		Cancellable {
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
	public CancellableArenaPlayerEvent( final DTMPlayer player ) {
		this( player, false );
	}

	/**
	 * Main constructor of {@link CancellableArenaPlayerEvent
	 * cancellable arena player event}
	 * 
	 * @param <b>({@link DMTPlayer DMT}) player</b> invoked in this
	 *        event.
	 * @param <b>{@link Arena}</b> on which it happened.
	 * @param <b>cancelled</b> whether the event is cancelled or not
	 */
	public CancellableArenaPlayerEvent( final DTMPlayer player,
			final boolean cancelled ) {
		super( player );
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
