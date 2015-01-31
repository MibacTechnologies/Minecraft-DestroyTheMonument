package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Entity.Player.ArenaPlayerEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * This (ArenaLeaveEvent) event is triggered when someone leaves
 * {@link Arena arena}. Non-cancellable.
 * 
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 30 Jan 2015 (16:50:46)
 */
public class ArenaPlayerLeaveEvent extends ArenaPlayerEvent {
	public ArenaPlayerLeaveEvent( final DTMPlayer player, final Arena arena ) {
		super( player, arena );
	}
}
