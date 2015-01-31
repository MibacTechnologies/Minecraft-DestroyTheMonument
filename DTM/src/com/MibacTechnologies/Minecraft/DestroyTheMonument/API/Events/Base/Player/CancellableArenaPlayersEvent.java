package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Player;

import org.bukkit.event.Cancellable;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.ArenaTeam;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (12:00:55)
 */
public class CancellableArenaPlayersEvent extends ArenaPlayersEvent implements
		Cancellable {
	private boolean cancelled;

	/**
	 * @param player
	 * @param arena
	 * @param team
	 */
	public CancellableArenaPlayersEvent( final DTMPlayer player,
			final Arena arena, final ArenaTeam team ) {
		this( player, arena, team, false );
	}

	public CancellableArenaPlayersEvent( final DTMPlayer player,
			final Arena arena, final ArenaTeam team, final boolean cancelled ) {
		super( player, arena, team );

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
