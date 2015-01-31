package com.MibacTechnologies.Minecraft.DestroyTheMonument;

import org.bukkit.entity.Player;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.ArenaPlayer;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 28 Jan 2015 (18:34:37)
 */
public class DTMPlayer {
	public final Player p;
	public final int kills;
	public final int deaths;
	public final int money;
	public ArenaPlayer ap;

	public DTMPlayer( final Player p, final int kills, final int deaths,
			final int money ) {
		this.p = p;
		this.kills = kills;
		this.deaths = deaths;
		this.money = money;
	}

	public boolean isPlaying ( ) {
		return ap != null;
	}

	public void quit ( ) {
		this.ap = null;
	}

	public boolean equals ( final DTMPlayer dp ) {
		if ( dp.p.equals( dp ) )
			return true;

		return false;
	}
}
