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

	public Bounds( final Location location1, final Location location2 ) {
		this.location1 = location1;
		this.location2 = location2;

		if ( !location1.getWorld( ).equals( location2.getWorld( ) ) )
			throw new IllegalArgumentException(
					"Locations are in different worlds!" );
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

	public boolean contains ( final Location location ) {
		int minX = Math.min( getSt( ).getBlockX( ), getNd( ).getBlockX( ) );
		int maxX = Math.max( getSt( ).getBlockX( ), getNd( ).getBlockX( ) );
		int minY = Math.min( getSt( ).getBlockY( ), getNd( ).getBlockY( ) );
		int maxY = Math.max( getSt( ).getBlockY( ), getNd( ).getBlockY( ) );
		int minZ = Math.min( getSt( ).getBlockZ( ), getNd( ).getBlockZ( ) );
		int maxZ = Math.max( getSt( ).getBlockZ( ), getNd( ).getBlockZ( ) );

		if ( ( location.getBlockX( ) >= minX && location.getBlockX( ) <= maxX )
				&& ( location.getBlockY( ) >= minY
						&& location.getBlockY( ) <= maxY && ( location
						.getBlockZ( ) >= minZ && location.getBlockZ( ) <= maxZ ) ) )
			return true;

		return false;
	}
}
