package com.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Reduce {
	private static List<Integer> running = new LinkedList<>();
	private LinkedHashSet<LinkedHashSet<Integer>> master = new LinkedHashSet<>();
	private Map<Integer, Integer> runningMap = new HashMap<>();

	public static void main(String[] args) {
		running.addAll(Arrays.asList(new Integer[] { 3, 2, 1 }));
		Reduce r1 = new Reduce();
		System.out.println(r1.callAppend());
	}

	public LinkedHashSet<LinkedHashSet<Integer>> callAppend() {
		Integer index = 0;
		for (Integer i : running) {
			runningMap.put(i, index++);
		}
		return append(null);
	}

	public LinkedHashSet<LinkedHashSet<Integer>> append(LinkedHashSet<LinkedHashSet<Integer>> set) {
		LinkedHashSet<LinkedHashSet<Integer>> s1 = new LinkedHashSet<>();
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

	public void addToSet(LinkedHashSet<LinkedHashSet<Integer>> s1, Integer a1, LinkedHashSet<Integer> a2) {
		LinkedHashSet<Integer> a3 = new LinkedHashSet<>();
		a3.addAll(a2);
		if (runningMap.get(a1) == runningMap.get(new ArrayList<>(a2).get(a2.size()-1)) + 1 && a3.add(a1)) {
			s1.add(a3);
		}
	}
}
