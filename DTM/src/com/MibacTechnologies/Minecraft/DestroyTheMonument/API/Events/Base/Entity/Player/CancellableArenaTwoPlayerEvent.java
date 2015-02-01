package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Entity.Player;

import org.bukkit.event.Cancellable;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (12:00:55)
 */
public class CancellableArenaTwoPlayerEvent extends ArenaTwoPlayersEvent
		implements Cancellable {
	private boolean cancelled;

	public CancellableArenaTwoPlayerEvent( final DTMPlayer player,
			final DTMPlayer player2 ) {
		this( player, player2, false );
	}

	public CancellableArenaTwoPlayerEvent( final DTMPlayer player,
			final DTMPlayer player2, final boolean cancelled ) {
		super( player, player2 );

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
