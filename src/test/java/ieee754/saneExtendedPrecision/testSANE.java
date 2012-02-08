package ieee754.saneExtendedPrecision;

import ieee754.model.ExtendedPrecision;
import ieee754.saneExtendedPrecision.ExtendedPrecision64;
import ieee754.saneExtendedPrecision.ExtendedPrecision80;

import org.testng.annotations.Test;

public class testSANE {

	private static final String displayFormatByteTable = "%02d 0x%02x\n";
	private static final String SANE_IEEE_754_80_BITS = "SANE IEEE 754 80 bits => ";
	private static final String SANE_IEEE_754_SIGNIFICAND = "SANE IEEE 754 significand ";
	private static final String SANE_IEEE_754_EXPONENT = "SANE IEEE 754 exponent    ";
	private static final String SANE_IEEE_754_POSITIVE = "SANE IEEE 754 positive    ";

	@Test
	public void floatNotaNumber() {

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

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println(SANE_IEEE_754_80_BITS + decoder.getDoubleValue());

		assert decoder.isPositive();
		assert decoder.getExponentValue() == Integer.MAX_VALUE;
		assert decoder.getSignificandValue() != 0;
		assert Double.isNaN(decoder.getDoubleValue());

	}

	@Test
	public void floatNegativeNotaNumber() {

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

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println(SANE_IEEE_754_80_BITS + decoder.getDoubleValue());

		assert !decoder.isPositive();
		assert decoder.getExponentValue() == Integer.MAX_VALUE;
		assert decoder.getSignificandValue() != 0;
		assert Double.isNaN(decoder.getDoubleValue());

	}

	@Test
	public void floatInfinity() {

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

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println(SANE_IEEE_754_80_BITS + decoder.getDoubleValue());

		assert decoder.isPositive();
		assert decoder.getExponentValue() == Integer.MAX_VALUE;
		assert decoder.getSignificandValue() == 0;
		assert decoder.getDoubleValue() == Double.POSITIVE_INFINITY;

	}

	@Test
	public void floatMinusInfinity() {

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

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println(SANE_IEEE_754_80_BITS + decoder.getDoubleValue());

		assert !decoder.isPositive();
		assert decoder.getExponentValue() == Integer.MAX_VALUE;
		assert decoder.getSignificandValue() == 0;
		assert decoder.getDoubleValue() == Double.NEGATIVE_INFINITY;

	}

	@Test
	public void floatPositiveZero() {

		// sign * 2pow(exponent) * mantissa

		// 80 bits

		// sign 1
		// exponent 15 bits
		// mantisse 64

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

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println(SANE_IEEE_754_80_BITS + decoder.getDoubleValue());

		assert decoder.isPositive();
		assert decoder.getExponentValue() == 0;
		assert decoder.getSignificandValue() == 0;
		assert decoder.getDoubleValue() == 0;
	}

	@Test
	public void floatNegativeZero() {

		// sign * 2pow(exponent) * mantissa

		// 80 bits

		// sign 1
		// exponent 15 bits
		// mantisse 64

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

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println(SANE_IEEE_754_80_BITS + decoder.getDoubleValue());

		assert !decoder.isPositive();
		assert decoder.getExponentValue() == 0;
		assert decoder.getSignificandValue() == 0;
		assert decoder.getDoubleValue() == 0;
	}

	@Test
	public void float1() {

		// sign * 2pow(exponent) * mantissa

		// 80 bits

		// sign 1
		// exponent 15 bits
		// mantisse 64

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

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println(SANE_IEEE_754_80_BITS + decoder.getDoubleValue());

		assert decoder.isPositive();
		assert decoder.getExponentValue() == 0;
		assert decoder.getSignificandValue() == 1.0;
		assert decoder.getDoubleValue() == 1.0;
	}

