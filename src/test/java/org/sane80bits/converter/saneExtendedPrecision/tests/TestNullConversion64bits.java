package org.sane80bits.converter.saneExtendedPrecision.tests;

import org.sane80bits.converter.model.ExtendedPrecision;
import org.sane80bits.converter.saneExtendedPrecision.samesize.ExtendedPrecision64;
import org.testng.annotations.Test;

public class TestNullConversion64bits extends AbstractTestDefines {

	@Test(description="null conversion 0 to double")
	public void nullConversion64bits0() {
	
		int test = 0;
	
		Long integ = Double.doubleToRawLongBits(test);
	
		byte[] b = new byte[8];
		setByteArray(integ, b);
	
		ExtendedPrecision decoder = new ExtendedPrecision64(b);
	
		showSane64bits(decoder);
	
		assert decoder.isPositive();
		assert decoder.getDoubleValue() == (double) test;
	
	}

	@Test(description="null conversion 0.1 to double")
	public void nullConversion64bits01() {
	
		Double test = 0.1;
	
		Long integ = Double.doubleToRawLongBits(test);
	
		byte[] b = new byte[8];
		setByteArray(integ, b);
	
		ExtendedPrecision decoder = new ExtendedPrecision64(b);
	
		showSane64bits(decoder);
	
		assert decoder.isPositive();
		assert decoder.getDoubleValue() == (double) test;
	
	}

	@Test(description="null conversion 1 to double")
	public void nullConversion64bits1() {
	
		int test = 1;
	
		Long integ = Double.doubleToRawLongBits(test);
	
		byte[] b = new byte[8];
		setByteArray(integ, b);
	
		ExtendedPrecision decoder = new ExtendedPrecision64(b);
	
		showSane64bits(decoder);
	
		assert decoder.isPositive();
		assert decoder.getDoubleValue() == (double) test;
	
	}

	@Test(description="null conversion 16 to double")
	public void nullConversion64bits16() {
	
		Long integ = Double.doubleToRawLongBits(16);
	
		byte[] b = new byte[8];
		for (int i = 0; i <= 7; i++) {
			b[i] = (byte) (integ >> i * 8);
		}
	
		ExtendedPrecision decoder = new ExtendedPrecision64(b);
	
		showSane64bits(decoder);
	
		assert decoder.isPositive();
		assert decoder.getExponentValue() == 4;
		assert decoder.getSignificandValue() == 1.0;
		assert decoder.getDoubleValue() == 16;
	
	}

	@Test(description="null conversion fro; 1 to 100 to double")
	public void nullConversion64bits1to100() {
	
		for (int test = 2; test <= 100; test++) {
	
			Long integ = Double.doubleToRawLongBits(test);
	
			byte[] b = new byte[8];
			setByteArray(integ, b);
	
			ExtendedPrecision decoder = new ExtendedPrecision64(b);
	
			showSane64bits(decoder);
	
			assert decoder.isPositive();
			assert decoder.getDoubleValue() == (double) test;
	
		}
	
	}

	@Test(description="null conversion -22255 to double")
	public void nullConversion64bits2() {
	
		Long integ = Double.doubleToRawLongBits(2);
	
		byte[] b = new byte[8];
		for (int i = 0; i <= 7; i++) {
			b[i] = (byte) (integ >> i * 8);
		}
	
		ExtendedPrecision decoder = new ExtendedPrecision64(b);
	
		showSane64bits(decoder);
	
		assert decoder.isPositive();
		assert decoder.getExponentValue() == 1;
		assert decoder.getSignificandValue() == 1.0;
		assert decoder.getDoubleValue() == 2;
	
	}

	@Test(description="null conversion 3 to double")
	public void nullConversion64bits3() {
	
		Long integ = Double.doubleToRawLongBits(3);
	
		byte[] b = new byte[8];
		setByteArray(integ, b);
	
		ExtendedPrecision decoder = new ExtendedPrecision64(b);
	
		showSane64bits(decoder);
	
		assert decoder.isPositive();
		assert decoder.getExponentValue() == 1;
		assert decoder.getSignificandValue() == 1.5;
		assert decoder.getDoubleValue() == 3.0;
	
	}

	@Test(description="null conversion 4 to double")
	public void nullConversion64bits4() {
	
		Long integ = Double.doubleToRawLongBits(4);
	
		byte[] b = new byte[8];
		for (int i = 0; i <= 7; i++) {
			b[i] = (byte) (integ >> i * 8);
		}
	
		ExtendedPrecision decoder = new ExtendedPrecision64(b);
	
		showSane64bits(decoder);
	
		assert decoder.isPositive();
		assert decoder.getExponentValue() == 2;
		assert decoder.getSignificandValue() == 1.0;
		assert decoder.getDoubleValue() == 4;
	
	}

	@Test(description="null conversion NaN to double")
	public void nullConversion64bitsNaN() {
	
		Long integ = Double.doubleToRawLongBits(Double.NaN);
	
		byte[] b = new byte[8];
		setByteArray(integ, b);
	
		ExtendedPrecision decoder = new ExtendedPrecision64(b);
	
		showSane64bits(decoder);
	
		assert decoder.isPositive();
		assert Double.isNaN(decoder.getDoubleValue());
	
	}

	@Test(description="null conversion PI to double")
	public void nullConversion64bitsPI() {
	
		Long integ = Double.doubleToRawLongBits(Math.PI);
	
		byte[] b = new byte[8];
		setByteArray(integ, b);
	
		ExtendedPrecision decoder = new ExtendedPrecision64(b);
	
		showSane64bits(decoder);
	
		assert decoder.isPositive();
		assert decoder.getDoubleValue() == Math.PI;
	
	}

}
