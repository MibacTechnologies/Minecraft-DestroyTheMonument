package com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTM;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 29 Jan 2015 (19:24:16)
 */
public class TeamManager {
	private final HashMap< ArenaTeam, Team > teams;
	public final Arena a;
	protected final Scoreboard scb;

	protected TeamManager( final Arena a ) {
		this.a = a;
		this.scb = DTM.SM.getNewScoreboard( );
		this.teams = new HashMap< ArenaTeam, Team >( );

		for ( ArenaTeam at : ArenaTeam.values( ) )
			checkTeam( at );
	}

	protected boolean addPlayer ( final ArenaTeam at, final DTMPlayer p ) {
		return addPlayer( at, p.p );
	}

	protected boolean addPlayer ( final ArenaTeam at, final Player p ) {
		Team t = teams.get( at );

		if ( t == null ) {
			checkTeam( at );
			return false;
		}

		if ( t.hasPlayer( p ) )
			return false;

		t.addPlayer( p );

		teams.put( at, t );

		return true;
	}

	protected boolean removePlayer ( final ArenaTeam at, final DTMPlayer p ) {
		return removePlayer( at, p.p );
	}

	protected boolean removePlayer ( final ArenaTeam at, final Player p ) {
		Team t = teams.get( at );

		if ( t == null ) {
			checkTeam( at );
			return false;
		}

		return true;
	}

	private void checkTeam ( final ArenaTeam at ) {
		Team t = teams.get( at );

		if ( t == null )
			teams.put( at, scb.registerNewTeam( a.name + "_t" + at.id ) );
	}

	protected void restart ( ) {
		for ( ArenaTeam at : ArenaTeam.values( ) )
			checkTeam( at );
	}
}
