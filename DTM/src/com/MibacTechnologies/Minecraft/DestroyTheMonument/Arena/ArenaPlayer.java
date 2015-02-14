package com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena;

import java.io.Serializable;

import org.bukkit.Location;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 29 Jan 2015 (15:24:24)
 */
public class ArenaPlayer implements Serializable {
	private static final long serialVersionUID = 1L;
	public final DTMPlayer player;
	public final Arena arena;
	public final ArenaTeam team;
	public int monumentsDestroyed;
	public int kills;
	public int deaths;

	public ArenaPlayer( final DTMPlayer player, final Arena arena,
			final ArenaTeam team ) {
		this.player = player;
		this.arena = arena;
		this.team = team;
		this.kills = 0;
		this.deaths = 0;
		this.monumentsDestroyed = 0;
	}

	public Location getSpawn ( ) {
		return arena.getSpawn( team );
	}

	public void quit ( ) {
		arena.removePlayer( player );
	}
}
