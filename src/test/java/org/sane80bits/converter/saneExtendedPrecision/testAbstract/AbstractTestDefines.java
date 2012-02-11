package org.sane80bits.converter.saneExtendedPrecision.testAbstract;

import java.io.PrintStream;

import org.sane80bits.converter.model.ExtendedPrecision;
import org.testng.Reporter;

abstract public class AbstractTestDefines {

	protected static final String displayFormatByteTable    = "%02d 0x%02x";
	protected static final String SANE_80_BITS     = "SANE 80 bits => ";
	protected static final String SANE_SIGNIFICAND = "SANE 80 bits significand ";
	protected static final String SANE_EXPONENT    = "SANE 80 bits exponent    ";
	protected static final String SANE_POSITIVE    = "SANE 80 bits positive    ";
	protected static final String SANE_64_BITS     = "SANE  64 bits =>         ";
	protected static final String SANE_80_BITS_BINARY_STRING = "80 bits BinaryString: ";
	static private PrintStream out=System.out;

	public static PrintStream getOut() {
		return out;
	}

	public void setOut(PrintStream out) {
		AbstractTestDefines.out = out;
	}

	public AbstractTestDefines() {
		super();
	}

	protected void setByteArray(Long integ, byte[] b) {
		for (int i = 7; i >= 0; i--) {
			b[i] = (byte) (integ >> i * 8);
		}
		showByteArray(b);
	}

	protected void showByteArray(byte[] b) {
		for (int i = b.length -1; i >= 0; i--) {
			log(String.format(displayFormatByteTable, i, b[i]));
		}
	}

	protected void showSane64bits(ExtendedPrecision decoder) {
		log(SANE_POSITIVE + decoder.isPositive());
		log(SANE_EXPONENT + decoder.getExponentValue());
		log(SANE_SIGNIFICAND
				+ decoder.getSignificandValue());
		log(SANE_64_BITS
				+ decoder.getDoubleValue());
	}

	protected void assertEquals(byte[] b, ExtendedPrecision decoder) {
		assert decoder.getByteTable()[9] == b[9];
		assert decoder.getByteTable()[8] == b[8];
		assert decoder.getByteTable()[7] == b[7];
		assert decoder.getByteTable()[6] == b[6];
		assert decoder.getByteTable()[5] == b[5];
		assert decoder.getByteTable()[4] == b[4];
		assert decoder.getByteTable()[3] == b[3];
		assert decoder.getByteTable()[2] == b[2];
		assert decoder.getByteTable()[1] == b[1];
		assert decoder.getByteTable()[0] == b[0];
	}

	protected void showSane80bits(ExtendedPrecision decoder) {
		log(SANE_POSITIVE + decoder.isPositive());
		log(SANE_EXPONENT + decoder.getExponentValue());
		log(SANE_SIGNIFICAND
				+ decoder.getSignificandValue());
		log(SANE_80_BITS + decoder.getDoubleValue());
	}

	protected void showBinaryString(String string) {
		
		log(string);
		
	}

	static public void log(String msg) {
		out.println(msg);
		Reporter.log(msg);
	}

}