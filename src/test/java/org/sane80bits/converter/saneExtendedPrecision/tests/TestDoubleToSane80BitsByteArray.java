package org.sane80bits.converter.saneExtendedPrecision.tests;

import org.sane80bits.converter.model.ExtendedPrecision;
import org.sane80bits.converter.saneExtendedPrecision.ExtendedPrecision80;
import org.sane80bits.converter.saneExtendedPrecision.testAbstract.AbstractTestDefines;
import org.testng.annotations.Test;

public class TestDoubleToSane80BitsByteArray extends AbstractTestDefines {

	@Test(description="double -11127 to sane80bits byte array")
	public void double11127toSane80bitsByteArray() {
	
		ExtendedPrecision decoder = new ExtendedPrecision80(-11127);
	
		assert decoder.getDoubleValue() == -11127;
		assert !decoder.isPositive();
		assert decoder.getExponentValue() == 13;
		assert decoder.getSignificandValue() == 1.3582763671875;
	
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
		
		assertEquals(b, decoder);
	
	}

	@Test(description="double 1.5 to sane80bits byte array")
	public void double1point5toByteArray() {
	
		ExtendedPrecision decoder = new ExtendedPrecision80(1.5);
	
		byte[] b = new byte[10];
		b[9] = (byte) 0x3f;
		b[8] = (byte) 0xff;
		b[7] = (byte) 0xc0;
		b[6] = (byte) 0x00;
		b[5] = (byte) 0x00;
		b[4] = (byte) 0x00;
		b[3] = (byte) 0x00;
		b[2] = (byte) 0x00;
		b[1] = (byte) 0x00;
		b[0] = (byte) 0x00;
	
		showByteArray(b);
	
		assertEquals(b, decoder);
	
	}

	@Test(description="double 0.1 to sane80bits byte array")
	public void double0point1toByteArray() {
	
		ExtendedPrecision decoder = new ExtendedPrecision80(1.5);
	
		byte[] b = new byte[10];
		b[9] = (byte) 0x3f;
		b[8] = (byte) 0xff;
		b[7] = (byte) 0xc0;
		b[6] = (byte) 0x00;
		b[5] = (byte) 0x00;
		b[4] = (byte) 0x00;
		b[3] = (byte) 0x00;
		b[2] = (byte) 0x00;
		b[1] = (byte) 0x00;
		b[0] = (byte) 0x00;
	
		showByteArray(b);
	
		assertEquals(b, decoder);
	
	}

	@Test(description="double 2 to sane80bits byte array")
	public void double2toByteArray() {
	
		ExtendedPrecision decoder = new ExtendedPrecision80(2);
	
		byte[] b = new byte[10];
		b[9] = (byte) 0x40;
		b[8] = (byte) 0x00;
		b[7] = (byte) 0x80;
		b[6] = (byte) 0x00;
		b[5] = (byte) 0x00;
		b[4] = (byte) 0x00;
		b[3] = (byte) 0x00;
		b[2] = (byte) 0x00;
		b[1] = (byte) 0x00;
		b[0] = (byte) 0x00;
	
		showByteArray(b);
	
		assertEquals(b, decoder);
	
	}

	@Test(description="double 48000 to sane80bits byte array")
	public void double48000toSane80bitsByteArray() {
	
		ExtendedPrecision decoder = new ExtendedPrecision80(48000);
	
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
	
		assertEquals(b, decoder);
	
	}

	@Test(description="double 8000 to sane80bits byte array")
	public void double8000toByteArray() {
	
		ExtendedPrecision decoder = new ExtendedPrecision80(8000);
	
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
	
		assertEquals(b, decoder);
	
	}

	@Test(description="double 0.5 to sane80bits byte array")
	public void doubleHalfToSane80bitsByteArray() {
	
		ExtendedPrecision decoder = new ExtendedPrecision80(0.5);
	
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
	
		assertEquals(b, decoder);
	
	}

	@Test(description="double poitive infinity to sane80bits byte array")
	public void doubleInfinityToSane80bitsByteArray() {
	
		ExtendedPrecision decoder = new ExtendedPrecision80(
				Double.POSITIVE_INFINITY);
	
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
	
		assertEquals(b, decoder);
	
	}

	@Test(description="double -1 to sane80bits byte array")
	public void doubleMinus1toByteArray() {
	
		ExtendedPrecision decoder = new ExtendedPrecision80(-1);
	
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
	
		assertEquals(b, decoder);
	
	}

	@Test(description="double NaN to sane80bits byte array")
	public void doubleNaNtoSane80bitsByteArray() {
	
		ExtendedPrecision decoder = new ExtendedPrecision80(Double.NaN);
	
		byte[] b = new byte[10];
		b[9] = (byte) 0x7f;
		b[8] = (byte) 0xff;
		b[7] = (byte) 0xc0;
		b[6] = (byte) 0x00;
		b[5] = (byte) 0x00;
		b[4] = (byte) 0x00;
		b[3] = (byte) 0x00;
		b[2] = (byte) 0x00;
		b[1] = (byte) 0x00;
		b[0] = (byte) 0x00;
	
		showByteArray(b);
	
		assertEquals(b, decoder);
	
	}

	@Test(description="double 48000 to sane80bits byte array")
	public void doubleNegative48000toSane80bitsByteArray() {
	
		ExtendedPrecision decoder = new ExtendedPrecision80(-48000);
	
		byte[] b = new byte[10];
		b[9] = (byte) 0xc0;
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
	
		assertEquals(b, decoder);
	
	}

	@Test(description="double negative infinity to sane80bits byte array")
	public void doubleNegativeInfinityToSane80bitsByteArray() {
	
		ExtendedPrecision decoder = new ExtendedPrecision80(
				Double.NEGATIVE_INFINITY);
	
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
	
		assertEquals(b, decoder);
	
	}

	@Test(description="double 1 to sane80bits byte array")
	public void doubleOneToSane80bitsByteArray() {
	
		ExtendedPrecision decoder = new ExtendedPrecision80(1);
	
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
	
		assertEquals(b, decoder);
	
	}

	@Test(description="double 11127 to sane80bits byte array")
	public void doubleTo11127toSane80bitsByteArray() {
	
		ExtendedPrecision decoder = new ExtendedPrecision80(11127);
	
		assert decoder.getDoubleValue() == 11127;
		assert decoder.isPositive();
		assert decoder.getExponentValue() == 13;
		assert decoder.getSignificandValue() == 1.3582763671875;
	
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
	
		assertEquals(b, decoder);
	
	}

}
