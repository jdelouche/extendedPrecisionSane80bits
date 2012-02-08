package ieee754.saneExtendedPrecision;

import ieee754.model.ExtendedPrecision;

// Standard Apple Numeric Environment
// SANE 80 bits to Double Java 64 bits
public class ExtendedPrecision80 extends AbstractExtendedPrecision implements ExtendedPrecision {
	
	private static final int infinityExponent = 0x7fff;
	private static final int exponentSizeInBits = 15;
	private static final int sizeInBytes = 10;

	public ExtendedPrecision80(byte[] byteTable) {
		super(byteTable, sizeInBytes,exponentSizeInBits,infinityExponent);
	}

	public ExtendedPrecision80(double i) {
		super(i,sizeInBytes,exponentSizeInBits,infinityExponent);
	}

}
