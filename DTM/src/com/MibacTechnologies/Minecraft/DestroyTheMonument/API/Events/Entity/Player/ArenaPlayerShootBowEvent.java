package com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Entity.Player;

import org.bukkit.entity.Entity;
import org.bukkit.event.Cancellable;
import org.bukkit.inventory.ItemStack;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.DTMPlayer;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.API.Events.Base.Entity.Player.ArenaPlayerEvent;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 31 Jan 2015 (18:44:41)
 */
public class ArenaPlayerShootBowEvent extends ArenaPlayerEvent implements
		Cancellable {
	private final ItemStack bow;
	private boolean cancelled;
	private Entity entity;

	public ArenaPlayerShootBowEvent( final DTMPlayer player,
			final ItemStack bow, final Entity entity ) {
		this( player, bow, entity, false );
	}

	public ArenaPlayerShootBowEvent( final DTMPlayer player,
			final ItemStack bow, final Entity entity, final boolean cancelled ) {
		super( player );

		this.bow = bow;
		this.entity = entity;
		this.cancelled = cancelled;
	}

	public ItemStack getBow ( ) {
		return bow;
	}

	public Entity getProjectile ( ) {
		return entity;
	}

	@Override
	public boolean isCancelled ( ) {
		return cancelled;
	}

	@Override
	public void setCancelled ( final boolean cancelled ) {
		this.cancelled = cancelled;
	}

	public void setProjectile ( final Entity entity ) {
		this.entity = entity;
	}
}
