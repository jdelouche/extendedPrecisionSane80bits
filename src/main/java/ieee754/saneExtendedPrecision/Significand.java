package ieee754.saneExtendedPrecision;

class Significand {

	double significand;

	protected BitTable binarySignificand;

	public Significand(AbstractExtendedPrecision impl) {

		boolean[] btTable = impl.bitTable.value();

		int shiftForHiddenBit;

		if (impl.floatSizeInBits == 64) {
			shiftForHiddenBit = 1;

		} else {
			shiftForHiddenBit = 0;
		}

		binarySignificand = new BitTable(impl.significandSize);
		significand = 0;
		for (int significandBitID = impl.significandBase + impl.significandSize
				- 1; significandBitID >= impl.significandBase; significandBitID--) {
			binarySignificand.set(significandBitID, btTable[significandBitID]);
			if (btTable[significandBitID]) {
				double deltaMantisse = StrictMath
						.pow(2, -(double) (impl.significandSize - 1
								- significandBitID + shiftForHiddenBit));
				significand += deltaMantisse;
			}
		}
	}

	public void addHidddenBit() {
		significand += 1;
	}

	public double value() {
		return significand;
	}

}
