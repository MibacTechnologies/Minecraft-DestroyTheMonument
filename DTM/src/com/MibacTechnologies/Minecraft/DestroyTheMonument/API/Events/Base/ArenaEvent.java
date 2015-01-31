package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * Main class for arena events.
 * 
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 30 Jan 2015 (16:50:53)
 */
public class ArenaEvent extends Event {
	private static final HandlerList handlers = new HandlerList( );
	private final Arena arena;

	/**
	 * Main constructor of {@link ArenaEvent arena event}
	 * 
	 * @param <b>({@link DMTPlayer DMT}) player</b> invoked in this
	 *        event.
	 * @param <b>{@link Arena}</b> on which it happened.
	 */
	public ArenaEvent( final Arena arena ) {
		this.arena = arena;
	}

	/**
	 * Used for getting {@link Arena arena} invoked in this event.
	 * 
	 * @return Arena on which he/she is/was.
	 */
	public Arena getArena ( ) {
		return arena;
	}

	@Override
	public HandlerList getHandlers ( ) {
		return handlers;
	}

	/**
	 * 
	 * @return all handlers for this event
	 */
	public static HandlerList getHandlerList ( ) {
		return handlers;
	}
}
