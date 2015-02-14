package com.MibacTechnologies.Minecraft.DestroyTheMonument;

import java.io.Serializable;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.ArenaPlayer;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 28 Jan 2015 (18:34:37)
 */
public class DTMPlayer implements Serializable {
	private static final long serialVersionUID = 1L;
	public transient Player p;
	public final String name;
	public int kills;
	public int deaths;
	public int money;
	public int monumentsDestroyed;
	public transient ArenaPlayer ap;

	public DTMPlayer( final Player p, final int kills, final int deaths,
			final int money ) {
		this.p = p;
		this.name = p.getName( );
		this.kills = kills;
		this.deaths = deaths;
		this.money = money;
	}

	public void load ( ) {
		this.p = (Player) Bukkit.getOfflinePlayer( name );
	}

	public boolean isPlaying ( ) {
		return ap != null;
	}

	public void quit ( ) {
		ap.quit( );
		ap = null;
	}

	@Override
	public boolean equals ( final Object o ) {
		if ( !( o instanceof DTMPlayer ) )
			return false;

		DTMPlayer dp = (DTMPlayer) o;

		if ( dp.p.equals( dp ) )
			return true;

		return false;
	}

	@Override
	public int hashCode ( ) {
		return 102;
	}
}
