package ieee754.saneExtendedPrecision;

class Exponent {

	private int exponent;
	private boolean hasNoBitSet = false;
	protected BitTable binaryExponent;

	public Exponent(AbstractExtendedPrecision impl) {

		boolean[] btTable = impl.bitTable.value();
		binaryExponent = new BitTable(impl.exponentSize);
		int biasedExponent = 0;
		for (int bitPosition = impl.exponentBase + impl.exponentSize - 1; bitPosition >= impl.exponentBase; bitPosition--) {

			int bitOrder = bitPosition - impl.exponentBase;
			binaryExponent.set(bitOrder, btTable[bitPosition]);
			if (btTable[bitPosition]) {
				biasedExponent += (impl.lowOrderBit << bitOrder);
			}
		}
		if (biasedExponent == impl.nullExponent) {
			this.exponent = impl.nullExponentValue;
			setZero(true);
		} else {
			if (biasedExponent == impl.infinityExponent) {
				this.exponent = Integer.MAX_VALUE;
			} else {
				this.exponent = biasedExponent - impl.exponentBias;
			}
		}
	}

	public int value() {
		return exponent;
	}

	public boolean hasNoBitSet() {
		return hasNoBitSet;
	}

	private void setZero(boolean zero) {
		this.hasNoBitSet = zero;
	}

}
