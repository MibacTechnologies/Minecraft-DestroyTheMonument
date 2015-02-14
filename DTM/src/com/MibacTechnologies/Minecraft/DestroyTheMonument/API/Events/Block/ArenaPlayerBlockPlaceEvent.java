package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Block;

import org.bukkit.Location;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Block.CancellableArenaBlockEvent;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 1 Feb 2015 (18:43:53)
 */
public class ArenaPlayerBlockPlaceEvent extends CancellableArenaBlockEvent {
	public ArenaPlayerBlockPlaceEvent( final DTMPlayer player,
			final Location location ) {
		this( player, location, false );
	}

	public ArenaPlayerBlockPlaceEvent( final DTMPlayer player,
			final Location location, final boolean cancelled ) {
		super( player, location, cancelled );
	}
}
