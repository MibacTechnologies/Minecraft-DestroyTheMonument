package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Entity.Player;

import org.bukkit.event.Cancellable;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (12:00:55)
 */
public class CancellableArenaTwoPlayerEvent extends ArenaTwoPlayersEvent
		implements Cancellable {
	private boolean cancelled;

	public CancellableArenaTwoPlayerEvent( final DTMPlayer player,
			final DTMPlayer player2, final Arena arena ) {
		this( player, player2, arena, false );
	}

	public CancellableArenaTwoPlayerEvent( final DTMPlayer player,
			final DTMPlayer player2, final Arena arena, final boolean cancelled ) {
		super( player, player2, arena );

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
