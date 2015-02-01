package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Arena;

import org.bukkit.event.Cancellable;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.ArenaEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (12:34:58)
 */
public class CancellableArenaModificationEvent extends ArenaEvent implements
		Cancellable {
	private boolean cancelled;

	public CancellableArenaModificationEvent( final Arena arena ) {
		this( arena, false );
	}

	public CancellableArenaModificationEvent( final Arena arena,
			final boolean cancelled ) {
		super( arena );

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
