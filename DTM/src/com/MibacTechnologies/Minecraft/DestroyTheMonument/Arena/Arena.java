package com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTM;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Arena.Map.ArenaMapRollbackEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerJoinEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerLeaveEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Utils.Bounds;
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
	private final Bounds bounds;
	private transient List< BlockState > rollback;
	private final transient UniqueList< DTMPlayer > players;
	private final HashMap< ArenaTeam, Location > spawns;
	private final UniqueList< Monument > monuments;
	private transient GameState state;
	private transient TeamManager tm;
	private ArenaMode mode;

	//TODO add load function (new TeamManager, and so on)

	/**
	 * 
	 * @param name
	 *            of arena
	 * @param spawns
	 *            of teams
	 */
	protected Arena( final String name, final Bounds bounds,
			final HashMap< ArenaTeam, Location > spawns ) {
		this.name = name;
		this.bounds = bounds;
		this.spawns = spawns;
		this.maxPlayers = 16;
		this.players = new UniqueList< DTMPlayer >( );
		this.tm = new TeamManager( this );
		this.state = GameState.WAITING;
		this.rollback = new ArrayList< BlockState >( );
		this.monuments = new UniqueList< Monument >( );
		this.mode = ArenaMode.ENABLED;
	}

	public void setTeamManager ( final TeamManager tm ) {
		this.tm = tm;
	}

	public void setMode ( final ArenaMode mode ) {
		this.mode = mode;

		if ( mode.isPlayable( ) )
			;//TODO add something, but what? 
		else {
			for ( int i = 0; i < players.size( ); i++ )
				players.get( i ).quit( );

			rollback( );
		}

		this.state = GameState.WAITING;
	}

	public ArenaMode getMode ( ) {
		return mode;
	}

	/**
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

		if ( !mode.isPlayable( ) )
			return false;

		ArenaPlayerJoinEvent e = new ArenaPlayerJoinEvent( player, this,
				getTeamWithLessPlayers( ) );

		DTM.instance( ).pm.callEvent( e );

		if ( e.isCancelled( ) )
			return false;

		players.add( player );

		ArenaPlayer ap = new ArenaPlayer( player, this, e.getTeam( ) );

		tm.addPlayer( ap.team, player );

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
		return addPlayer( DTM.instance( ).PM.getDTMPlayer( player ) );
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

	public Bounds getBounds ( ) {
		return bounds;
	}

	public GameState getGameState ( ) {
		return state;
	}

	public boolean destroyMonument ( final Location location,
			final ArenaPlayer player ) {
		Monument m = getMonument( location );

		if ( m == null )
			return false;

		if ( player.team == m.owner )
			return false;

		if ( m.isDestroyed( ) )
			return false;

		m.setDestroyed( true );

		return true;
	}

	/**
	 * 
	 * @param location
	 *            of monument
	 * @return monument or null (if doesn't exist at that location)
	 */
	public Monument getMonument ( final Location location ) {
		for ( int i = 0; i < monuments.size( ); i++ )
			if ( monuments.get( i ).location.equals( location ) )
				return monuments.get( i );

		return null;
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
			if ( p.ap.team == team )
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
				return dp.ap.team;

		return null;
	}

	/**
	 * @see #getTeam(DTMPlayer)
	 */
	public ArenaTeam getTeam ( final Player player ) {
		return getTeam( DTM.instance( ).PM.getDTMPlayer( player ) );
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
	 * @param location
	 *            which you want to check
	 * @return true, if is in bounds, otherwise false
	 */
	public boolean isInBounds ( final Location location ) {
		int minX = Math.min( bounds.getSt( ).getBlockX( ), bounds.getNd( )
				.getBlockX( ) );
		int maxX = Math.max( bounds.getSt( ).getBlockX( ), bounds.getNd( )
				.getBlockX( ) );
		int minY = Math.min( bounds.getSt( ).getBlockY( ), bounds.getNd( )
				.getBlockY( ) );
		int maxY = Math.max( bounds.getSt( ).getBlockY( ), bounds.getNd( )
				.getBlockY( ) );
		int minZ = Math.min( bounds.getSt( ).getBlockZ( ), bounds.getNd( )
				.getBlockZ( ) );
		int maxZ = Math.max( bounds.getSt( ).getBlockZ( ), bounds.getNd( )
				.getBlockZ( ) );

		if ( ( location.getBlockX( ) >= minX && location.getBlockX( ) <= maxX )
				&& ( location.getBlockY( ) >= minY
						&& location.getBlockY( ) <= maxY && ( location
						.getBlockZ( ) >= minZ && location.getBlockZ( ) <= maxZ ) ) )
			return true;

		return false;
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

	/**
	 * @see UniqueList#remove(Object)
	 */
	public boolean removePlayer ( final DTMPlayer player ) {
		DTM.instance( ).pm.callEvent( new ArenaPlayerLeaveEvent( player ) );

		player.quit( );

		return players.remove( player );
	}

	/**
	 * @see #removePlayer(DTMPlayer)
	 */
	public boolean removePlayer ( final Player player ) {
		return removePlayer( DTM.instance( ).PM.getDTMPlayer( player ) );
	}

	/**
	 * Restarts arena
	 * 
	 * @see TeamManager#restart()
	 */
	public void restart ( ) {
		tm.restart( );
		players.clear( );
		rollback( );

		for ( int i = 0; i < monuments.size( ); i++ )
			monuments.get( i ).setDestroyed( false );
	}

	public void rollback ( ) {
		DTM.instance( ).pm.callEvent( new ArenaMapRollbackEvent( this ) );

		List< BlockState > rb = rollback;

		int i = rb.size( );

		while ( !rb.isEmpty( ) ) {
			rb.get( i ).update( true );
			rb.remove( i );

			i = rb.size( ) - 1;
		}

		rollback = rb;

		for ( i = monuments.size( ) - 1; i <= 0; i-- )
			monuments.get( i ).setDestroyed( false );
	}

	@Override
	public int hashCode ( ) {
		return 101; //TODO
	}
}
