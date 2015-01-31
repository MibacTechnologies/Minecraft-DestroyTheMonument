package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity;

import org.bukkit.Location;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Block.CancellableArenaBlockEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * Cancellable
 * 
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 30 Jan 2015 (17:54:37)
 */
public class ArenaBlockBreakEvent extends CancellableArenaBlockEvent {
	public ArenaBlockBreakEvent( final DTMPlayer player, final Arena arena,
			final Location location ) {
		this( player, arena, location, false );
	}

	public ArenaBlockBreakEvent( final DTMPlayer player, final Arena arena,
			final Location location, final boolean cancelled ) {
		super( player, arena, location, cancelled );
	}
}
