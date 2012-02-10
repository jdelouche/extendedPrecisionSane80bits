package org.sane80bits.converter.saneExtendedPrecision.anysize;


abstract class ExtendedPrecisionBinaryString {

	protected final int floatSizeInBytes;
	protected final int floatBase = 0;
	protected final int sizeOfByte = 8;
	protected final int floatSizeInBits;

	protected final long lowOrderBit = 0x01L;

	protected final int bitSignPosition;
	protected final int exponentSize;
	protected final int exponentBase;
	protected final int exponentBias;

	protected final int significandSize;
	protected final int significandBase;

	protected final int infinityExponent;
	protected final int nullExponent = 0;
	protected final int nullExponentValue = 0;

	protected final BitTable bitTable;
	protected byte[] byteTable;

	public ExtendedPrecisionBinaryString(byte[] byteTable2,
			int floatSizeInBytes2, int exponentSize2, int infinityExponent2) {

		floatSizeInBytes = floatSizeInBytes2;
		exponentSize = exponentSize2;
		infinityExponent = infinityExponent2;

		floatSizeInBits = floatSizeInBytes * sizeOfByte;

		bitSignPosition = floatSizeInBits - 1;
		exponentBase = bitSignPosition - exponentSize;
		exponentBias = (int) ((lowOrderBit << (exponentSize - 1)) - 1);

		significandSize = bitSignPosition - exponentSize;
		significandBase = floatBase;

		byteTable = byteTable2;
		
		bitTable = new BitTable(floatSizeInBits);

		bitTable.set(byteTable2, floatSizeInBytes, floatBase, lowOrderBit,
				sizeOfByte);

	}

	public ExtendedPrecisionBinaryString(double dbl, int floatSizeInBytes2,
			int exponentSize2, int infinityExponent2) {

		floatSizeInBytes = floatSizeInBytes2;
		exponentSize = exponentSize2;
		infinityExponent = infinityExponent2;

		floatSizeInBits = floatSizeInBytes * sizeOfByte;

		bitSignPosition = floatSizeInBits - 1;
		exponentBase = bitSignPosition - exponentSize;
		exponentBias = (int) ((lowOrderBit << (exponentSize - 1)) - 1);

		significandSize = bitSignPosition - exponentSize;
		significandBase = floatBase;

		bitTable = new BitTable(floatSizeInBits);

		byteTable = new byte[floatSizeInBytes];

		long bits = Double.doubleToRawLongBits(dbl);

		for (int i = 7; i >= 0; i--) {
			long mask = (0xffL << (i * 8));
			byteTable[i] = (byte) ((bits & mask) >> i * 8);
		}

		byte byteSign = (byte) (((bits >> 63) == 0) ? 0x00 : 0x80);
		int binaryExponent = (int) ((bits >> 52) & 0x7ffL);
		long binaryMantissa = (bits & 0xfffffffffffffL);

		int exponent = 0;
		int binaryExponent80 = 0;
		if (binaryExponent != 0x7ff) {
			exponent = binaryExponent - 0x3ff;
			binaryExponent80 = exponent + exponentBias;
		} else {
			binaryExponent80 = 0x7fff;
		}

		long binaryMantissa80 = 0;
		if (binaryExponent == 0x7ff) {
			if (binaryMantissa == 0) {
				binaryMantissa80 = 0;
			} else {
				binaryMantissa80 = (lowOrderBit << 63) + (binaryMantissa << 11);
			}
		} else {
			binaryMantissa80 = (lowOrderBit << 63) + (binaryMantissa << 11);
		}

		byteTable[9] = (byte) (((binaryExponent80 & 0x0000ff00) >> 8) | byteSign);
		byteTable[8] = (byte) (binaryExponent80 & 0x000000ff);

		for (int i = 7; i >= 0; i--) {
			long mask = (0xffL << (i * 8));
			byteTable[i] = (byte) ((binaryMantissa80 & mask) >> i * 8);
		}

		bitTable.set(byteTable, floatSizeInBytes, floatBase, lowOrderBit,
				sizeOfByte);

	}

}