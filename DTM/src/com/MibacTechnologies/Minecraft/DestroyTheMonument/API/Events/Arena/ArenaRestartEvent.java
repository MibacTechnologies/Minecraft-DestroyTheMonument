package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Arena;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Arena.ArenaModificationEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 1 Feb 2015 (20:30:19)
 */
public class ArenaRestartEvent extends ArenaModificationEvent {
	public ArenaRestartEvent( final Arena arena ) {
		super( arena );
	}
}
