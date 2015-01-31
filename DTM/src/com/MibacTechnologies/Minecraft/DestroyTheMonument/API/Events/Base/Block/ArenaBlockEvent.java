package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Block;

import org.bukkit.Location;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Entity.Player.ArenaPlayerEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 30 Jan 2015 (19:50:26)
 */
public class ArenaBlockEvent extends ArenaPlayerEvent {
	private final Location location;

	public ArenaBlockEvent( final DTMPlayer player, final Arena arena,
			final Location location ) {
		super( player, arena );

		this.location = location;
	}

	public Location getLocation ( ) {
		return location;
	}
}
