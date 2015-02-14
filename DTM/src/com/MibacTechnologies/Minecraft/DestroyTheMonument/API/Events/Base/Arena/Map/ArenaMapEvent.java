package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Arena.Map;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Arena.ArenaModificationEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 1 Feb 2015 (19:46:11)
 */
public class ArenaMapEvent extends ArenaModificationEvent {
	private final String mapName;

	public ArenaMapEvent( final Arena arena, final String mapName ) {
		super( arena );

		this.mapName = mapName;
	}

	public String getMapName ( ) {
		return mapName;
	}
}
