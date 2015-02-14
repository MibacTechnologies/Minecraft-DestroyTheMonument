package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Arena.Map;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Arena.ArenaModificationEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 1 Feb 2015 (19:44:41)
 */
public class ArenaMapRollbackEvent extends ArenaModificationEvent {
	public ArenaMapRollbackEvent( final Arena arena ) {
		super( arena );
	}
}
