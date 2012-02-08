package ieee754.saneExtendedPrecision;

import ieee754.model.ExtendedPrecision;

public class ExtendedPrecision64 extends AbstractExtendedPrecision implements
		ExtendedPrecision {

	private static final int infinityExponent = 0x7ff;
	private static final int exponentSizeInBits = 11;
	private static final int sizeInBytes = 8;

	public ExtendedPrecision64(byte[] byteTable) {
		super(byteTable, sizeInBytes, exponentSizeInBits, infinityExponent);
	}

}
