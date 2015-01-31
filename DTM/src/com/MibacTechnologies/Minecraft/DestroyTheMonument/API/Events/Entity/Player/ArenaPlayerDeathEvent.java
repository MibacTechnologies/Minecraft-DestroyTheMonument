package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Entity.Player.ArenaTwoPlayersEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * Non-cancellable
 * 
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (15:25:33)
 */
public class ArenaPlayerDeathEvent extends ArenaTwoPlayersEvent {
	public ArenaPlayerDeathEvent( final DTMPlayer player,
			final DTMPlayer player2, final Arena arena ) {
		super( player, player2, arena );
	}
}
