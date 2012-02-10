package org.sane80bits.converter.model;

/**
 * 
 * Interface to get the result of the conversion
 * 
 * @author Jean-pierre Delouche
 *
 */
public interface ExtendedPrecision {

	public abstract boolean isPositive();

	public abstract int getExponentValue();

	public abstract double getSignificandValue();

	public abstract double getDoubleValue();
	
	public byte[] getByteTable();

	public abstract boolean[] getBitTable();

	public abstract String toBinaryString();

	public abstract String significandToBinaryString();

	public abstract String exponentToBinaryString();

	public abstract String signumToBinaryString();

}