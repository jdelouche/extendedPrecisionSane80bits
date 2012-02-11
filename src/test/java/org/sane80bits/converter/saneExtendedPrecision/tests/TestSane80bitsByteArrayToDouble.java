package org.sane80bits.converter.saneExtendedPrecision.tests;

import org.sane80bits.converter.model.ExtendedPrecision;
import org.sane80bits.converter.saneExtendedPrecision.ExtendedPrecision80;
import org.sane80bits.converter.saneExtendedPrecision.testAbstract.AbstractTestDefines;
import org.testng.annotations.Test;

/**
 * 
 * <p>Schema of an sane 80 bits number
 * <p>sign * 2pow(exponent) * mantissa</p></p>
 * 
 * <p>79      : sign (1 bit)
 * <br/>64-78 : exponent (15 bits)
 * <br/>0-63  : significand (64 bits)</p>
 * 
 * 
 * 
 * @author Jean-Pierre Delouche
 * 
 */
public class TestSane80bitsByteArrayToDouble extends AbstractTestDefines {

	@Test(description="byte array 80bits NaN to double")
	public void sane80bitsByteArrayNotaNumberToDouble() {

		byte[] b = new byte[10];
		b[9] = (byte) 0x7f;
		b[8] = (byte) 0xff;
		b[7] = (byte) 0x00;
		b[6] = (byte) 0x00;
		b[5] = (byte) 0x00;
		b[4] = (byte) 0x00;
		b[3] = (byte) 0x00;
		b[2] = (byte) 0x00;
		b[1] = (byte) 0x00;
		b[0] = (byte) 0x01;

		showByteArray(b);

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		showSane80bits(decoder);

		assert decoder.isPositive();
		assert decoder.getExponentValue() == Integer.MAX_VALUE;
		assert decoder.getSignificandValue() != 0;
		assert Double.isNaN(decoder.getDoubleValue());

	}

	@Test(description="byte array 80bits negative NaN to double")
	public void sane80bitsByteArrayNegativeNotaNumberToDouble() {

		byte[] b = new byte[10];
		b[9] = (byte) 0xff;
		b[8] = (byte) 0xff;
		b[7] = (byte) 0x00;
		b[6] = (byte) 0x00;
		b[5] = (byte) 0x00;
		b[4] = (byte) 0x00;
		b[3] = (byte) 0x00;
		b[2] = (byte) 0x00;
		b[1] = (byte) 0x00;
		b[0] = (byte) 0x01;

		showByteArray(b);

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		showSane80bits(decoder);

		assert !decoder.isPositive();
		assert decoder.getExponentValue() == Integer.MAX_VALUE;
		assert decoder.getSignificandValue() != 0;
		assert Double.isNaN(decoder.getDoubleValue());

	}

	@Test(description="byte array 80bits infinity to double")
	public void sane80bitsByteArrayInfinityToDouble() {

		byte[] b = new byte[10];
		b[9] = (byte) 0x7f;
		b[8] = (byte) 0xff;
		b[7] = (byte) 0x00;
		b[6] = (byte) 0x00;
		b[5] = (byte) 0x00;
		b[4] = (byte) 0x00;
		b[3] = (byte) 0x00;
		b[2] = (byte) 0x00;
		b[1] = (byte) 0x00;
		b[0] = (byte) 0x00;

		showByteArray(b);

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		showSane80bits(decoder);

		assert decoder.isPositive();
		assert decoder.getExponentValue() == Integer.MAX_VALUE;
		assert decoder.getSignificandValue() == 0;
		assert decoder.getDoubleValue() == Double.POSITIVE_INFINITY;

	}

	@Test(description="byte array 80bits negative infintiy to double")
	public void sane80bitsByteArrayMinusInfinityToDouble() {

		byte[] b = new byte[10];
		b[9] = (byte) 0xff;
		b[8] = (byte) 0xff;
		b[7] = (byte) 0x00;
		b[6] = (byte) 0x00;
		b[5] = (byte) 0x00;
		b[4] = (byte) 0x00;
		b[3] = (byte) 0x00;
		b[2] = (byte) 0x00;
		b[1] = (byte) 0x00;
		b[0] = (byte) 0x00;

		showByteArray(b);

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		showSane80bits(decoder);

		assert !decoder.isPositive();
		assert decoder.getExponentValue() == Integer.MAX_VALUE;
		assert decoder.getSignificandValue() == 0;
		assert decoder.getDoubleValue() == Double.NEGATIVE_INFINITY;

	}

