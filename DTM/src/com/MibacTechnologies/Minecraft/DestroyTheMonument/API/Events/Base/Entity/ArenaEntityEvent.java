package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Entity;

import org.bukkit.entity.Entity;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.ArenaEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (16:12:18)
 */
public class ArenaEntityEvent extends ArenaEvent {
	private final Entity entity;

	public ArenaEntityEvent( final Entity entity, final Arena arena ) {
		super( arena );

		this.entity = entity;
	}

	public Entity getEntity ( ) {
		return entity;
	}
}
