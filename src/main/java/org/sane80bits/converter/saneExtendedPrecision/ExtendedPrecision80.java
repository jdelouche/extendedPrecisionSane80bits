package org.sane80bits.converter.saneExtendedPrecision;

import org.sane80bits.converter.model.ExtendedPrecision;
import org.sane80bits.converter.saneExtendedPrecision.anysize.AbstractExtendedPrecision;


/**
 * 
 * Conversion to Double Java 64 bits of a SANE 80bits representation
 * 
 * Standard Apple Numeric Environment SANE 80 bits
 * 
 * @author Jean-Pierre Delouche
 * 
 */
public class ExtendedPrecision80 extends AbstractExtendedPrecision implements
		ExtendedPrecision {

	private static final int infinityExponent = 0x7fff;
	private static final int exponentSizeInBits = 15;
	private static final int sizeInBytes = 10;

	/**
	 * Creates an 80 bits representation from a <code>byte</code> array
	 * 
	 * @param byteTable
	 */
	public ExtendedPrecision80(byte[] byteTable) {
		super(byteTable, sizeInBytes, exponentSizeInBits, infinityExponent);
	}

	/**
	 * Creates an 80 bits representation from a <code>double</code> java 64 bits
	 * 
	 * @param i
	 */
	public ExtendedPrecision80(double i) {
		super(i, sizeInBytes, exponentSizeInBits, infinityExponent);
	}

}
