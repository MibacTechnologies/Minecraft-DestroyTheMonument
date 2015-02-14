package com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena;

import org.bukkit.ChatColor;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 28 sty 2015 (20:44:15)
 */
public enum ArenaTeam {
	ONE ( 1 , ChatColor.BLUE + "" , "" ), TWO ( 2 , ChatColor.RED + "" , "" );

	private final int id;
	private final String prefix;
	private final String suffix;

	private ArenaTeam( final int id, final String prefix, final String suffix ) {
		this.id = id;
		this.prefix = prefix;
		this.suffix = suffix;
	}

	public int getId ( ) {
		return id;
	}

	public String getPrefix ( ) {
		return prefix;
	}

	public String getSuffix ( ) {
		return suffix;
	}
}
