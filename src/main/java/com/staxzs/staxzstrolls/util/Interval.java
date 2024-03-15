package com.staxzs.staxzstrolls.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;

/**
 * The Interval class represents a range of integers defined by a start and an end point.
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Interval {
	private final int start;
	private final int end;

	////////////////////////////
	// Static factory methods
	////////////////////////////

	/**
	 * Static factory method to create an instance of Interval.
	 *
	 * @param start The start point of the interval. Must be less than or equal to end.
	 * @param end   The end point of the interval.
	 * @return An instance of Interval.
	 * @throws IllegalArgumentException if start is greater than end.
	 */
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
		return new ArrayList<>(this.toSet());
	}

}
