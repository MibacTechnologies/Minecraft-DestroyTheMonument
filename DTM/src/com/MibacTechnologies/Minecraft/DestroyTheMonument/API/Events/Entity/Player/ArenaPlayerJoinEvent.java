package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Entity.Player.CancellableArenaPlayerEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.ArenaTeam;

/**
 * This (ArenaJoinEvent) event is triggered when someone joins
 * {@link Arena arena}. Cancellable
 * 
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 30 Jan 2015 (16:49:00)
 */
public class ArenaPlayerJoinEvent extends CancellableArenaPlayerEvent {
	private final Arena arena;
	private ArenaTeam team;

	public ArenaPlayerJoinEvent( final DTMPlayer player, final Arena arena,
			final ArenaTeam team ) {
		this( player, arena, team, false );
	}

	public ArenaPlayerJoinEvent( final DTMPlayer player, final Arena arena,
			final ArenaTeam team, final boolean cancelled ) {
		super( player, cancelled );

		this.team = team;
		this.arena = arena;
	}

	public Arena getArena ( ) {
		return arena;
	}

	public ArenaTeam getTeam ( ) {
		return team;
	}

	public void setTeam ( final ArenaTeam team ) {
		this.team = team;
	}
}
