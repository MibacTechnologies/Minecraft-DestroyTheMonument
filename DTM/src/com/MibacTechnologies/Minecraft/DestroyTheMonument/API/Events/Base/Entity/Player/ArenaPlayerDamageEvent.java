package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Entity.Player;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (19:57:58)
 */
public class ArenaPlayerDamageEvent extends ArenaPlayerEvent {
	private double damage;

	public ArenaPlayerDamageEvent( final DTMPlayer player, final double damage ) {
		super( player );

		this.damage = damage;
	}

	public double getDamage ( ) {
		return damage;
	}

	public void setDamage ( final double damage ) {
		this.damage = damage;
	}
}
