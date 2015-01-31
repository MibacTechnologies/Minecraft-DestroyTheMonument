package com.MibacTechnologies.Minecraft.DestroyTheMonument.Listeners;

import java.util.HashMap;

import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.inventory.ItemStack;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTM;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.Arena;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.ArenaPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Utils.BooleanUtils;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 28 Jan 2015 (18:10:57)
 */
public class PlayerEvents implements Listener {
	@EventHandler ( ignoreCancelled = true )
	public void leave ( final PlayerKickEvent e ) {
		DTM.l.info( "\"" + e.getReason( ) + "\"REASON!!!!!!!!!!!!!" );
	}

	@EventHandler
	public void death ( final PlayerDeathEvent e ) {
		Arena a = DTM.AM.getArena( e.getEntity( ) );

		if ( a == null )
			return;

		e.getEntity( ).teleport( a.getSpawn( e.getEntity( ) ) );

		Damageable da = e.getEntity( );

		da.setHealth( da.getMaxHealth( ) );

		e.getEntity( ).getInventory( ).clear( );

		HashMap< Integer, ItemStack > items = DTM.IM.getItems( );

		for ( int i = 0; i < items.size( ); i++ )
			e.getEntity( ).getInventory( ).setItem( i, items.get( i ) );
	}

	@EventHandler
	public void attack ( final EntityDamageByEntityEvent e ) {
		Entity e1 = e.getEntity( );
		Entity e2 = e.getDamager( );

		if ( !( e1 instanceof Player ) || !( e2 instanceof Player ) )
			return;

		Player p1 = (Player) e1;
		Player p2 = (Player) e2;

		DTMPlayer victim = DTM.PM.getDTMPlayer( p1 );
		DTMPlayer damager = DTM.PM.getDTMPlayer( p2 );

		if ( victim == null || damager == null )
			return;

		if ( BooleanUtils
				.countBools( victim.isPlaying( ), damager.isPlaying( ) ) == 1 ) {
			e.setCancelled( true );
			return;
		}

		if ( !victim.isPlaying( ) || !damager.isPlaying( ) )
			return;

		ArenaPlayer at1 = victim.ap;
		ArenaPlayer at2 = victim.ap;

		if ( at1.a != at2.a ) {
			e.setCancelled( true );
			return;
		}

		if ( at1.t == at2.t ) {
			e.setCancelled( true );
			return;
		}
	}

	@EventHandler
	public void blockBreak ( final BlockBreakEvent e ) {

	}
}
