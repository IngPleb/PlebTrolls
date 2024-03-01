package com.staxzs.staxzstrolls.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Interval {
	private final int start;
	private final int end;

	////////////////////////////
	// Static factory methods
	////////////////////////////
	public static Interval of(int start, int end) {
		if (start > end) {
			throw new IllegalArgumentException("Start must be less than or equal to end.");
		}
		return new Interval(start, end);
	}

	////////////////////////////
	// Instance methods
	////////////////////////////

	public Set<Integer> toSet() {
		Set<Integer> set = new HashSet<>();

		for (int i = this.start; i <= this.end; i++) {
			set.add(i);
		}

		return Collections.unmodifiableSet(set);
	}

	public List<Integer> toList() {
		return List.copyOf(this.toSet());
	}

}
