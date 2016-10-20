package com.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class Reduce {
	private static List<Integer> running = new LinkedList<>();
	private LinkedList<LinkedHashSet<Integer>> master = new LinkedList<>();

	public static void main(String[] args) {
		running.addAll(Arrays.asList(new Integer[] { 15, 36, 27, 15 }));
		Reduce r1 = new Reduce();
		System.out.println(r1.callAppend());
	}

	public LinkedList<LinkedHashSet<Integer>> callAppend() {
		return append(null);
	}

	public LinkedList<LinkedHashSet<Integer>> append(LinkedList<LinkedHashSet<Integer>> set) {
		LinkedList<LinkedHashSet<Integer>> s1 = new LinkedList<>();
		running.forEach(a1 -> {
			if (set != null && set.size() > 0)
				set.forEach(a2 -> addToSet(s1, a1, a2));
			else
				s1.add(new LinkedHashSet<>(Arrays.asList(a1)));
		});
		if (s1 != null && s1.size() > 0) {
			master.addAll(s1);
			append(s1);
		}
		return master;
	}

	public void addToSet(LinkedList<LinkedHashSet<Integer>> s1, Integer a1, LinkedHashSet<Integer> a2) {
		LinkedHashSet<Integer> a3 = new LinkedHashSet<>();
		a3.addAll(a2);
		List<Integer> a2List = new ArrayList<>(a2);
		Integer last = a2List.get(a2.size()-1);
		if (running.indexOf(a1) == running.indexOf(last) + 1 && a3.add(a1)) {
			s1.add(a3);
		}
	}
}