	@Test(description="byte array 80bits zero to double")
	public void sane80bitsByteArrayPositiveZeroToDouble() {

		byte[] b = new byte[10];
		b[9] = (byte) 0x00;
		b[8] = (byte) 0x00;
		b[7] = (byte) 0x00;
		b[6] = (byte) 0x00;
		b[5] = (byte) 0x00;
		b[4] = (byte) 0x00;
		b[3] = (byte) 0x00;
		b[2] = (byte) 0x00;
		b[1] = (byte) 0x00;
		b[0] = (byte) 0x00;

		showByteArray(b);

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		showSane80bits(decoder);

		assert decoder.isPositive();
		assert decoder.getExponentValue() == 0;
		assert decoder.getSignificandValue() == 0;
		assert decoder.getDoubleValue() == 0;
	}

	@Test(description="byte array 80bits negative zero to double")
	public void sane80bitsByteArrayNegativeZeroToDouble() {

		byte[] b = new byte[10];
		b[9] = (byte) 0x80;
		b[8] = (byte) 0x00;
		b[7] = (byte) 0x00;
		b[6] = (byte) 0x00;
		b[5] = (byte) 0x00;
		b[4] = (byte) 0x00;
		b[3] = (byte) 0x00;
		b[2] = (byte) 0x00;
		b[1] = (byte) 0x00;
		b[0] = (byte) 0x00;

		showByteArray(b);

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		showSane80bits(decoder);

		assert !decoder.isPositive();
		assert decoder.getExponentValue() == 0;
		assert decoder.getSignificandValue() == 0;
		assert decoder.getDoubleValue() == 0;
	}

	@Test(description="byte array 80bits one to double")
	public void sane80bitsByteArray1ToDouble() {

		byte[] b = new byte[10];
		b[9] = (byte) 0x3f;
		b[8] = (byte) 0xff;
		b[7] = (byte) 0x80;
		b[6] = (byte) 0x00;
		b[5] = (byte) 0x00;
		b[4] = (byte) 0x00;
		b[3] = (byte) 0x00;
		b[2] = (byte) 0x00;
		b[1] = (byte) 0x00;
		b[0] = (byte) 0x00;

		showByteArray(b);

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		showSane80bits(decoder);

		assert decoder.isPositive();
		assert decoder.getExponentValue() == 0;
		assert decoder.getSignificandValue() == 1.0;
		assert decoder.getDoubleValue() == 1.0;
	}

	@Test(description="byte array sane80bits 2.0 to double")
	public void sane80bits2toSane80bitsDouble() {

		byte[] b = new byte[10];
		b[9] = (byte) 0x40;
		b[8] = (byte) 0x00;
		b[7] = (byte) 0x00;
		b[6] = (byte) 0x00;
		b[5] = (byte) 0x00;
		b[4] = (byte) 0x00;
		b[3] = (byte) 0x00;
		b[2] = (byte) 0x00;
		b[1] = (byte) 0x00;
		b[0] = (byte) 0x00;

		showByteArray(b);

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		showSane80bits(decoder);

		assert decoder.isPositive();
		assert decoder.getExponentValue() == 1;
		assert decoder.getSignificandValue() == 0;
		assert decoder.getDoubleValue() == 2.0;
	}

	@Test(description="byte array sane80bits 0.5 to double")
	public void sane80bitsByteArrayHalftoDouble() {

		byte[] b = new byte[10];
		b[9] = (byte) 0x3f;
		b[8] = (byte) 0xfe;
		b[7] = (byte) 0x80;
		b[6] = (byte) 0x00;
		b[5] = (byte) 0x00;
		b[4] = (byte) 0x00;
		b[3] = (byte) 0x00;
		b[2] = (byte) 0x00;
		b[1] = (byte) 0x00;
		b[0] = (byte) 0x00;

		showByteArray(b);

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		showSane80bits(decoder);

		assert decoder.isPositive();
		assert decoder.getExponentValue() == -1;
		assert decoder.getSignificandValue() == 1;
		assert decoder.getDoubleValue() == 0.5;
	}

	@Test(description="byte array sane80bits 3/4 to double")
	public void sane80bitsByteArayThreeQuarterToDouble() {

		byte[] b = new byte[10];
		b[9] = (byte) 0x3f;
		b[8] = (byte) 0xfe;
		b[7] = (byte) 0xc0;
		b[6] = (byte) 0x00;
		b[5] = (byte) 0x00;
		b[4] = (byte) 0x00;
		b[3] = (byte) 0x00;
		b[2] = (byte) 0x00;
		b[1] = (byte) 0x00;
		b[0] = (byte) 0x00;

		showByteArray(b);

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		showSane80bits(decoder);

		assert decoder.isPositive();
		assert decoder.getExponentValue() == -1;
		assert decoder.getSignificandValue() == 1.5;
		assert decoder.getDoubleValue() == 0.75;
	}

