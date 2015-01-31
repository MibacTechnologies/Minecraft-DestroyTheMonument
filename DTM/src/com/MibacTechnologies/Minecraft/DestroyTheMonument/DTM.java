package com.MibacTechnologies.Minecraft.DestroyTheMonument;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.ScoreboardManager;

import com.MibacTechnologies.Minecraft.DestroyTheMonument.Arena.ArenaManager;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Listeners.ArenaEvents;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Listeners.PlayerEvents;
import com.MibacTechnologies.Minecraft.DestroyTheMonument.Utils.BooleanUtils;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 28 Jan 2015 (17:54:46)
 */
public class DTM extends JavaPlugin {
	private FileConfiguration config;
	public static PluginManager pm;
	public static Logger l;
	public static ArenaManager AM;
	public static ItemManager IM;
	public static PlayerManager PM;
	public static ScoreboardManager SM;
	private static DTM dtm;

	//private BooleanUtils bu;

	@Override
	public void onEnable ( ) {
		//bu = 
		new BooleanUtils( );
		config = getConfig( );
		pm = getServer( ).getPluginManager( );
		AM = new ArenaManager( );
		IM = new ItemManager( );
		PM = new PlayerManager( );
		SM = Bukkit.getScoreboardManager( );
		l = getLogger( );
		dtm = this;

		pm.registerEvents( new PlayerEvents( ), this );
		pm.registerEvents( new ArenaEvents( ), this );
	}

	@Override
	public void onDisable ( ) {
		// Prevents using I/O while running - better performance.
		for ( String key : config.getKeys( true ) )
			getConfig( ).set( key, config.get( key ) );

		saveConfig( );
	}

	public FileConfiguration getCfg ( ) {
		return config;
	}

	public static DTM instance ( ) {
		return dtm;
	}
}
