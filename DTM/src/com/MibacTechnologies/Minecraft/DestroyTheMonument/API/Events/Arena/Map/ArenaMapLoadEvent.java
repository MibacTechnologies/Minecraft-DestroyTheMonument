package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Arena.Map;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Arena.Map.ArenaMapEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 1 Feb 2015 (19:45:21)
 */
public class ArenaMapLoadEvent extends ArenaMapEvent {
	public ArenaMapLoadEvent( final Arena arena, final String mapName ) {
		super( arena, mapName );
	}
}
