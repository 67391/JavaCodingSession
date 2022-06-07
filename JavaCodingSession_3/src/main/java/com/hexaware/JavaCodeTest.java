package com.hexaware;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;

import com.hexaware.pojo.Employee;

public class JavaCodeTest {

	public static void main(String[] args) {
		
		
		question1();
		question2();
		question3();
		question4();
		//question 5 was done in JavaCodingSession_2
		
	}
	
	private static void question1() {
		System.out.println("============QUESTION 1================");
		List<Integer> list = Arrays.asList(5, 13, 4, 21, 13, 27, 2, 59, 59, 34);
		Set<Integer> result = findDuplicates(list);
		result.forEach(System.out::println);
	}

	private static void question2() {
		System.out.println("============QUESTION 2================");
		List<Integer> list = Arrays.asList(1,1,2,5,5,4,4,2,2,2,3,3,3);
		Set<Integer> result = removeDuplicates(list);
		result.forEach(System.out::println);
	}

	

	private static void question3() {
		System.out.println("============QUESTION 3================");
		List<Integer> list = Arrays.asList(3,90,350,5);
		System.out.println("Max value is: "
                + Collections.max(list));
		
	}
	
	private static void question4() {
		System.out.println("============QUESTION 4================");
		List<Integer> list = Arrays.asList(3,90,350,5);
		
		System.out.println("MIN:"+list
					.stream()
	      			.mapToInt(v -> v)
	      			.min().getAsInt());
		
		System.out.println("MAX:"+list
			      	.stream()
			      	.mapToInt(v -> v)
			      	.max().getAsInt());
	}
	
	
	public static <Integer> Set<Integer> findDuplicates(List<Integer> list) {
		
        Set<Integer> items = new HashSet<>();
        return list.stream()
                .filter(n -> !items.add(n)) 
                .collect(Collectors.toSet());

    }
	
	private static Set<java.lang.Integer> removeDuplicates(List<java.lang.Integer> list) {

		 Set<Integer> items = new HashSet<>();
	        return list.stream()
	                .filter(n -> items.add(n)) 
	                .collect(Collectors.toSet());
	}
	

}
