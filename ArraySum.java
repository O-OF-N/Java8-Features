package com.assignment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ArraySum {
	private static int sum = 0;
	public static void main(String[] args) {
		Integer[] arr = new Integer[]{1,2,3};
 		List<Integer> intList = new LinkedList<>(Arrays.asList(arr));
		List<Integer> sumList = intList.stream().map((Integer i)-> sum +=i)
				.filter(i->i!=intList.get(0))
				.collect(Collectors.toList());
		intList.addAll(sumList);
		System.out.println(intList);
	}

}
