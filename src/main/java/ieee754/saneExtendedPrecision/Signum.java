package ieee754.saneExtendedPrecision;

class Signum {

	boolean positive;
	public BitTable binarySignum;

	public Signum(AbstractExtendedPrecision impl) {
		binarySignum = new BitTable(1);
		binarySignum.set(0, impl.bitTable.value()[impl.bitSignPosition]);
		positive = ! impl.bitTable.value()[impl.bitSignPosition];
		
	}
	
	public boolean isPositive() {
		return positive;
	}
	
	public int value() {
		if (this.isPositive()) {
			return 1;
		} else {
			return -1;
		}
	}

}