	@Test(description="byte array sane80bits -1.0 to double")
	public void sane80bitsByteArrayMinus1toDouble() {

		byte[] b = new byte[10];
		b[9] = (byte) 0xbf;
		b[8] = (byte) 0xff;
		b[7] = (byte) 0x80;
		b[6] = (byte) 0x00;
		b[5] = (byte) 0x00;
		b[4] = (byte) 0x00;
		b[3] = (byte) 0x00;
		b[2] = (byte) 0x00;
		b[1] = (byte) 0x00;
		b[0] = (byte) 0x00;

		showByteArray(b);

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		showSane80bits(decoder);

		assert !decoder.isPositive();
		assert decoder.getExponentValue() == 0;
		assert decoder.getSignificandValue() == 1.0;
		assert decoder.getDoubleValue() == -1.0;
	}

	@Test(description="byte array sane80bits 22255 to double")
	public void sane80bitsByteArray22255toDouble() {

		byte[] b = new byte[10];
		b[9] = (byte) 0x40;
		b[8] = (byte) 0x0d;
		b[7] = (byte) 0xad;
		b[6] = (byte) 0xde;
		b[5] = (byte) 0x00;
		b[4] = (byte) 0x00;
		b[3] = (byte) 0x00;
		b[2] = (byte) 0x00;
		b[1] = (byte) 0x00;
		b[0] = (byte) 0x00;

		showByteArray(b);

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		showSane80bits(decoder);

		assert decoder.isPositive();
		assert decoder.getExponentValue() == 14;
		assert decoder.getSignificandValue() == 1.35833740234375;
		assert decoder.getDoubleValue() == 22255;
	}

	@Test(description="byte array sane80bits 48000 to double")
	public void sane80bitsByteArray48000toDouble() {

		byte[] b = new byte[10];
		b[9] = (byte) 0x40;
		b[8] = (byte) 0x0e;
		b[7] = (byte) 0xbb;
		b[6] = (byte) 0x80;
		b[5] = (byte) 0x00;
		b[4] = (byte) 0x00;
		b[3] = (byte) 0x00;
		b[2] = (byte) 0x00;
		b[1] = (byte) 0x00;
		b[0] = (byte) 0x00;

		showByteArray(b);

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		showSane80bits(decoder);

		assert decoder.isPositive();
		assert decoder.getExponentValue() == 15;
		assert decoder.getSignificandValue() == 1.46484375;
		assert decoder.getDoubleValue() == 48000;

	}

	@Test(description="byte array sane80bits 8000 to double")
	public void sane80bitsByteArray8000toDouble() {

		byte[] b = new byte[10];
		b[9] = (byte) 0x40;
		b[8] = (byte) 0x0b;
		b[7] = (byte) 0xfa;
		b[6] = (byte) 0x00;
		b[5] = (byte) 0x00;
		b[4] = (byte) 0x00;
		b[3] = (byte) 0x00;
		b[2] = (byte) 0x00;
		b[1] = (byte) 0x00;
		b[0] = (byte) 0x00;

		showByteArray(b);

		ExtendedPrecision80 decoder = new ExtendedPrecision80(b);

		showSane80bits(decoder);

		assert decoder.isPositive();
		assert decoder.getExponentValue() == 12;
		assert decoder.getSignificandValue() == 1.953125;
		assert decoder.getDoubleValue() == 8000;
	}

	@Test(description="byte array sane80bits 32000 to double")
	public void sane80bitsByteArray32000toDouble() {

		byte[] b = new byte[10];
		b[9] = (byte) 0x40;
		b[8] = (byte) 0x0d;
		b[7] = (byte) 0xfa;
		b[6] = (byte) 0x00;
		b[5] = (byte) 0x00;
		b[4] = (byte) 0x00;
		b[3] = (byte) 0x00;
		b[2] = (byte) 0x00;
		b[1] = (byte) 0x00;
		b[0] = (byte) 0x00;

		showByteArray(b);

		ExtendedPrecision80 decoder = new ExtendedPrecision80(b);

		showSane80bits(decoder);

		assert decoder.isPositive();
		assert decoder.getExponentValue() == 14;
		assert decoder.getSignificandValue() == 1.953125;
		assert decoder.getDoubleValue() == 32000;
	}

	@Test(description="byte array sane80bits 44100 to double")
	public void sane80bitsByteArray44100toDouble() {

		byte[] b = new byte[10];
		b[9] = (byte) 0x40;
		b[8] = (byte) 0x0e;
		b[7] = (byte) 0xac;
		b[6] = (byte) 0x44;
		b[5] = (byte) 0x00;
		b[4] = (byte) 0x00;
		b[3] = (byte) 0x00;
		b[2] = (byte) 0x00;
		b[1] = (byte) 0x00;
		b[0] = (byte) 0x00;

		showByteArray(b);

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		showSane80bits(decoder);

		assert decoder.isPositive();
		assert decoder.getExponentValue() == 15;
		assert decoder.getSignificandValue() == 1.3458251953125;
		assert decoder.getDoubleValue() == 44100;
	}

