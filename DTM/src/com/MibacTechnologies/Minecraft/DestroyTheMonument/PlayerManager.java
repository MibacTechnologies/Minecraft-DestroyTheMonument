package com.MibacTechnologies.Minecraft.DestroyTheMonument;

import java.util.LinkedHashSet;

import org.bukkit.entity.Player;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 29 Jan 2015 (15:54:09)
 */
public class PlayerManager {
	private LinkedHashSet< DTMPlayer > players;

	public DTMPlayer getDTMPlayer ( final Player p ) {
		for ( DTMPlayer dp : players )
			if ( dp.p == p )
				return dp;

		return null;
	}

	public boolean create ( final Player p ) {
		return players.add( new DTMPlayer( p, 0, 0, 0 ) );
	}
}
