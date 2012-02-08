package ieee754.model;

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