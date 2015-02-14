package com.MibacTechnologies.Minecraft.DestroyTheMonument.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Arena.ArenaCreateEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Block.ArenaBlockBreakEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerDamageByEntityEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerDamageByPlayerEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerDeathEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerFallOutOfMapEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerJoinEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerLeaveEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerNaturalRespawnEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerRespawnEvent;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player.ArenaPlayerShootBowEvent;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 30 Jan 2015 (16:45:33)
 */
public class ArenaEvents implements Listener {
	// -------------------[[ Player  ]]-------------------
	@EventHandler ( priority = EventPriority.MONITOR )
	public void leave ( final ArenaPlayerLeaveEvent e ) {
	}

	@EventHandler ( priority = EventPriority.MONITOR )
	public void join ( final ArenaPlayerJoinEvent e ) {
	}

	@EventHandler ( priority = EventPriority.MONITOR )
	public void kill ( final ArenaPlayerDeathEvent e ) {
	}

	@EventHandler ( priority = EventPriority.MONITOR )
	public void shoot ( final ArenaPlayerShootBowEvent e ) {
	}

	@EventHandler ( priority = EventPriority.MONITOR )
	public void pvp ( final ArenaPlayerDamageByPlayerEvent e ) {
	}

	//TODO
	@EventHandler ( priority = EventPriority.MONITOR )
	public void pve ( final ArenaPlayerDamageByEntityEvent e ) {
	}

	@EventHandler ( priority = EventPriority.MONITOR )
	public void voidDmg ( final ArenaPlayerFallOutOfMapEvent e ) {
	}

	@EventHandler ( priority = EventPriority.MONITOR )
	public void resp ( final ArenaPlayerRespawnEvent e ) {
	}

	@EventHandler ( priority = EventPriority.MONITOR )
	public void naturalResp ( final ArenaPlayerNaturalRespawnEvent e ) {
	}

	// -------------------[[  Block  ]]-------------------

	@EventHandler ( priority = EventPriority.MONITOR )
	public void blockBreak ( final ArenaBlockBreakEvent e ) {
	}

	// -------------------[[  Arena  ]]-------------------
	@EventHandler ( priority = EventPriority.MONITOR )
	public void arenaCreate ( final ArenaCreateEvent e ) {
	}
}
