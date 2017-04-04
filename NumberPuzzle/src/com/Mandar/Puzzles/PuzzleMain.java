package com.Mandar.Puzzles;

import java.math.BigInteger;
import java.util.Scanner;

public class PuzzleMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// prompt for the range of numbers
		System.out.print("Enter the number Range: ");
		BigInteger range = scanner.nextBigInteger();

		// prompt for the Limiter
		System.out.print("Enter the limiter: ");
		BigInteger limit = scanner.nextBigInteger();
		
		Puzzle puzzle = new Puzzle();
		
		BigInteger total = puzzle.getTotalFromGivenRange(range, limit);
		System.out.println("The sum of numbers is: " + total);
		
		System.out.println("The following lines of code test the program for given inputs");
		
		BigInteger totalRange100 = puzzle.getTotalFromGivenRange(BigInteger.valueOf(100), BigInteger.valueOf(10));
		if(totalRange100.equals(new BigInteger("513946235090696089113"))){
			System.out.println("Test for Range 100 and limit 10 successful");
			System.out.println("Test for Range 100 and limit 10 answer is: "+ totalRange100);
		}
		BigInteger totalRange1000000 = puzzle.getTotalFromGivenRange(BigInteger.valueOf(1000000), BigInteger.valueOf(200));
		String firstTenDigits = totalRange1000000.toString().substring(0, 10);
		
		if(firstTenDigits.equalsIgnoreCase("4876116127")){
			System.out.println("Test for Range 1000000 and limit 200 successful");
			System.out.println("Test for Range 1000000 and limit 200 answer is (first 10 digits): "+ firstTenDigits);
		}
	}
}
