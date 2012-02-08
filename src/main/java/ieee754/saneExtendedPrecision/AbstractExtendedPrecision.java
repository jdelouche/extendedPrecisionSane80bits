package ieee754.saneExtendedPrecision;

import ieee754.model.ExtendedPrecision;

abstract class AbstractExtendedPrecision extends ExtendedPrecisionBinaryString implements ExtendedPrecision {

	private double value;

	private Signum sign;

	private Exponent exponent;

	private Significand significand;

	protected AbstractExtendedPrecision(byte[] byteTable, int floatSizeInBytes,
			int exponentSize, int infinityExponent) {

		super(byteTable, floatSizeInBytes, exponentSize, infinityExponent);

		parseByteTable();

	}

	protected AbstractExtendedPrecision(double i, int floatSizeInBytes,
			int exponentSize, int infinityExponent) {

		super(i, floatSizeInBytes, exponentSize, infinityExponent);

		parseByteTable();

	}

	private void parseByteTable() {

		sign = new Signum(this);

		exponent = new Exponent(this);

		significand = new Significand(this);

		setValue();
	}

	private void setValue() {

		if (exponent.value() == Integer.MAX_VALUE) {
			specialValue();
		} else {
			regularValue();
		}
	}

	private void specialValue() {
		if (significand.value() == 0) {
			infinityValue();
		} else {
			notAnumberValue();
		}
	}

	private void regularValue() {
		if (significand.value() == 0) {
			if (exponent.hasNoBitSet()) {
				zeroValue();
			} else {
				hiddenBit();
				integerValue();
			}
		} else {
			hiddenBit();
			floatValue();

		}
	}

	private void infinityValue() {
		if (sign.isPositive()) {
			value = Double.POSITIVE_INFINITY;
		} else {
			value = Double.NEGATIVE_INFINITY;
		}
	}

	private void notAnumberValue() {
		value = Double.NaN;
	}

	private void zeroValue() {
		value = 0;
	}

	private void hiddenBit() {
		if (floatSizeInBits == 64) {
			significand.addHidddenBit();
		}
	}

	private void floatValue() {
		value = sign.value() * StrictMath.pow(2, exponent.value())
				* significand.value();
	}

	private void integerValue() {
		value = sign.value() * StrictMath.pow(2, exponent.value());
	}

	public byte[] getByteTable() {
		return byteTable;
	}

	public boolean[] getBitTable() {
		return bitTable.value();
	}

	public double getDoubleValue() {
		return value;
	}
	
	public boolean isPositive() {		
		return sign.isPositive();
	}
	
	public double getSignificandValue() {
		return significand.value();
	}	
	
	public int getExponentValue() {
		return exponent.value();
	}
	
	public String toBinaryString() {
		return bitTable.toString();
	}

	public String significandToBinaryString() {
		return significand.binarySignificand.toString();
	}

	public String exponentToBinaryString() {
		return exponent.binaryExponent.toString();
	}

	public String signumToBinaryString() {
		return sign.binarySignum.toString();
	}


	
}
