package com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena;

import java.io.Serializable;
import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTM;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Player.ArenaPlayerJoinEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Utils.UniqueList;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 28 Jan 2015 (18:21:56)
 */
public class Arena implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * Max players playing the same time on this arena
	 */
	public final int maxPlayers;
	/**
	 * Currently not used - arena name.
	 */
	public final String name;
	private final UniqueList< DTMPlayer > players;
	private final HashMap< ArenaTeam, Location > spawns;
	private final TeamManager tm;

	/**
	 * 
	 * @param name
	 *            of arena
	 * @param spawns
	 *            of teams
	 */
	protected Arena( final String name,
			final HashMap< ArenaTeam, Location > spawns ) {
		this.name = name;
		this.spawns = spawns;
		this.maxPlayers = 16;
		this.players = new UniqueList< DTMPlayer >( );
		this.tm = new TeamManager( this );
	}

	/**
	 * <s>In future, may possibly be private (non-accessible)</s>
	 * 
	 * @param player
	 *            - (DTM)Player you want to add
	 * @return false if player already plays (on other or this arena)
	 *         or arena is full, otherwise true
	 */
	public boolean addPlayer ( final DTMPlayer player ) {
		if ( player == null )
			return false;

		if ( player.isPlaying( ) )
			return false;

		if ( isPlaying( player ) )
			return false;

		if ( isFull( ) )
			return false;

		ArenaPlayerJoinEvent e = new ArenaPlayerJoinEvent( player, this,
				getTeamWithLessPlayers( ) );

		DTM.pm.callEvent( e );

		if ( e.isCancelled( ) )
			return false;

		players.add( player );

		ArenaPlayer ap = new ArenaPlayer( player, this, e.getTeam( ) );

		tm.addPlayer( ap.t, player );

		player.ap = ap;

		return true;
	}

	/**
	 * @param player
	 *            you want to add
	 * @return false if player already plays (on other or this arena)
	 *         or arena is full, otherwise true
	 */
	public boolean addPlayer ( final Player player ) {
		return addPlayer( DTM.PM.getDTMPlayer( player ) );
	}

	/**
	 * @return total amount of players in arena
	 */
	public int getPlayerCount ( ) {
		return players.size( );
	}

	/**
	 * @return {@link UniqueList} of {@link DTMPlayer}s
	 */
	public UniqueList< DTMPlayer > getPlayers ( ) {
		return players;
	}

	/**
	 * @param team
	 *            of which you want to check amount of players
	 * @return amount of players in team
	 */
	public int getPlayers ( final ArenaTeam team ) {
		int c = 0;

		for ( DTMPlayer p : players )
			if ( p.ap.t == team )
				c++;

		return c;
	}

	/**
	 * @param team
	 *            which spawn you want to get
	 * @return team's spawn
	 */
	public Location getSpawn ( final ArenaTeam team ) {
		return spawns.get( team );
	}

	/**
	 * @param player
	 *            of which you want to get spawn (spawn of team in
	 *            which he/she is)
	 * @return location of team's spawn in which is player. If player
	 *         doesn't play on this arena, or isn't playing at all -
	 *         null.
	 */
	public Location getSpawn ( final Player player ) {
		return getSpawn( getTeam( player ) );
	}

	/**
	 * @param player
	 *            of which you want to get team
	 * @return player's team
	 */
	public ArenaTeam getTeam ( final DTMPlayer player ) {
		for ( DTMPlayer dp : players )
			if ( dp.equals( player ) )
				return dp.ap.t;

		return null;
	}

	/**
	 * @see #getTeam(DTMPlayer)
	 */
	public ArenaTeam getTeam ( final Player player ) {
		return getTeam( DTM.PM.getDTMPlayer( player ) );
	}

	/**
	 * @return team, which has lower amount of players. If it's the
	 *         same, default team ({@link ArenaTeam#ONE})
	 */
	public ArenaTeam getTeamWithLessPlayers ( ) {
		return getPlayers( ArenaTeam.TWO ) > getPlayers( ArenaTeam.ONE ) ? ArenaTeam.ONE
				: ArenaTeam.TWO;
	}

	/**
	 * @return true if arena is full, otherwise false
	 */
	public boolean isFull ( ) {
		return getPlayerCount( ) >= maxPlayers;
	}

	/**
	 * @param player
	 *            you want to check
	 * @return true if player is playing (on this arena), otherwise
	 *         false
	 */
	public boolean isPlaying ( final DTMPlayer player ) {
		return players.contains( player );
	}

	@Override
	public boolean equals ( final Object o ) {
		if ( !( o instanceof Arena ) )
			return false;

		Arena a = (Arena) o;

		if ( a.getPlayers( ) == getPlayers( ) && a.name.equalsIgnoreCase( name )
				&& a.maxPlayers == maxPlayers )
			return true;

		return false;
	}

	/**
	 * @see UniqueList#remove(Object)
	 */
	public boolean removePlayer ( final DTMPlayer player ) {

		return players.remove( player );
	}

	/**
	 * @see #removePlayer(DTMPlayer)
	 */
	public boolean removePlayer ( final Player player ) {
		return removePlayer( DTM.PM.getDTMPlayer( player ) );
	}
}
