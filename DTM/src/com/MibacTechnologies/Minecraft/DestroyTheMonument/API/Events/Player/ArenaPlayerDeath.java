package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Player;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Player.ArenaTwoPlayersEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (15:25:33)
 */
public class ArenaPlayerDeath extends ArenaTwoPlayersEvent {
	public ArenaPlayerDeath( final DTMPlayer player, final DTMPlayer player2,
			final DTMPlayer killer, final Arena arena ) {
		super( player, player2, arena );
	}
}