	@Test
	public void toFloat1() {

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

	@Test
	public void toFloatMinus1() {

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

	@Test
	public void toFloat2() {

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

	@Test
	public void toFloat8000() {

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

	@Test
	public void toFloat1point5() {

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

	@Test
	public void toFloat11127() {

		ExtendedPrecision decoder = new ExtendedPrecision80(11127);

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

	@Test
	public void toFloat11127Decoder() {

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

	@Test
	public void toFloatMinus11127Decoder() {

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

	@Test
	public void toFloat48000() {

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

	@Test
	public void toFloatNegative48000() {

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

	public void toFloatHalf() {

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

	@Test
	public void toFloatNaN() {

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

	@Test
	public void toFloatInfinity() {

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

	@Test
	public void toFloatNegativeInfinity() {

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

	@Test
	public void floatPI() {

		// sign * 2pow(exponent) * mantissa

		// 80 bits

		// sign 1
		// exponent 15 bits
		// mantisse 64

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

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println(SANE_IEEE_754_80_BITS + decoder.getDoubleValue());

		assert decoder.isPositive();
		assert decoder.getExponentValue() == 0;
		assert decoder.getSignificandValue() == 1.0;
		assert decoder.getDoubleValue() == 1.0;
	}

	@Test
	public void float2() {

		// sign * 2pow(exponent) * mantissa

		// 80 bits

		// sign 1
		// exponent 15 bits
		// mantisse 64

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

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println(SANE_IEEE_754_80_BITS + decoder.getDoubleValue());

		assert decoder.isPositive();
		assert decoder.getExponentValue() == 1;
		assert decoder.getSignificandValue() == 0;
		assert decoder.getDoubleValue() == 2.0;
	}

	@Test
	public void floatHalf() {

		// sign * 2pow(exponent) * mantissa

		// 80 bits

		// sign 1
		// exponent 15 bits
		// mantisse 64

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

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println(SANE_IEEE_754_80_BITS + decoder.getDoubleValue());

		assert decoder.isPositive();
		assert decoder.getExponentValue() == -1;
		assert decoder.getSignificandValue() == 1;
		assert decoder.getDoubleValue() == 0.5;
	}

	@Test
	public void floatThreeQuarter() {

		// sign * 2pow(exponent) * mantissa

		// 80 bits

		// sign 1
		// exponent 15 bits
		// mantisse 64

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

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println(SANE_IEEE_754_80_BITS + decoder.getDoubleValue());

		assert decoder.isPositive();
		assert decoder.getExponentValue() == -1;
		assert decoder.getSignificandValue() == 1.5;
		assert decoder.getDoubleValue() == 0.75;
	}

	@Test
	public void floatMinus1() {

		// sign * 2pow(exponent) * mantissa

		// 80 bits

		// sign 1
		// exponent 15 bits
		// mantisse 64

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

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println(SANE_IEEE_754_80_BITS + decoder.getDoubleValue());

		assert !decoder.isPositive();
		assert decoder.getExponentValue() == 0;
		assert decoder.getSignificandValue() == 1.0;
		assert decoder.getDoubleValue() == -1.0;
	}

	@Test
	public void float22255() {

		// sign * 2pow(exponent) * mantissa

		// 80 bits

		// sign 1
		// exponent 15 bits
		// mantisse 64

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

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println(SANE_IEEE_754_80_BITS + decoder.getDoubleValue());

		assert decoder.isPositive();
		assert decoder.getExponentValue() == 14;
		assert decoder.getSignificandValue() == 1.35833740234375;
		assert decoder.getDoubleValue() == 22255;
	}

	@Test
	public void float48000() {

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

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println(SANE_IEEE_754_80_BITS + decoder.getDoubleValue());

		assert decoder.isPositive();
		assert decoder.getExponentValue() == 15;
		assert decoder.getSignificandValue() == 1.46484375;
		assert decoder.getDoubleValue() == 48000;

	}

	@Test
	public void float8000() {

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

		ExtendedPrecision80 decoder8000 = new ExtendedPrecision80(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder8000.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT
				+ decoder8000.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder8000.getSignificandValue());
		System.out
				.println(SANE_IEEE_754_80_BITS + decoder8000.getDoubleValue());

		assert decoder8000.isPositive();
		assert decoder8000.getExponentValue() == 12;
		assert decoder8000.getSignificandValue() == 1.953125;
		assert decoder8000.getDoubleValue() == 8000;
	}

	@Test
	public void float32000() {

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

		ExtendedPrecision80 decoder32000 = new ExtendedPrecision80(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder32000.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT
				+ decoder32000.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder32000.getSignificandValue());
		System.out.println(SANE_IEEE_754_80_BITS
				+ decoder32000.getDoubleValue());

		assert decoder32000.isPositive();
		assert decoder32000.getExponentValue() == 14;
		assert decoder32000.getSignificandValue() == 1.953125;
		assert decoder32000.getDoubleValue() == 32000;
	}

	@Test
	public void float44100() {

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

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println(SANE_IEEE_754_80_BITS + decoder.getDoubleValue());

		assert decoder.isPositive();
		assert decoder.getExponentValue() == 15;
		assert decoder.getSignificandValue() == 1.3458251953125;
		assert decoder.getDoubleValue() == 44100;
	}

	@Test
	public void float11127() {

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

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println(SANE_IEEE_754_80_BITS + decoder.getDoubleValue());

		assert decoder.isPositive();
		assert decoder.getExponentValue() == 13;
		assert decoder.getSignificandValue() == 1.3582763671875;
		assert decoder.getDoubleValue() == 11127;

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

	@Test
	public void float11127toBinaryString() {

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

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println(SANE_IEEE_754_80_BITS + decoder.getDoubleValue());

		assert decoder.isPositive();
		assert decoder.getExponentValue() == 13;
		assert decoder.getSignificandValue() == 1.3582763671875;
		assert decoder.getDoubleValue() == 11127;

		assert decoder.getBitTable()[79] == false;
		assert decoder.getBitTable()[78] == true;

		System.out.println("80 bits BinaryString: " + decoder.toBinaryString());

		assert decoder
		.toBinaryString()
		.matches(
				"01000000000011001010110111011100000000000000000000000000000000000000000000000000");
		assert decoder
		.significandToBinaryString()
		.matches(
				"1010110111011100000000000000000000000000000000000000000000000000");

		assert decoder
		.exponentToBinaryString()
		.matches(
				"100000000001100");
		
		assert decoder
		.signumToBinaryString()
		.matches(
				"0");
		
	}

	@Test
	public void floatMinus11127toBinaryString() {

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

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println(SANE_IEEE_754_80_BITS + decoder.getDoubleValue());

		assert !decoder.isPositive();
		assert decoder.getExponentValue() == 13;
		assert decoder.getSignificandValue() == 1.3582763671875;
		assert decoder.getDoubleValue() == -11127;

		assert decoder.getBitTable()[79] == true;
		assert decoder.getBitTable()[78] == true;

		System.out.println("80 bits BinaryString: " + decoder.toBinaryString());

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

		assert decoder
		.exponentToBinaryString()
		.matches(
				"100000000001100");
		
		assert decoder
		.signumToBinaryString()
		.matches(
				"1");
	}

	@Test
	public void floatMinus22255() {

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

		ExtendedPrecision decoder = new ExtendedPrecision80(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println(SANE_IEEE_754_80_BITS + decoder.getDoubleValue());

		assert !decoder.isPositive();
		assert decoder.getExponentValue() == 14;
		assert decoder.getSignificandValue() == 1.35833740234375;
		assert decoder.getDoubleValue() == -22255;

	}

	@Test
	public void float_64bits2() {

		Long integ = Double.doubleToRawLongBits(2);

		byte[] b = new byte[8];
		for (int i = 0; i <= 7; i++) {
			b[i] = (byte) (integ >> i * 8);
		}

		ExtendedPrecision decoder = new ExtendedPrecision64(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println("SANE IEEE 754 64 bits => "
				+ decoder.getDoubleValue());

		assert decoder.isPositive();
		assert decoder.getExponentValue() == 1;
		assert decoder.getSignificandValue() == 1.0;
		assert decoder.getDoubleValue() == 2;

	}

	@Test
	public void float_64bits4() {

		Long integ = Double.doubleToRawLongBits(4);

		byte[] b = new byte[8];
		for (int i = 0; i <= 7; i++) {
			b[i] = (byte) (integ >> i * 8);
		}

		ExtendedPrecision decoder = new ExtendedPrecision64(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println("SANE IEEE 754 64 bits => "
				+ decoder.getDoubleValue());

		assert decoder.isPositive();
		assert decoder.getExponentValue() == 2;
		assert decoder.getSignificandValue() == 1.0;
		assert decoder.getDoubleValue() == 4;

	}

	@Test
	public void float_64bits16() {

		Long integ = Double.doubleToRawLongBits(16);

		byte[] b = new byte[8];
		for (int i = 0; i <= 7; i++) {
			b[i] = (byte) (integ >> i * 8);
		}

		ExtendedPrecision decoder = new ExtendedPrecision64(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println("SANE IEEE 754 64 bits => "
				+ decoder.getDoubleValue());

		assert decoder.isPositive();
		assert decoder.getExponentValue() == 4;
		assert decoder.getSignificandValue() == 1.0;
		assert decoder.getDoubleValue() == 16;

	}

	@Test
	public void float_64bits3() {

		Long integ = Double.doubleToRawLongBits(3);

		byte[] b = new byte[8];
		for (int i = 0; i <= 7; i++) {
			b[i] = (byte) (integ >> i * 8);
			System.out.printf(displayFormatByteTable, i, b[i]);
		}

		ExtendedPrecision decoder = new ExtendedPrecision64(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println("SANE IEEE 754 64 bits => "
				+ decoder.getDoubleValue());

		assert decoder.isPositive();
		assert decoder.getExponentValue() == 1;
		assert decoder.getSignificandValue() == 1.5;
		assert decoder.getDoubleValue() == 3.0;

	}

	@Test
	public void float_64bits0() {

		int test = 0;

		Long integ = Double.doubleToRawLongBits(test);

		byte[] b = new byte[8];
		for (int i = 0; i <= 7; i++) {
			b[i] = (byte) (integ >> i * 8);
			System.out.printf(displayFormatByteTable, i, b[i]);
		}

		ExtendedPrecision decoder = new ExtendedPrecision64(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println("SANE IEEE 754 64 bits => "
				+ decoder.getDoubleValue());

		assert decoder.isPositive();
		assert decoder.getDoubleValue() == (double) test;

	}

	@Test
	public void float_64bits1() {

		int test = 1;

		Long integ = Double.doubleToRawLongBits(test);

		byte[] b = new byte[8];
		for (int i = 0; i <= 7; i++) {
			b[i] = (byte) (integ >> i * 8);
			System.out.printf(displayFormatByteTable, i, b[i]);
		}

		ExtendedPrecision decoder = new ExtendedPrecision64(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println("SANE IEEE 754 64 bits => "
				+ decoder.getDoubleValue());

		assert decoder.isPositive();
		assert decoder.getDoubleValue() == (double) test;

	}

	@Test
	public void float_64bits01() {

		Double test = 0.1;

		Long integ = Double.doubleToRawLongBits(test);

		byte[] b = new byte[8];
		for (int i = 0; i <= 7; i++) {
			b[i] = (byte) (integ >> i * 8);
			System.out.printf(displayFormatByteTable, i, b[i]);
		}

		ExtendedPrecision decoder = new ExtendedPrecision64(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println("SANE IEEE 754 64 bits => "
				+ decoder.getDoubleValue());

		assert decoder.isPositive();
		assert decoder.getDoubleValue() == (double) test;

	}

	@Test
	public void float_64bits1to100() {

		for (int test = 2; test <= 100; test++) {

			Long integ = Double.doubleToRawLongBits(test);

			byte[] b = new byte[8];
			for (int i = 0; i <= 7; i++) {
				b[i] = (byte) (integ >> i * 8);
				System.out.printf(displayFormatByteTable, i, b[i]);
			}

			ExtendedPrecision decoder = new ExtendedPrecision64(b);

			System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
			System.out.println(SANE_IEEE_754_EXPONENT
					+ decoder.getExponentValue());
			System.out.println(SANE_IEEE_754_SIGNIFICAND
					+ decoder.getSignificandValue());
			System.out.println("SANE IEEE 754 64 bits => "
					+ decoder.getDoubleValue());

			assert decoder.isPositive();
			assert decoder.getDoubleValue() == (double) test;

		}

	}

	@Test
	public void float_64bitsNaN() {

		Long integ = Double.doubleToRawLongBits(Double.NaN);

		byte[] b = new byte[8];
		for (int i = 0; i <= 7; i++) {
			b[i] = (byte) (integ >> i * 8);
			System.out.printf(displayFormatByteTable, i, b[i]);
		}

		ExtendedPrecision decoder = new ExtendedPrecision64(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println("SANE IEEE 754 64 bits => "
				+ decoder.getDoubleValue());

		assert decoder.isPositive();
		assert Double.isNaN(decoder.getDoubleValue());

	}

	@Test
	public void float_64bitsPI() {

		Long integ = Double.doubleToRawLongBits(Math.PI);

		byte[] b = new byte[8];
		for (int i = 0; i <= 7; i++) {
			b[i] = (byte) (integ >> i * 8);
			System.out.printf(displayFormatByteTable, i, b[i]);
		}

		ExtendedPrecision decoder = new ExtendedPrecision64(b);

		System.out.println(SANE_IEEE_754_POSITIVE + decoder.isPositive());
		System.out.println(SANE_IEEE_754_EXPONENT + decoder.getExponentValue());
		System.out.println(SANE_IEEE_754_SIGNIFICAND
				+ decoder.getSignificandValue());
		System.out.println("SANE IEEE 754 64 bits => "
				+ decoder.getDoubleValue());

		assert decoder.isPositive();
		assert decoder.getDoubleValue() == Math.PI;

	}
}
