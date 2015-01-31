package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Entity;

import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (16:14:46)
 */
public class CancellableArenaEntityEvent extends ArenaEntityEvent implements
		Cancellable {
	private boolean cancelled;

	public CancellableArenaEntityEvent( final Entity entity, final Arena arena ) {
		this( entity, arena, false );
	}

	public CancellableArenaEntityEvent( final Entity entity, final Arena arena,
			final boolean cancelled ) {
		super( entity, arena );

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
