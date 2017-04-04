package com.Mandar.Puzzles;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Puzzle {

	public BigInteger getTotalFromGivenRange(BigInteger range, BigInteger limit) {
		BigInteger total = BigInteger.ZERO;
		List<BigInteger> prevIntegers = new ArrayList<BigInteger>();
		List<BigInteger> listOfNumbers = new ArrayList<BigInteger>(
				(Collections.nCopies(range.intValue(), BigInteger.ZERO)));
		for (int i = 0; i < range.intValue(); i++) {
			listOfNumbers.set(i, BigInteger.valueOf(i + 1));
		}
		for (BigInteger integer : listOfNumbers) {
			BigInteger multiply = BigInteger.ONE;
			if (listOfNumbers.indexOf(integer) == 0) {
				total = BigInteger.ZERO;
				prevIntegers.add(integer);
			} else if (listOfNumbers.indexOf(integer) == 1) {
				total = BigInteger.ONE;
				prevIntegers.add(integer);
			} else {
				if (prevIntegers.size() >= limit.intValue()) {
					for (int i = prevIntegers.size() - 1; i >= (prevIntegers.size() - limit.intValue()); i--) {
						//System.out.println("MAIN NUMBER: " + integer.intValue()+" "+"PREVIOUS NUMBER: " + prevIntegers.get(i).intValue());
						multiply = multiply.multiply(prevIntegers.get(i));
					}
					total = total.add(multiply);
				} else {
					for (BigInteger integer2 : prevIntegers) {
						//System.out.println("MAIN NUMBER: " + integer.intValue()+" "+"PREVIOUS NUMBER: " + integer2.intValue());
						multiply = multiply.multiply(integer2);
					}
					total = total.add(multiply);
				}
				prevIntegers.add(integer);
			}
			//System.out.println("TOTAL: " + total);
		}
		return total;
	}
}
