package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Entity.Player;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (15:27:39)
 */
public class ArenaTwoPlayersEvent extends ArenaPlayerEvent {
	private final DTMPlayer player2;

	public ArenaTwoPlayersEvent( final DTMPlayer player,
			final DTMPlayer player2, final Arena arena ) {
		super( player, arena );

		this.player2 = player2;
	}

	public DTMPlayer getNdPlayer ( ) {
		return player2;
	}
}
