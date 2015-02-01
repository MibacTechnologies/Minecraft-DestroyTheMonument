package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Arena;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Arena.ArenaModificationEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (18:13:50)
 */
public class ArenaDeleteEvent extends ArenaModificationEvent {
	public ArenaDeleteEvent( final Arena arena ) {
		super( arena );
	}
}
