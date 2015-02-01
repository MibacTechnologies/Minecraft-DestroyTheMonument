package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player;

import org.bukkit.event.Cancellable;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Entity.Player.ArenaPlayerDamageEvent;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 1 Feb 2015 (12:15:23)
 */
public class ArenaPlayerUnknownDamageEvent extends ArenaPlayerDamageEvent
		implements Cancellable {
	private final DamageCause cause;
	private boolean cancelled;

	public ArenaPlayerUnknownDamageEvent( final DTMPlayer player,
			final double damage, final DamageCause cause,
			final boolean cancelled ) {
		super( player, damage );

		this.cause = cause;
		this.cancelled = cancelled;
	}

	public DamageCause getCause ( ) {
		return cause;
	}

	public boolean isCancelled ( ) {
		return cancelled;
	}

	public void setCancelled ( final boolean cancelled ) {
		this.cancelled = cancelled;
	}
}
