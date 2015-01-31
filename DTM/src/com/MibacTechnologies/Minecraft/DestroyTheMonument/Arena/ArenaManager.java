package com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTM;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.ArenaCreateEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Utils.UniqueList;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 28 Jan 2015 (18:22:34)
 */
public class ArenaManager {
	private UniqueList< Arena > arenas;

	public ArenaManager( ) {

	}

	/**
	 * Use {@link #create(String, HashMap)} instead!
	 */
	@Deprecated
	public boolean add ( final Arena arena ) {
		return arenas.add( arena );
	}

	/**
	 * 
	 * @param arena
	 *            which you want to check if exists.
	 * @return boolean - true if contains; otherwise false,
	 */
	public boolean contains ( final Arena arena ) {
		return arenas.contains( arena );
	}

	/**
	 * 
	 * @param name
	 *            of arena
	 * @param spawns
	 *            of teams
	 * @return boolean whether it was successful or not
	 */
	public ArenaCreationResult create ( final String name,
			final HashMap< ArenaTeam, Location > spawns ) {
		Arena a = new Arena( name, spawns );
		boolean b = false;

		int id = getNextId( );

		if ( contains( a ) )
			b = false;

		ArenaCreateEvent e = new ArenaCreateEvent( a, b );

		DTM.pm.callEvent( e );

		if ( e.isCancelled( ) )
			return new ArenaCreationResult( null, -1, false );

		arenas.add( a );

		return new ArenaCreationResult( a, id, true );
	}

	/**
	 * 
	 * @param id
	 *            of {@link Arena arena}
	 * @return {@link Arena arena's} instance
	 */
	public Arena getArena ( final int id ) {
		return arenas.size( ) >= id ? arenas.get( id ) : null;
	}

	public Arena getArena ( final String name ) {
		for ( Arena a : arenas )
			if ( a.name == name )
				return a;

		return null;
	}

	public Arena getArena ( final Player p ) {
		for ( Arena a : arenas )
			if ( a.getPlayers( ).contains( DTM.PM.getDTMPlayer( p ) ) )
				return a;

		return null;
	}

	/**
	 * 
	 * @param name
	 *            of arena
	 * 
	 * @return arena's id
	 */
	public int getIdOf ( final String name ) {
		return arenas.indexOf( getArena( name ) );
	}

	/**
	 * 
	 * @param arena
	 *            which id you want to get
	 * @return arena's id
	 */
	public int getIdOf ( final Arena arena ) {
		return arenas.indexOf( arena );
	}

	/**
	 * @return next free (?) Id
	 */
	public int getNextId ( ) {
		return arenas.size( ) + 1;
	}
}
