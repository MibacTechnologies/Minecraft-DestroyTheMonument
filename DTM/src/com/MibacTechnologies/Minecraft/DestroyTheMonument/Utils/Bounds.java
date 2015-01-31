package com.MibacTechnologies.Minecraft.DestroyTheMonument.Utils;

import java.io.Serializable;

import org.bukkit.Location;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (17:12:00)
 */
public class Bounds implements Serializable {
	private static final long serialVersionUID = 1L;
	private final Location location1;
	private final Location location2;
	private final Location[] bounds;

	public Bounds( final Location location1, final Location location2 ) {
		this.location1 = location1;
		this.location2 = location2;
		Location[] bounds = { location1, location2 };
		this.bounds = bounds;
	}

	/**
	 * @return 1st corner
	 */
	public Location getSt ( ) {
		return location1;
	}

	/**
	 * @return 2nd corner
	 */
	public Location getNd ( ) {
		return location2;
	}

	/**
	 * @return bounds (2)
	 */
	public Location[] getBounds ( ) {
		return bounds;
	}
}
