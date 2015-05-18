package stack.commons.collections;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class FacultyComparator implements Comparator<Faculty>{

	public int compare(Faculty o1, Faculty o2) {
		
		return o1.compareTo(o2);
	}

	public Comparator<Faculty> reversed() {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Faculty> thenComparing(Comparator<? super Faculty> other) {
		// TODO Auto-generated method stub
		return null;
	}

	public <U> Comparator<Faculty> thenComparing(
			Function<? super Faculty, ? extends U> keyExtractor,
			Comparator<? super U> keyComparator) {
		// TODO Auto-generated method stub
		return null;
	}

	public <U extends Comparable<? super U>> Comparator<Faculty> thenComparing(
			Function<? super Faculty, ? extends U> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Faculty> thenComparingInt(
			ToIntFunction<? super Faculty> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Faculty> thenComparingLong(
			ToLongFunction<? super Faculty> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<Faculty> thenComparingDouble(
			ToDoubleFunction<? super Faculty> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> nullsFirst(Comparator<? super T> comparator) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> nullsLast(Comparator<? super T> comparator) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T, U> Comparator<T> comparing(
			Function<? super T, ? extends U> keyExtractor,
			Comparator<? super U> keyComparator) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
			Function<? super T, ? extends U> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> comparingInt(
			ToIntFunction<? super T> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> comparingLong(
			ToLongFunction<? super T> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T> Comparator<T> comparingDouble(
			ToDoubleFunction<? super T> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

}
