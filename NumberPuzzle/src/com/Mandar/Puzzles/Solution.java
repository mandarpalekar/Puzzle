package com.Mandar.Puzzles;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numCases = sc.nextInt();
		Map<Integer,List<Integer>> allInput = new HashMap<Integer, List<Integer>>();
		Map<Integer,Integer> jumpMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < numCases; i++) {
			int size = sc.nextInt();
			int jump = sc.nextInt();
			sc.nextLine();
			String[] arrayOfNumbers = sc.nextLine().split(" ");
			List<Integer> numbers = new ArrayList<Integer>((Collections.nCopies(size, 0)));
			for (int j = 0; j < arrayOfNumbers.length; j++) {
				numbers.set(j, Integer.parseInt(arrayOfNumbers[j]));
			}
			allInput.put(i + 1, numbers);
			jumpMap.put(i + 1,jump);
		}
		for (Map.Entry<Integer,List<Integer>> entry : allInput.entrySet()) {
			if (traverseList(entry.getValue(), jumpMap.get(entry.getKey()))) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
	}
	
	public static boolean traverseList(List<Integer> numbers, int jump) {
		boolean result = false;
		List<Boolean> isTraversed = new ArrayList<Boolean>((Collections.nCopies(numbers.size(), false)));		
		int currentPosition = 0;
		boolean moveAhead = true;
		isTraversed.set(0, true);
		while (moveAhead) {
			if ((currentPosition + jump) > (numbers.size() - 1)) {
				return true;
			}else{
				if (numbers.get(currentPosition + jump) == 0) {
					currentPosition = currentPosition + jump;
					isTraversed.set(currentPosition, true);
					if ((currentPosition + jump) > (numbers.size() - 1)) {
						return true;
					}
				}
				else if (numbers.get(currentPosition + 1) == 0) {
					currentPosition = currentPosition + 1;
					isTraversed.set(currentPosition, true);
					if ((currentPosition + jump) > (numbers.size() - 1)) {
						return true;
					}
				}
				else {
					if(currentPosition != 0){
						if(isTraversed.get(currentPosition - 1)){
							return false;
						}else{
							currentPosition = currentPosition - 1;
							isTraversed.set(currentPosition, true);
						}						
					}else{
						return false;
					}
				}
			}
			
		}
		return result;
	}
}