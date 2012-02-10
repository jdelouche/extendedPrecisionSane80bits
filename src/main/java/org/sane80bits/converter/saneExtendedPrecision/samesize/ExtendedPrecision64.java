package org.sane80bits.converter.saneExtendedPrecision.samesize;

import org.sane80bits.converter.model.ExtendedPrecision;
import org.sane80bits.converter.saneExtendedPrecision.anysize.AbstractExtendedPrecision;


/**
 * 
 * Conversion to Double Java 64 bits of a java 64bits representation
 * 
 * Standard Apple Numeric Environment SANE 80 bits
 * 
 * @author Jean-Pierre Delouche
 * 
 */
public class ExtendedPrecision64 extends AbstractExtendedPrecision implements
		ExtendedPrecision {

	private static final int infinityExponent = 0x7ff;
	private static final int exponentSizeInBits = 11;
	private static final int sizeInBytes = 8;

	/**
	 * Creates an 64 bits representation from a <code>byte</code> array
	 * 
	 * @param byteTable
	 */
	public ExtendedPrecision64(byte[] byteTable) {
		super(byteTable, sizeInBytes, exponentSizeInBits, infinityExponent);
	}

}
