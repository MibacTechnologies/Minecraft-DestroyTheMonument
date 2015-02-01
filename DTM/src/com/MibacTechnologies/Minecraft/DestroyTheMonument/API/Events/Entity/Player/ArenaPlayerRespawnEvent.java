package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Entity.Player.ArenaPlayerEvent;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 1 Feb 2015 (12:02:20)
 */
public class ArenaPlayerRespawnEvent extends ArenaPlayerEvent {
	public ArenaPlayerRespawnEvent( final DTMPlayer player ) {
		super( player );
	}
}
