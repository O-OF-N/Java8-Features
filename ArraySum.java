package com.assignment;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Reduce {
	static List<Integer> running = new LinkedList<>();
	static Set<Set<Integer>> master = new HashSet<>();
	static int itr = -1;

	public static void main(String[] args) {
		running.addAll(Arrays.asList(new Integer[] { 1, 2, 3, 4 }));
		Reduce r1 = new Reduce();
		Set<Set<Integer>> integers = r1.append(null);
		System.out.println(integers);
	}

	public Set<Set<Integer>> append(Set<Set<Integer>> set) {
		Set<Set<Integer>> s1 = new HashSet<>();
		running.forEach(a1 -> {
			if (set != null && set.size() > 0)
				set.forEach(a2 -> {
					Set<Integer> a3 = new HashSet<>();
					if (a1 == Collections.max(a2) + 1 && a3.add(a1)) {
						a3.addAll(a2);
						s1.add(a3);
					}
				});
			else
				s1.add(new HashSet<>(Arrays.asList(a1)));
		});
		if (s1 != null && s1.size() > 0) {
			master.addAll(s1);
			append(s1);
		}
		return master;
	}
}
