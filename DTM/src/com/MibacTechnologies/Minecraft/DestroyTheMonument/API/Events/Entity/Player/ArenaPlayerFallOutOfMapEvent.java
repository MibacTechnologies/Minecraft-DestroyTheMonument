package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Entity.Player.ArenaPlayerEvent;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (20:40:50)
 */
public class ArenaPlayerFallOutOfMapEvent extends ArenaPlayerEvent {
	public ArenaPlayerFallOutOfMapEvent( final DTMPlayer player ) {
		super( player );
	}
}
