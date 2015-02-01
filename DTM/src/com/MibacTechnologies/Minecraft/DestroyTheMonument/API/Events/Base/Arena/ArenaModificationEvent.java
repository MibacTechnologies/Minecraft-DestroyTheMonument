package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Arena;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Arena.ArenaCreateEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.ArenaEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (12:34:43)
 */
public class ArenaModificationEvent extends ArenaEvent {
	/**
	 * Main constructor of {@link ArenaCreateEvent arena event}
	 * 
	 * @param arena
	 *            which is being modified
	 */
	public ArenaModificationEvent( final Arena arena ) {
		super( arena );
	}
}
