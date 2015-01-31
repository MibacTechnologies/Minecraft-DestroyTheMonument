package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Entity;

import org.bukkit.entity.Entity;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (16:21:13)
 */
public class ArenaTwoEntitiesEvent extends ArenaEntityEvent {
	private final Entity entity2;

	public ArenaTwoEntitiesEvent( final Entity entity, final Entity entity2,
			final Arena arena ) {
		super( entity, arena );

		this.entity2 = entity2;
	}

	public Entity getNdEntity ( ) {
		return entity2;
	}
}
