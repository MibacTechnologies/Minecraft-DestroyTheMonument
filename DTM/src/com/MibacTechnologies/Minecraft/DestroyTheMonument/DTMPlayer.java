package com.MibacTechnologies.Minecraft.DestroyTheMonument;

import java.io.Serializable;

import org.bukkit.entity.Player;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.ArenaPlayer;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 28 Jan 2015 (18:34:37)
 */
public class DTMPlayer implements Serializable {
	private static final long serialVersionUID = 1L;
	public final Player p;
	public int kills;
	public int deaths;
	public int money;
	public int monumentsDestroyed;
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
