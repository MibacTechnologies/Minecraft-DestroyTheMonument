package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Player.CancellableArenaPlayersEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.ArenaTeam;

/**
 * This (ArenaJoinEvent) event is triggered when someone joins
 * {@link Arena arena}. Cancellable
 * 
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 30 Jan 2015 (16:49:00)
 */
public class ArenaJoinEvent extends CancellableArenaPlayersEvent {
	public ArenaJoinEvent( final DTMPlayer player, final Arena arena,
			final ArenaTeam team ) {
		this( player, arena, team, false );
	}

	public ArenaJoinEvent( final DTMPlayer player, final Arena arena,
			final ArenaTeam team, final boolean cancelled ) {
		super( player, arena, team, cancelled );
	}
}
