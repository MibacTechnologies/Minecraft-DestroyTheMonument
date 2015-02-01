package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Entity.Player;

import org.bukkit.event.Cancellable;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.ArenaEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (19:59:05)
 */
public class ArenaTwoPlayersDamageEvent extends ArenaPlayerDamageEvent
		implements Cancellable {
	private boolean cancelled;
	private final DTMPlayer player;

	/**
	 * Constructor of {@link ArenaEvent arena event}
	 * 
	 * @param <b>({@link DMTPlayer DMT}) player</b> invoked in this
	 *        event.
	 * @param <b>{@link Arena}</b> on which it happened.
	 */
	public ArenaTwoPlayersDamageEvent( final DTMPlayer player,
			final DTMPlayer player2, final double damage ) {
		this( player, player2, damage, false );
	}

	/**
	 * Main constructor of {@link ArenaEvent arena event}
	 * 
	 * @param <b>({@link DMTPlayer DMT}) player</b> invoked in this
	 *        event.
	 * @param <b>{@link Arena}</b> on which it happened.
	 */
	public ArenaTwoPlayersDamageEvent( final DTMPlayer player,
			final DTMPlayer player2, final double damage,
			final boolean cancelled ) {
		super( player, damage );

		this.player = player2;
	}

	/**
	 * @return attacker
	 */
	public DTMPlayer getNdPlayer ( ) {
		return player;
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
