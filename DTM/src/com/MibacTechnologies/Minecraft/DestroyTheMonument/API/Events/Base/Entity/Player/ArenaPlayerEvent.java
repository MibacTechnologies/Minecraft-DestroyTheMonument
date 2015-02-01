package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Entity.Player;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.ArenaEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (12:37:31)
 */
public class ArenaPlayerEvent extends Event {
	private static final HandlerList handlers = new HandlerList( );
	private final DTMPlayer player;

	/**
	 * Main constructor of {@link ArenaEvent arena event}
	 * 
	 * @param <b>({@link DMTPlayer DMT}) player</b> invoked in this
	 *        event.
	 * @param <b>{@link Arena}</b> on which it happened.
	 */
	public ArenaPlayerEvent( final DTMPlayer player ) {
		this.player = player;
	}

	/**
	 * Used for getting {@link DTMPlayer DTM}Player invoked in this
	 * event.
	 * 
	 * @return DTMPlayer which did this action.
	 */
	public DTMPlayer getDTMPlayer ( ) {
		return player;
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
