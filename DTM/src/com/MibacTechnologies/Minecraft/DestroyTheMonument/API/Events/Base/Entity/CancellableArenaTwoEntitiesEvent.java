package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Entity;

import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (16:22:59)
 */
public class CancellableArenaTwoEntitiesEvent extends ArenaTwoEntitiesEvent
		implements Cancellable {
	private boolean cancelled;

	public CancellableArenaTwoEntitiesEvent( final Entity entity,
			final Entity entity2, final Arena arena ) {
		this( entity, entity2, arena, false );
	}

	public CancellableArenaTwoEntitiesEvent( final Entity entity,
			final Entity entity2, final Arena arena, final boolean cancelled ) {
		super( entity, entity2, arena );

		this.cancelled = cancelled;
	}

	@Override
	public boolean isCancelled ( ) {
		return cancelled;
	}

	@Override
	public void setCancelled ( final boolean cancelled ) {
		this.cancelled = cancelled;
	}
}
