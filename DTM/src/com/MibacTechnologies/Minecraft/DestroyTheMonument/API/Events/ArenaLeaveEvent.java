package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Player.ArenaPlayersEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.ArenaTeam;

/**
 * This (ArenaLeaveEvent) event is triggered when someone leaves
 * {@link Arena arena}. Non-cancellable.
 * 
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 30 Jan 2015 (16:50:46)
 */
public class ArenaLeaveEvent extends ArenaPlayersEvent {
	public ArenaLeaveEvent( final DTMPlayer player, final Arena arena,
			final ArenaTeam team ) {
		super( player, arena, team );
	}
}
