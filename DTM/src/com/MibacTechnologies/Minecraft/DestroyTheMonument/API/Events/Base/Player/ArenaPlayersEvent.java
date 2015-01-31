package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Player;

import java.io.IOException;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.ArenaJoinEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.ArenaLeaveEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.ArenaTeam;

/**
 * Used in {@link ArenaJoinEvent} and {@link ArenaLeaveEvent}
 * 
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (11:59:42)
 */
public class ArenaPlayersEvent extends ArenaPlayerEvent {
	/**
	 * Used in {@link ArenaLeaveEvent} as cause (of leave).
	 */
	public enum ArenaLeaveEventCause {
		/**
		 * Unknown cause of leave.
		 */
		UNKNOWN ( -1 ),
		/*
		 * Player left himself using command
		 */
		COMMAND ( 0 ),
		/**
		 * Player was kicked (or banned)
		 */
		KICK ( 1 ),
		/**
		 * For now, not used (no way of determining it).
		 * 
		 * Player had connection error (ex. {@link IOException})
		 */
		CONNECTION_ERR ( 2 );

		private final int id;

		private ArenaLeaveEventCause( final int id ) {
			this.id = id;
		}

		public int getId ( ) {
			return id;
		}
	};

	private final ArenaTeam team;

	public ArenaPlayersEvent( final DTMPlayer player, final Arena arena,
			final ArenaTeam team ) {
		super( player, arena );

		this.team = team;
	}

	public ArenaTeam getTeam ( ) {
		return team;
	}
}
