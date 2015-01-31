package com.MibacTechnologies.Minecraft.DestroyTheMonument.Utils;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 29 Jan 2015 (18:43:52)
 */
public class BooleanUtils {
	public static int countBools ( final boolean... b ) {
		int c = 0;

		for ( boolean bb : b )
			c += bb ? 1 : 0;

		return c;
	}
}
