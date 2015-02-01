package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Block;

import org.bukkit.Location;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Block.CancellableArenaBlockEvent;

/**
 * Cancellable
 * 
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 30 Jan 2015 (17:54:37)
 */
public class ArenaBlockBreakEvent extends CancellableArenaBlockEvent {
	public ArenaBlockBreakEvent( final DTMPlayer player, final Location location ) {
		this( player, location, false );
	}

	public ArenaBlockBreakEvent( final DTMPlayer player,
			final Location location, final boolean cancelled ) {
		super( player, location, cancelled );
	}
}
