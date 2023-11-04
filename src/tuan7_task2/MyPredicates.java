package tuan7_task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class MyPredicates {
	// Remove every object, obj, from coll for which p.test(obj)
	// is true. (This does the same thing as coll.removeIf(p).)
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		// TODO
		Iterator<T> iterator = coll.iterator();
		while (iterator.hasNext()) {
			T element = iterator.next();
			if (p.test(element)) {
				iterator.remove();
			}
		}
	}

	// Remove every object, obj, from coll for which
	// pr.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iterator = coll.iterator();
		while (iterator.hasNext()) {
			T element = iterator.next();
			if (p.test(element)==false) {
				iterator.remove();
			}
		}
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj)
	// is true.
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		
		Set<T>set=new HashSet<>();
		Iterator<T> iterator = coll.iterator();
		while (iterator.hasNext()) {
			T element = iterator.next();
			if (p.test(element)) {
				set.add(element);
			}
		}
		return set;
	}

	// Return the index of the first item in list
	// for which the predicate is true, if any.
	// If there is no such item, return -1.
	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		int result=-1;
		List<T>list=new ArrayList<>(coll);
		for(int i=0;i<list.size();i++) {
			if(p.test(list.get(i))) {
				result=i;
				break;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
//		remove(list, new Even());
		
		System.out.println(list);
//		retain(list, new Even());
//		System.out.println(list);
		
//		System.out.println(find(list, new Even()));
		System.out.println(collect(list, new Even()));
		
	}
}
