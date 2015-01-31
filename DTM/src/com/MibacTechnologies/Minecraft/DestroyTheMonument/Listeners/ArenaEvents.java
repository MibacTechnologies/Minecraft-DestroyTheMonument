package com.MibacTechnologies.Minecraft.DestroyTheMonument.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.ArenaBlockBreakEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.ArenaJoinEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.ArenaLeaveEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 30 Jan 2015 (16:45:33)
 */
public class ArenaEvents implements Listener {

	@EventHandler ( priority = EventPriority.MONITOR )
	public void leave ( final ArenaLeaveEvent e ) {
		//TODO
		Arena a = e.getArena( );
		DTMPlayer p = e.getDTMPlayer( );

		a.removePlayer( p );
	}

	@EventHandler ( priority = EventPriority.MONITOR )
	public void join ( final ArenaJoinEvent e ) {
		//TODO
	}

	@EventHandler ( priority = EventPriority.MONITOR )
	public void blockBreak ( final ArenaBlockBreakEvent e ) {
		//TODO
	}
}
