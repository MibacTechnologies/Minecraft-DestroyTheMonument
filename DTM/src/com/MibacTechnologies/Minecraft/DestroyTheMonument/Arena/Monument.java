package com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena;

import org.bukkit.Location;
import org.bukkit.Material;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 1 Feb 2015 (20:58:26)
 */
public class Monument {
	public final Location location;
	public final ArenaTeam owner;
	private boolean destroyed;
	public Material material;
	public Material destrydMat;

	public Monument( final Location location, final boolean destroyed,
			final Material mat, final ArenaTeam owner ) {
		this( location, destroyed, mat, owner, Material.AIR );
	}

	public Monument( final Location location, final boolean destroyed,
			final Material mat, final ArenaTeam owner, final Material destrydMat ) {
		this.location = location;
		this.material = mat;
		this.destrydMat = destrydMat;
		this.owner = owner;

		setDestroyed( destroyed );
	}

	@Override
	public boolean equals ( final Object o ) {
		if ( !( o instanceof Monument ) )
			return false;

		return ( (Monument) o ).location.equals( location );
	}

	public void setDestroyed ( final boolean destroyed ) {
		this.destroyed = destroyed;

		if ( destroyed )
			location.getBlock( ).setType( destrydMat );
		else
			location.getBlock( ).setType( material );
	}

	public boolean isDestroyed ( ) {
		return destroyed;
	}

	@Override
	public int hashCode ( ) {
		return 100;
	}
}
