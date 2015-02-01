package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Entity.Player.ArenaTwoPlayersDamageEvent;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (19:52:14)
 */
public class ArenaPlayerDamageByPlayerEvent extends ArenaTwoPlayersDamageEvent {
	public ArenaPlayerDamageByPlayerEvent( final DTMPlayer player,
			final DTMPlayer player2, final double damage ) {
		this( player, player2, damage, false );
	}

	public ArenaPlayerDamageByPlayerEvent( final DTMPlayer player,
			final DTMPlayer player2, final double damage,
			final boolean cancelled ) {
		super( player, player2, damage, cancelled );
	}
}
