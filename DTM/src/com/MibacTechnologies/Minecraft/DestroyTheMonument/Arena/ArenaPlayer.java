package com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 29 Jan 2015 (15:24:24)
 */
public class ArenaPlayer {
	public final DTMPlayer p;
	public final Arena a;
	public final ArenaTeam t;
	public int kills;

	public ArenaPlayer( final DTMPlayer p, final Arena a, final ArenaTeam t ) {
		this.p = p;
		this.a = a;
		this.t = t;
	}
}
