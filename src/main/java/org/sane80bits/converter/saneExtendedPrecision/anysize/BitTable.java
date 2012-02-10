package org.sane80bits.converter.saneExtendedPrecision.anysize;

/**
* 
* Bit (<code>boolean</code>) table of any size
* 
* @author Jean-Pierre Delouche
* 
*/
public class BitTable {
	
	private boolean[] table;
	
	public BitTable(int size) {
		this.table = new boolean[size];
	}

	public void set(byte[] byteTable, int sizeInBytes, int basePosition, long lowOrderBit, int sizeByte) {
		
		for (int byteID = sizeInBytes - 1 ; byteID >= basePosition ; byteID--) {

			setByteInBitTable(byteTable, byteID, lowOrderBit, sizeByte);
		}
		
		
	}
	
	private void setByteInBitTable(byte[] byteTable, int byteID, long lowOrderBit, int sizeByte) {
		
		byte byteElement = byteTable[byteID];

		for (int bitPosition = sizeByte-1; bitPosition >= 0; bitPosition--) {
			byte maskBit = (byte) (lowOrderBit << bitPosition);
			byte bitID = (byte) (byteID * sizeByte + bitPosition);
			byte bitValue = (byte) (byteElement & maskBit);
			setBit( table, bitID, bitValue);
		}
	}
	
	private void setBit(boolean[] table, byte id, byte value) {
		if (value == 0) {
			table[id] = false;
		} else {
			table[id] = true;
		}
	}
	
	public boolean[] value() {
		return table;
	}

	public String toString() {
		
		StringBuilder s = new StringBuilder();
		for (int i = table.length-1; i >=0; i--) {
			if (table[i]) {
				s.append("1");
			} else {
				s.append("0");
			}
		}
		
		return s.toString();
		
	}

	public void set(int bitID, boolean b) {
		
		table[bitID] = b;
		
	}
	
}