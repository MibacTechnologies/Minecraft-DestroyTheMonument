package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Player;

import java.io.IOException;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Player.ArenaPlayerLeaveEvent;

/**
 * Used in {@link ArenaPlayerLeaveEvent} as cause (of leave). Sorted from
 * most friendly
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
	 * Player left server (himself)
	 */
	LEFT ( 1 ),
	/**
	 * Player was kicked (or banned)
	 */
	KICK ( 2 ),
	/**
	 * For now, not used (no way of determining it).
	 * 
	 * Player had connection error (ex. {@link IOException})
	 */
	CONNECTION_ERR ( 3 );

	private final int id;

	private ArenaLeaveEventCause( final int id ) {
		this.id = id;
	}

	public int getId ( ) {
		return id;
	}
};