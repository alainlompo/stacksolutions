package stack.commons.collections;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class TwoColumnsComparator  implements Comparator<User>{

	public int compare(User o1, User o2) {
		
		if (o1 == null || o2 == null) {
			return 0;
		} 
		
		if (!(o1.getFirstName().compareTo(o2.getFirstName()) ==0 )) {
			return o1.getFirstName().compareTo(o2.getFirstName());
		} else {
			return o1.getLastName().compareTo(o2.getLastName());
		}
		
	}

	public Comparator<User> reversed() {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<User> thenComparing(Comparator<? super User> other) {
		// TODO Auto-generated method stub
		return null;
	}

	public <U> Comparator<User> thenComparing(
			Function<? super User, ? extends U> keyExtractor,
			Comparator<? super U> keyComparator) {
		// TODO Auto-generated method stub
		return null;
	}

	public <U extends Comparable<? super U>> Comparator<User> thenComparing(
			Function<? super User, ? extends U> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<User> thenComparingInt(
			ToIntFunction<? super User> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<User> thenComparingLong(
			ToLongFunction<? super User> keyExtractor) {
		// TODO Auto-generated method stub
		return null;
	}

	public Comparator<User> thenComparingDouble(
			ToDoubleFunction<? super User> keyExtractor) {
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
