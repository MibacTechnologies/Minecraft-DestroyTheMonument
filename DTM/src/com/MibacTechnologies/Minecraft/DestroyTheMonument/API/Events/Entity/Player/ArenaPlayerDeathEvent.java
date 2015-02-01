package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Entity.Player.ArenaTwoPlayersEvent;

/**
 * Non-cancellable
 * 
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (15:25:33)
 */
public class ArenaPlayerDeathEvent extends ArenaTwoPlayersEvent {
	public ArenaPlayerDeathEvent( final DTMPlayer player,
			final DTMPlayer player2 ) {
		super( player, player2 );
	}
}
