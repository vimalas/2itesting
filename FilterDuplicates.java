package com.twoi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class FilterDuplicates {
	
	//*** Assumptions ***
	// - Error needs to be thrown when values entered not between 1 and 100
	// - Error needs to be thrown when more than 10 values entered
	// - Remove all duplicates

	public static List<Integer> filter(List<Integer> numbers) {
		//remove duplicates by putting numbers in set class object
		Set<Integer> uniqueNumbers = new HashSet<>(numbers);
		//sort using java streams
		return uniqueNumbers.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		testFilter(List.of(33, 2, 9, 2, 3, 3, 8, 67, 34, 8), List.of(67, 34, 33, 9, 8, 5, 2));
		testFilter(List.of(33, 2, 9, 2, 3, 3, 8, 67, 34, 8), List.of(67, 34, 33, 9, 8, 3, 2));
		testFilter(List.of(3, 2, 9, 2, 3, 3, 8, 67, 34, 8), List.of(67, 34, 9, 8, 3, 2));
		testFilter(List.of(33, 2, 9, 2, 3, 3, 8, 8, 34, 8), List.of(34, 33, 9, 8, 3, 2));
		
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter 10 numbers between 1 to 100 (space between each number)");
        
        //capture input
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
        	int number = scanner.nextInt();
        	if (number < 1 || number > 100 ) {
        		System.out.println("*** Error - numbers between 1 to 100 are only allowed ***");
        		return;
        	}
        	numbers.add(number);
        }
        
        if (numbers.size() != 10) {
        	System.out.println("*** Error - 10 numbers must be entered ***");
        	return;
        }
        
        scanner.close();
        System.out.println("*** Output ***");
        System.out.println(filter(numbers));

	}
	
	public static void testFilter(List<Integer> numbers, List<Integer> expectedNumbers) {
		List<Integer> output = filter(numbers);
		for(int i = 0; i < output.size(); i++) {
			if (!output.get(i).equals(expectedNumbers.get(i))) {
				System.out.println("failed");
				return;
			}
		}
		System.out.println("passed");
	}
}
