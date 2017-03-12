package com.laptop.unlimit;

import java.util.Vector;

public class FibonacciUnlimit {

	private int site = 0;
	private Vector<Byte> item1 = new Vector<Byte>();
	private Vector<Byte> item2 = new Vector<Byte>();
	private Vector<Byte> item3 = new Vector<Byte>();

	public FibonacciUnlimit(int site) {
		this.site = site;
		item1.add((byte) 1);
		item2.add((byte) 1);
		item3.add((byte) 0);
	}

	public String toString() {
		return site + ": " + getFibonacci(site);
	}

	private String getFibonacci(int site) {
		sequence(site);
		Vector<Byte> vecResult = new Vector<Byte>();
		StringBuffer strResult = new StringBuffer();
		switch (site % 3) {
		case 0:
			vecResult = item3;
			break;
		case 1:
			vecResult = item1;
			break;
		case 2:
			vecResult = item2;
			break;
		default:
			break;
		}
		for (int i = vecResult.size() - 1; i >= 0; i--) {
			strResult.append(vecResult.get(i).toString());
		}
		return strResult.toString();
	}

	private void sequence(int site) {
		for (int i = 3; i <= site; i++) {
			switch (i % 3) {
			case 0:
				item3.clear();
				item3 = add(item1, item2);
				break;
			case 1:
				item1.clear();
				item1 = add(item2, item3);
				break;
			case 2:
				item2.clear();
				item2 = add(item3, item1);
				break;
			default:
				break;
			}
		}
	}

	private Vector<Byte> add(Vector<Byte> item1, Vector<Byte> item2) {
		boolean carryFlag = false;
		byte currentValue = (byte) 0;
		int size1 = item1.size();
		int size2 = item2.size();
		Vector<Byte> result = new Vector<>();

		for (int i = 0; i < size2; i++) {
			if (i == size1) {
				currentValue = (byte) (0 + item2.get(i) + (carryFlag ? 1 : 0));
			} else {
				currentValue = (byte) (item1.get(i) + item2.get(i) + (carryFlag ? 1 : 0));
			}
			carryFlag = false;
			if (currentValue > 9) {
				currentValue = (byte) (currentValue - 10);
				carryFlag = true;
				result.add(currentValue);
				if (i == size2 - 1) {
					result.add((byte) 1);
				}
			} else {
				result.add(currentValue);
			}
		}
		return result;
	}
}