	@Test(description="byte array sane80bits 11127 to double")
	public void sane80bitsByteArray11127toDouble() {

		byte[] b = new byte[10];
		b[9] = (byte) 0x40;
		b[8] = (byte) 0x0c;
		b[7] = (byte) 0xad;
		b[6] = (byte) 0xdc;
		b[5] = (byte) 0x00;
		b[4] = (byte) 0x00;
		b[3] = (byte) 0x00;
		b[2] = (byte) 0x00;
		b[1] = (byte) 0x00;
		b[0] = (byte) 0x00;

		showByteArray(b);

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		showSane80bits(decoder);

		assert decoder.isPositive();
		assert decoder.getExponentValue() == 13;
		assert decoder.getSignificandValue() == 1.3582763671875;
		assert decoder.getDoubleValue() == 11127;

		assertEquals(b, decoder);

	}

	@Test(description="byte array sane80bits 22255 to binary string")
	public void sane80bitsByteArray11127toBinaryString() {

		byte[] b = new byte[10];
		b[9] = (byte) 0x40;
		b[8] = (byte) 0x0c;
		b[7] = (byte) 0xad;
		b[6] = (byte) 0xdc;
		b[5] = (byte) 0x00;
		b[4] = (byte) 0x00;
		b[3] = (byte) 0x00;
		b[2] = (byte) 0x00;
		b[1] = (byte) 0x00;
		b[0] = (byte) 0x00;

		showByteArray(b);

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		showSane80bits(decoder);

		assert decoder.isPositive();
		assert decoder.getExponentValue() == 13;
		assert decoder.getSignificandValue() == 1.3582763671875;
		assert decoder.getDoubleValue() == 11127;

		assert decoder.getBitTable()[79] == false;
		assert decoder.getBitTable()[78] == true;

		showBinaryString(SANE_80_BITS_BINARY_STRING + decoder.toBinaryString());

		assert decoder
				.toBinaryString()
				.matches(
						"01000000000011001010110111011100000000000000000000000000000000000000000000000000");
		assert decoder
				.significandToBinaryString()
				.matches(
						"1010110111011100000000000000000000000000000000000000000000000000");

		assert decoder.exponentToBinaryString().matches("100000000001100");

		assert decoder.signumToBinaryString().matches("0");

	}

	@Test(description="byte array sane80bits 11127 to binary string")
	public void sane80bitsByteArrayMinus11127toBinaryString() {

		byte[] b = new byte[10];
		b[9] = (byte) 0xc0;
		b[8] = (byte) 0x0c;
		b[7] = (byte) 0xad;
		b[6] = (byte) 0xdc;
		b[5] = (byte) 0x00;
		b[4] = (byte) 0x00;
		b[3] = (byte) 0x00;
		b[2] = (byte) 0x00;
		b[1] = (byte) 0x00;
		b[0] = (byte) 0x00;

		showByteArray(b);

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		showSane80bits(decoder);

		assert !decoder.isPositive();
		assert decoder.getExponentValue() == 13;
		assert decoder.getSignificandValue() == 1.3582763671875;
		assert decoder.getDoubleValue() == -11127;

		assert decoder.getBitTable()[79] == true;
		assert decoder.getBitTable()[78] == true;

		showBinaryString(SANE_80_BITS_BINARY_STRING + decoder.toBinaryString());

		assert decoder
				.toBinaryString()
				.matches(
						"11000000000011001010110111011100000000000000000000000000000000000000000000000000");
		assert decoder
				.toBinaryString()
				.matches(
						"11000000000011001010110111011100000000000000000000000000000000000000000000000000");

		assert decoder
				.significandToBinaryString()
				.matches(
						"1010110111011100000000000000000000000000000000000000000000000000");

		assert decoder.exponentToBinaryString().matches("100000000001100");

		assert decoder.signumToBinaryString().matches("1");
	}

	@Test(description="byte array sane80bits -22255 to double")
	public void sane80bitsByteArrayMinus22255() {

		byte[] b = new byte[10];
		b[9] = (byte) 0xc0;
		b[8] = (byte) 0x0d;
		b[7] = (byte) 0xad;
		b[6] = (byte) 0xde;
		b[5] = (byte) 0x00;
		b[4] = (byte) 0x00;
		b[3] = (byte) 0x00;
		b[2] = (byte) 0x00;
		b[1] = (byte) 0x00;
		b[0] = (byte) 0x00;

		showByteArray(b);

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		showSane80bits(decoder);

		assert !decoder.isPositive();
		assert decoder.getExponentValue() == 14;
		assert decoder.getSignificandValue() == 1.35833740234375;
		assert decoder.getDoubleValue() == -22255;

	}
}
