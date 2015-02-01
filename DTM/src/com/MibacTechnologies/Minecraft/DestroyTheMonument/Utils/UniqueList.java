package com.MibacTechnologies.Minecraft.DestroyTheMonument.Utils;

import java.util.Collection;
import java.util.LinkedList;

/**
 * @author Michał "mibac138" Bączkowski
 * @since Creation date: 29 sty 2015 (16:57:38)
 */
public class UniqueList< E > extends LinkedList< E > {
	private static final long serialVersionUID = 1L;

	@Override
	public boolean add ( final E e ) {
		if ( this.contains( e ) )
			return false;
		else
			return super.add( e );
	}

	@Override
	public boolean addAll ( final Collection< ? extends E > collection ) {
		Collection< E > copy = new LinkedList< E >( collection );
		copy.removeAll( this );
		return super.addAll( copy );
	}

	@Override
	public boolean addAll ( final int index,
			final Collection< ? extends E > collection ) {
		Collection< E > copy = new LinkedList< E >( collection );
		copy.removeAll( this );
		return super.addAll( index, copy );
	}

	@Override
	public void add ( final int index, final E element ) {
		if ( this.contains( element ) )
			return;
		else
			super.add( index, element );
	}
}
