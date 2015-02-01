package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player;

import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Entity.Player.ArenaPlayerDamageEvent;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 sty 2015 (19:54:41)
 */
public class ArenaPlayerDamageByEntityEvent extends ArenaPlayerDamageEvent
		implements Cancellable {
	private boolean cancelled;
	private final Entity attacker;

	public ArenaPlayerDamageByEntityEvent( final DTMPlayer player,
			final Entity attacker, final double damage ) {
		this( player, attacker, damage, false );
	}

	public ArenaPlayerDamageByEntityEvent( final DTMPlayer player,
			final Entity attacker, final double damage, final boolean cancelled ) {
		super( player, damage );

		this.cancelled = false;
		this.attacker = attacker;
	}

	public Entity getAttacker ( ) {
		return attacker;
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
