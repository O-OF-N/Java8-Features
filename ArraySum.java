package com.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Reduce {
	private static List<Integer> running = new LinkedList<>();
	private LinkedList<LinkedList<Integer>> master = new LinkedList<>();
	private final Integer[] input = new Integer[] { 15, 36, 27, 15 };

	public static void main(String[] args) {
		Reduce r1 = new Reduce();
		System.out.println(r1.callAppend());
	}

	public LinkedList<LinkedList<Integer>> callAppend() {
		LinkedList<LinkedList<Integer>> result = new LinkedList<>();
		for (int i = 0; i < input.length; i++) {
			running.add(i);
		}
		append(null);
		for (LinkedList<Integer> a : master) {
			result.add(posToVal(a));
		}
		return result;
	}

	public final LinkedList<Integer> posToVal(LinkedList<Integer> intList) {
		LinkedList<Integer> result = new LinkedList<>();
		for (Integer a : intList) {
			result.add(input[a]);
		}
		return result;
	}

	public LinkedList<LinkedList<Integer>> append(LinkedList<LinkedList<Integer>> set) {
		LinkedList<LinkedList<Integer>> s1 = new LinkedList<>();
		running.forEach(a1 -> {
			if (set != null && set.size() > 0)
				set.forEach(a2 -> addToSet(s1, a1, a2));
			else
				s1.add(new LinkedList<>(Arrays.asList(a1)));
		});
		if (s1 != null && s1.size() > 0) {
			master.addAll(s1);
			append(s1);
		}
		return master;
	}

	public void addToSet(LinkedList<LinkedList<Integer>> s1, Integer a1, LinkedList<Integer> a2) {
		LinkedList<Integer> a3 = new LinkedList<>();
		a3.addAll(a2);
		List<Integer> a2List = new ArrayList<>(a2);
		Integer last = a2List.get(a2.size() - 1);
		if (running.indexOf(a1) == running.indexOf(last) + 1 && a3.add(a1)) {
			s1.add(a3);
		}
	}
}
